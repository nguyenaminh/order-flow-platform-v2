package com.marketplace.orderfulfillment.infrastructure;

import com.marketplace.orderfulfillment.domain.Order;
import com.marketplace.orderfulfillment.domain.OrderRepository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<UUID, Order> store = new ConcurrentHashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.getOrderId(),  order);
    }

    @Override
    public Optional<Order> findById(UUID orderId) {
        return Optional.ofNullable(store.get(orderId));
    }
}
