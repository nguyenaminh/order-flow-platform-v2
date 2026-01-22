package com.marketplace.ordermanagement.presentation.rest;


import com.marketplace.ordermanagement.application.OrderApplicationService;
import com.marketplace.ordermanagement.domain.model.Order;
import com.marketplace.ordermanagement.presentation.rest.dto.CreateOrderResponse;
import com.marketplace.ordermanagement.presentation.rest.dto.OrderResponse;
import com.marketplace.ordermanagement.presentation.rest.dto.UpdateOrderStatusRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderApplicationService service;

    public OrderController(OrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder() {
        Order order = service.createOrder();

        CreateOrderResponse response = new CreateOrderResponse(order.getOrderId(), order.getStatus());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = service.getAllOrders().stream()
                .map(order -> new OrderResponse(order.getOrderId(), order.getStatus()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID orderId) {
        return service.getOrderById(orderId)
                .map(order -> ResponseEntity.ok(new OrderResponse(order.getOrderId(), order.getStatus())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<OrderResponse> updateOrderStatus(
            @PathVariable UUID orderId,
            @RequestBody UpdateOrderStatusRequest request) {
        return service.updateOrderStatus(orderId, request.getStatus())
                .map(order -> ResponseEntity.ok(new OrderResponse(order.getOrderId(), order.getStatus())))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID orderId) {
        service.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
