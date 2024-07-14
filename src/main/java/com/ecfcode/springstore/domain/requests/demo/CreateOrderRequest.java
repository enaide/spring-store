package com.ecfcode.springstore.domain.requests.demo;

import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record CreateOrderRequest(@JsonProperty("orderLine") OrderLineDO orderLine) {
    public CreateOrderRequest{
        Objects.requireNonNull(orderLine);
    }
}
