package com.marketplace.orderfulfillment.domain;

public class Order {
    private final String orderId;
    private OrderStatus status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.CREATED;
    }

    public void validate() {
        if (status != OrderStatus.CREATED) throw new IllegalStateException();
        status = OrderStatus.VALIDATED;
    }

    public void markPaid() {
        if (status != OrderStatus.VALIDATED) throw new IllegalStateException();
        status = OrderStatus.PAID;
    }

    public void ship() {
        if (status != OrderStatus.PAID) throw new IllegalStateException();
        status = OrderStatus.SHIPPING;
    }

    public void complete() {
        if (status != OrderStatus.SHIPPING) throw new IllegalStateException();
        status = OrderStatus.COMPLETED;
    }
}