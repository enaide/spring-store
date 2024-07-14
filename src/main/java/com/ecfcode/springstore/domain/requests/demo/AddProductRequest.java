package com.ecfcode.springstore.domain.requests.demo;

import com.ecfcode.springstore.domain.models.ProductDO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddProductRequest(@JsonProperty("product") ProductDO product) {
    public AddProductRequest{
        Objects.requireNonNull(product);
    }
}
