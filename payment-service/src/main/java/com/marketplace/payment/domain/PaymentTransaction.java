package com.marketplace.payment.domain;

public class PaymentTransaction {
    private final String orderId;
    private PaymentStatus status = PaymentStatus.INITIATED;

    public PaymentTransaction(String orderId) {
        this.orderId = orderId;
    }

    public void succeed() {
        status = PaymentStatus.SUCCEEDED;
    }

    public void fail() {
        status = PaymentStatus.FAILED;
    }
}