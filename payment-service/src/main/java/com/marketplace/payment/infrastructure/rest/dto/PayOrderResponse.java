package com.marketplace.payment.infrastructure.rest.dto;

import java.util.UUID;

public class PayOrderResponse {
    private UUID orderId;
    private String message;

    public PayOrderResponse(UUID orderId, String message) {
        this.orderId = orderId;
        this.message = message;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getMessage() {
        return message;
    }
}
