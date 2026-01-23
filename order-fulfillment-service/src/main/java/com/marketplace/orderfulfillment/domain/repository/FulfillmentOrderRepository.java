package com.marketplace.orderfulfillment.domain.repository;

import com.marketplace.orderfulfillment.domain.model.FulfillmentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FulfillmentOrderRepository extends JpaRepository<FulfillmentOrder, UUID> {
}
