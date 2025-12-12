package com.app.ecom.service;

import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.model.CartItem;
import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import com.app.ecom.repository.CartItemRepository;
import com.app.ecom.repository.ProductRepository;
import com.app.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public boolean addToCart(String userId, CartItemRequest request) {
        // looking for Product
        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        // checking for product
        if(productOpt.isEmpty()) {
            return false;
        }

        // if product found
        Product product = productOpt.get();
        // if product quantity is less than requested quantity
        if(product.getStockQuantity() < request.getQuantity()) {
            return false;
        }

        // looking for user
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        // if user doesn't exists
        if(userOpt.isEmpty()) {
            return false;
        }
        // if user found
        User user = userOpt.get();

        // if cartItem already exists in the DB fetch it
        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);
        // if not null update cart item quantity
        if(existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
            existingCartItem.setPrice(product.getPrice() .multiply(BigDecimal.valueOf(existingCartItem.getQuantity())));
            cartItemRepository.save(existingCartItem);
        } else {    // add to that new cart item to cart
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setPrice(product.getPrice() .multiply(BigDecimal.valueOf(request.getQuantity())));
            cartItemRepository.save(cartItem);
        }
        return true;
    }
}

