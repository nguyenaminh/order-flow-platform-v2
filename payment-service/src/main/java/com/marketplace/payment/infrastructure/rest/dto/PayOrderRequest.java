package com.marketplace.payment.infrastructure.rest.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class PayOrderRequest {
    @NotNull
    private UUID orderId;

    public PayOrderRequest() {}

    public PayOrderRequest(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
