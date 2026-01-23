package com.marketplace.orderfulfillment.application;

import com.marketplace.orderfulfillment.domain.model.FulfillmentOrder;
import com.marketplace.orderfulfillment.domain.repository.FulfillmentOrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FulfillmentApplicationService {
    private final FulfillmentOrderRepository repository;

    public FulfillmentApplicationService(FulfillmentOrderRepository repository) {
        this.repository = repository;
    }

    // Payment -> Fulfillment
    public void receivePaidOrder(UUID orderId) {
        // Idempotency protection
        if (repository.existsById(orderId)) {
            return;
        }

        FulfillmentOrder order = new FulfillmentOrder(orderId);
        repository.save(order);
    }

    // Fulfillment flow
    public void startShipping(UUID orderId) {
        FulfillmentOrder order = load(orderId);
        order.startShipping();
        repository.save(order);
    }

    public void markDelivered(UUID orderId) {
        FulfillmentOrder order = load(orderId);
        order.markDelivered();
        repository.save(order);
    }

    public void markFailed(UUID orderId) {
        FulfillmentOrder order = load(orderId);
        order.markFailed();
        repository.save(order);
    }

    private FulfillmentOrder load(UUID orderId) {
        return repository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException(
                        "Fulfillment order not found: " + orderId
                ));
    }
}
