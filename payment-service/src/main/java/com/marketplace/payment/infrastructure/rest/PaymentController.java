package com.marketplace.payment.infrastructure.rest;

import com.marketplace.payment.application.PaymentApplicationService;
import com.marketplace.payment.infrastructure.rest.dto.PayOrderRequest;
import com.marketplace.payment.infrastructure.rest.dto.PayOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentApplicationService service;

    public PaymentController(PaymentApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PayOrderResponse> pay(@RequestBody PayOrderRequest request) {
        System.out.println("PAY called with: " + request.getOrderId());
        service.pay(request.getOrderId());
        return ResponseEntity.ok(
                new PayOrderResponse(
                        request.getOrderId(),
                        "Payment successful. Order forwarded to fulfillment."
                )
        );
    }
}
