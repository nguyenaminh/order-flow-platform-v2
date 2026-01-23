package com.marketplace.payment.application;

import com.marketplace.payment.domain.model.PaymentOrder;
import com.marketplace.payment.domain.repository.PaymentRepository;
import com.marketplace.payment.infrastructure.rest.FulfillmentClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentApplicationService {

    private final PaymentRepository repository;
    private final FulfillmentClient fulfillmentClient;

    public PaymentApplicationService(
            PaymentRepository repository,
            FulfillmentClient fulfillmentClient) {
        this.repository = repository;
        this.fulfillmentClient = fulfillmentClient;
    }

    public void pay(UUID orderId) {
        if (repository.existsById(orderId)) {
            throw new IllegalStateException("Already paid");
        }

        PaymentOrder order = new PaymentOrder(orderId);

        // giả lập thanh toán thành công
        order.markPaid();
        repository.save(order);

        // notify fulfillment
        fulfillmentClient.notifyPaid(orderId);
    }
}
