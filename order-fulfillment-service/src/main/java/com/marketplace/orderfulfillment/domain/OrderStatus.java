package com.marketplace.orderfulfillment.domain;

public enum OrderStatus {
    CREATED,
    VALIDATED,
    PAID,
    SHIPPING,
    COMPLETED,
    FAILED,
    CANCELLED
}