package com.bvr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bvr.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
