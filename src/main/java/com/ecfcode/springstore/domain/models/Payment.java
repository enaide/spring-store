package com.ecfcode.springstore.domain.models;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {

    private Long paymentId;

    private OrderDO orderDO;

    private BigDecimal amount;

    private Currency currency;

    private String source;

    private String description;

    public Payment(Long paymentId,
                   OrderDO orderDO,
                   BigDecimal amount,
                   String source,
                   String description) {
        this.paymentId = paymentId;
        this.orderDO = orderDO;
        this.amount = amount;
        this.source = source;
        this.description = description;
    }


}
