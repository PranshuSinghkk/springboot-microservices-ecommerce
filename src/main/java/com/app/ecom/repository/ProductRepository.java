package com.app.ecom.repository;

import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();   // this method doesnt exists in JpaRepo but its smart enough to get and idea for what we are creating this method for by writing method name in a certain manner...

}
