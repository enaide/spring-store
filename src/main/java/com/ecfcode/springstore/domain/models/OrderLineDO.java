package com.ecfcode.springstore.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineDO {

    private Long orderLineId;
    private final ProductDO product;
    private BigDecimal discount;
    private final int quantity;
    private BigDecimal unitPrice;
//    @JsonIgnore
//    private OrderDO order;

    @JsonCreator
    public OrderLineDO(
            @JsonProperty("product") final ProductDO product,
            @JsonProperty("quantity") final int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    @JsonCreator
    public OrderLineDO(
            @JsonProperty("orderLineId") final Long orderLineId,
            @JsonProperty("product") final ProductDO product,
            @JsonProperty("discount") final BigDecimal discount,
            @JsonProperty("quantity") final int quantity,
            @JsonProperty("unitPrice") BigDecimal unitPrice) {

        this.orderLineId = orderLineId;
        this.product = product;
        this.discount = discount;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @JsonCreator
    public OrderLineDO(
            @JsonProperty("order") final OrderDO order,
            @JsonProperty("product") final ProductDO product,
            @JsonProperty("discount") final BigDecimal discount,
            @JsonProperty("quantity") final int quantity,
            @JsonProperty("unitPrice") BigDecimal unitPrice) {

        this.orderLineId = order.getOrderId();
//        this.order = order;
        this.product = product;
        this.discount = discount;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    BigDecimal cost() {
        return product.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
