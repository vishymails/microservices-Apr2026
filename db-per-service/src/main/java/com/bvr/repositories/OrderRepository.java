package com.bvr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bvr.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
