package com.ecfcode.springstore.domain.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDO {

    private final Long productId;
    private String productName;
    private Long supplier_id;
    private Long category_id;
    private String quantityPerUnit ;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorder_level;
    private int discontinued;

    @JsonCreator
    public ProductDO(
            @JsonProperty("id") final Long productId,
            @JsonProperty("unitPrice") final BigDecimal unitPrice) {

        this.productId = productId;
        this.unitPrice = unitPrice;
    }

    @JsonCreator
    public ProductDO(
            @JsonProperty("id") final Long productId,
            @JsonProperty("productName") String productName,
            @JsonProperty("supplier_id") Long supplier_id,
            @JsonProperty("category_id") Long category_id,
            @JsonProperty("quantityPerUnit") String quantityPerUnit,
            @JsonProperty("unitPrice") BigDecimal unitPrice,
            @JsonProperty("unitsInStock") int unitsInStock,
            @JsonProperty("unitsOnOrder") int unitsOnOrder,
            @JsonProperty("reorder_level") int reorder_level,
            @JsonProperty("discontinued") int discontinued
            ) {

        this.productId = productId;
        this.productName = productName;
        this.supplier_id = supplier_id;
        this.category_id = category_id;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorder_level = reorder_level;
        this.discontinued = discontinued;

    }

}
