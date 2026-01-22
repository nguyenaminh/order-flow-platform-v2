package com.marketplace.ordermanagement.application;

import com.marketplace.ordermanagement.domain.model.Order;
import com.marketplace.ordermanagement.domain.model.OrderStatus;
import com.marketplace.ordermanagement.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderApplicationService {
    private final OrderRepository repository;

    public OrderApplicationService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder() {
        UUID orderId = UUID.randomUUID();
        Order order = new Order(orderId);
        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Optional<Order> getOrderById(UUID orderId) {
        return repository.findById(orderId);
    }

    public Optional<Order> updateOrderStatus(UUID orderId, OrderStatus status) {
        return repository.findById(orderId).map(order -> {
            order.setStatus(status);
            return repository.save(order);
        });
    }

    public void deleteOrder(UUID orderId) {
        repository.deleteById(orderId);
    }
}
