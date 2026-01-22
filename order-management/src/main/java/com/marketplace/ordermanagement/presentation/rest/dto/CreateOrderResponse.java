package com.marketplace.ordermanagement.presentation.rest.dto;

import com.marketplace.ordermanagement.domain.model.OrderStatus;

import java.util.UUID;

public class CreateOrderResponse {
    private UUID orderId;
    private OrderStatus status;

    public CreateOrderResponse(UUID orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
