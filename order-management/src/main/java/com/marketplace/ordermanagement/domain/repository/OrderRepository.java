package com.marketplace.ordermanagement.domain.repository;

import com.marketplace.ordermanagement.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order save(Order order);

    Optional<Order> findById(UUID orderId);
}
