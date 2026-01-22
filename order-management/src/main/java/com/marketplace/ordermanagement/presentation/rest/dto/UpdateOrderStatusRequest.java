package com.marketplace.ordermanagement.presentation.rest.dto;

import com.marketplace.ordermanagement.domain.model.OrderStatus;

public class UpdateOrderStatusRequest {
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
