package com.marketplace.ordermanagement.domain.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    protected Order() {}

    public Order(UUID orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.CREATED;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Tạm thời
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
