package com.marketplace.payment.infrastructure.rest;

import com.marketplace.payment.infrastructure.rest.dto.PayOrderRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.UUID;

@Component
public class FulfillmentClient {

    private final RestTemplate restTemplate;

    public FulfillmentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void notifyPaid(UUID orderId) {
        String url = "http://localhost:8082/internal/fulfillment/orders";
        PayOrderRequest request = new PayOrderRequest(orderId);
        restTemplate.postForEntity(url, request, Void.class);
    }
}

