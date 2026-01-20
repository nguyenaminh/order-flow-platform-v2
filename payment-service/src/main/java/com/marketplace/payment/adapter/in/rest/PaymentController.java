package com.marketplace.payment.adapter.in.rest;

import org.springframework.web.bind.annotation.*;
import com.marketplace.payment.application.PaymentApplicationService;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentApplicationService service;

    public PaymentController(PaymentApplicationService service) {
        this.service = service;
    }

    @PostMapping("/{orderId}/succeed")
    public void succeed(@PathVariable UUID orderId) {
        service.succeedPayment(orderId);
    }

    @PostMapping("/{orderId}/fail")
    public void fail(@PathVariable UUID orderId) {
        service.failPayment(orderId);
    }
}
