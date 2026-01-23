package com.marketplace.orderfulfillment.presentation.rest.dto;

import java.util.UUID;

public class ReceivePaidOrderRequest {
    private UUID orderId;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
