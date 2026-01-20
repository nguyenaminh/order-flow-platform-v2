package com.marketplace.payment.infrastructure.config;

import com.marketplace.payment.application.PaymentApplicationService;
import com.marketplace.payment.application.PaymentApplicationServiceImpl;
import com.marketplace.payment.domain.PaymentTransactionRepository;
import com.marketplace.payment.infrastructure.persistence.InMemoryPaymentTransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentTransactionRepository paymentTransactionRepository() {
        return new InMemoryPaymentTransactionRepository();
    }

    @Bean
    public PaymentApplicationService  paymentApplicationService(PaymentTransactionRepository repository) {
        return new PaymentApplicationServiceImpl(repository);
    }
}
