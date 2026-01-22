package com.marketplace.payment.application;

import com.marketplace.payment.domain.model.PaymentIntent;
import com.marketplace.payment.domain.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentApplicationService {
    private final PaymentRepository repository;

    public PaymentApplicationService(PaymentRepository repository) {
        this.repository = repository;
    }

    // Order Management -> Payment
    public PaymentIntent createPayment(UUID orderId) {
        repository.findByOrderId(orderId).ifPresent(p -> {
            throw new IllegalStateException("Payment already exists");
        });

        PaymentIntent payment = new PaymentIntent(orderId);
        return repository.save(payment);
    }

    // Internal Simulation / Gateway callback
    public void markPaymentSucceeded(UUID orderId) {
        PaymentIntent payment = repository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalStateException("Payment not found"));

        payment.markSucceeded();
        repository.save(payment);
    }

    public void markPaymentFailed(UUID orderId) {
        PaymentIntent payment = repository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalStateException("Payment not found"));

        payment.markFailed();
        repository.save(payment);
    }
}
