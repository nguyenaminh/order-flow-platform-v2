package com.marketplace.shipping.domain;

public class Shipment {
    private final String orderId;
    private ShipmentStatus status = ShipmentStatus.CREATED;

    public Shipment(String orderId) {
        this.orderId = orderId;
    }

    public void ship() {
        status = ShipmentStatus.SHIPPED;
    }

    public void deliver() {
        status = ShipmentStatus.DELIVERED;
    }
}