package com.marketplace.ordermanagement.presentation.rest.dto;

import com.marketplace.ordermanagement.domain.model.OrderStatus;

import java.util.UUID;

public class OrderResponse {
    private UUID orderId;
    private OrderStatus status;

    public OrderResponse(UUID orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
