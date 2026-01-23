package com.marketplace.payment.domain.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentOrder {

    @Id
    private UUID paymentId;

    @Column(nullable = false)
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    protected PaymentOrder() {}

    public PaymentOrder(UUID orderId) {
        this.paymentId = UUID.randomUUID();
        this.orderId = orderId;
        this.status = PaymentStatus.INITIATED;
    }

    public void markPaid() {
        if (status != PaymentStatus.INITIATED) {
            throw new IllegalStateException("Payment already processed");
        }
        this.status = PaymentStatus.PAID;
    }

    public void markFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
