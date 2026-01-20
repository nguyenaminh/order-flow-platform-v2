package com.marketplace.payment.application;

import java.util.UUID;

public interface PaymentApplicationService {

    void succeedPayment(UUID orderId);

    void failPayment(UUID orderId);
}
