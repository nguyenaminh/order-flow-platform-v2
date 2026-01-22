package com.marketplace.payment.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;

public class PaymentIntent {

    @Id
    private UUID paymentId;

    @Column(nullable = false, unique = true)
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Instant createdAt;
    private Instant completedAt;

    protected PaymentIntent() {}

    public PaymentIntent(UUID orderId) {
        this.paymentId = UUID.randomUUID();
        this.orderId = orderId;
        this.status = PaymentStatus.PENDING;
        this.createdAt = Instant.now();
    }

    public void markSucceeded() {
        if (this.status != PaymentStatus.PENDING) {
            throw new IllegalStateException("Payment already completed.");
        }
        this.status = PaymentStatus.SUCCEEDED;
    }

    public void markFailed() {
        if (this.status != PaymentStatus.PENDING) {
            throw new IllegalStateException("Payment already completed.");
        }
        this.status = PaymentStatus.FAILED;
        this.completedAt = Instant.now();
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

}
