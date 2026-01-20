package com.marketplace.payment.domain;

import java.util.Optional;
import java.util.UUID;

public interface PaymentTransactionRepository {

    Optional<PaymentTransaction> findByOrderId(UUID orderId);

    PaymentTransaction save(PaymentTransaction paymentTransaction);
}
