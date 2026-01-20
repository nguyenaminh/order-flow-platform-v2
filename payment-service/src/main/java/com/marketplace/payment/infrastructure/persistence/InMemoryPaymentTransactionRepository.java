package com.marketplace.payment.infrastructure.persistence;

import com.marketplace.payment.domain.PaymentTransaction;
import com.marketplace.payment.domain.PaymentTransactionRepository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPaymentTransactionRepository implements PaymentTransactionRepository {

    private final Map<UUID, PaymentTransaction> store = new ConcurrentHashMap<>();

    @Override
    public Optional<PaymentTransaction> findByOrderId(UUID orderId) {
        return  Optional.ofNullable(store.get(orderId));
    }

    @Override
    public PaymentTransaction save(PaymentTransaction tx) {
        store.put(tx.getOrderId(), tx);
        return tx;
    }
}
