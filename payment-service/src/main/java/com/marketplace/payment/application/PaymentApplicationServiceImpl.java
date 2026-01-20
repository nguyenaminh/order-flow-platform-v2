package com.marketplace.payment.application;

import com.marketplace.payment.domain.PaymentTransaction;
import com.marketplace.payment.domain.PaymentTransactionRepository;

import java.util.UUID;

public class PaymentApplicationServiceImpl implements PaymentApplicationService{
    private final PaymentTransactionRepository repository;

    public PaymentApplicationServiceImpl(PaymentTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void succeedPayment(UUID orderId) {
        PaymentTransaction tx = repository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalStateException("Payment transaction not found for orderId: " + orderId));
        tx.succeed();
        repository.save(tx);
    }

    @Override
    public void failPayment(UUID orderId) {
        PaymentTransaction tx = repository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalStateException("Payment transaction not found for orderId: " + orderId));
        tx.fail();
        repository.save(tx);
    }
}
