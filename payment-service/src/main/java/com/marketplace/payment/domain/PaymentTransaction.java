package com.marketplace.payment.domain;

import java.util.UUID;

public class PaymentTransaction {
    private final UUID orderId;
    private PaymentStatus status = PaymentStatus.INITIATED;

    public PaymentTransaction(UUID orderId) {
        this.orderId = orderId;
    }

    public void succeed() {
        if (status != PaymentStatus.INITIATED) {
            throw new IllegalStateException("Payment is not in INITIATED state");
        }
        status = PaymentStatus.SUCCEEDED;
    }

    public void fail() {
        if (status != PaymentStatus.INITIATED) {
            throw new IllegalStateException("Payment is not in INITIATED state");
        }
        status = PaymentStatus.FAILED;
    }

    public UUID getOrderId() {
        return orderId;
    }
}