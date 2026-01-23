package com.marketplace.orderfulfillment.presentation.rest;

import com.marketplace.orderfulfillment.application.FulfillmentApplicationService;
import com.marketplace.orderfulfillment.presentation.rest.dto.ReceivePaidOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/internal/fulfillment/orders")
public class FulfillmentController {
    private static final Logger logger = LoggerFactory.getLogger(FulfillmentController.class);

    private final FulfillmentApplicationService service;

    public FulfillmentController(FulfillmentApplicationService service) {
        this.service = service;
    }

    // Order Management ( Or Payment ) call
    @PostMapping
    public ResponseEntity<Void> receivePaidOrder(@RequestBody ReceivePaidOrderRequest request) {
        service.receivePaidOrder(request.getOrderId());
        logger.info("Order {}: status -> RECEIVED", request.getOrderId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{orderId}/ship")
    public ResponseEntity<Void> startShipping(@PathVariable UUID orderId) {
        service.startShipping(orderId);
        logger.info("Order {}: status -> SHIPPING_STARTED", orderId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/deliver")
    public ResponseEntity<Void> markDelivered(@PathVariable UUID orderId) {
        service.markDelivered(orderId);
        logger.info("Order {}: status -> DELIVERED", orderId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/fail")
    public ResponseEntity<Void> markFailed(@PathVariable UUID orderId) {
        service.markFailed(orderId);
        logger.info("Order {}: status -> FAILED", orderId);
        return ResponseEntity.ok().build();
    }
}
