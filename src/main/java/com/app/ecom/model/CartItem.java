package com.app.ecom.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne   // many CartItems belong to one User.
    @JoinColumn(name="user_id", nullable = false)       // nullable- A CartItem must always be linked to a user.
    private User user;

    @ManyToOne  // Many CartItems can be linked to ONE Product.
    @JoinColumn(name="product_id", nullable = false)    // nullable- A CartItem must always have a product.
    private Product product;

    private Integer quantity;
    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
