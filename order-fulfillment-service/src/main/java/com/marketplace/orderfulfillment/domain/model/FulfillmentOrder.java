package com.marketplace.orderfulfillment.domain.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "fulfillment_orders")
public class FulfillmentOrder {
    @Id
    private UUID orderId;  // reference only

    @Enumerated(EnumType.STRING)
    private FulfillmentStatus status;

    private Instant receivedAt;
    private Instant completedAt;

    protected FulfillmentOrder() {}

    // ENTRY POINT
    public FulfillmentOrder(UUID orderId) {
        this.orderId = orderId;
        this.status = FulfillmentStatus.PAID;
        this.receivedAt = Instant.now();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public FulfillmentStatus getStatus() {
        return status;
    }

    // DOMAIN BEHAVIORS

    public void startShipping() {
        if (status != FulfillmentStatus.PAID) {
            throw new IllegalStateException(
                    "Only PAID order can start shipping. Current: " + status
            );
        }
        this.status = FulfillmentStatus.SHIPPING;
    }

    public void markDelivered() {
        if (status != FulfillmentStatus.SHIPPING) {
            throw new IllegalStateException(
                    "Only SHIPPING order can be delivered. Current: " + status
            );
        }
        this.status = FulfillmentStatus.DELIVERED;
    }

    public void markFailed() {
        if (status == FulfillmentStatus.DELIVERED) {
            throw new IllegalStateException(
                    "Delivered order cannot be failed"
            );
        }
        this.status = FulfillmentStatus.FAILED;
    }
}
