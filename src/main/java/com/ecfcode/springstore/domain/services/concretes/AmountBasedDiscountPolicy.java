package com.ecfcode.springstore.domain.services.concretes;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.services.abstracts.DiscountPolicy;

import java.math.BigDecimal;

public class AmountBasedDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(OrderDO order) {
        if (order.totalCost().compareTo(BigDecimal.valueOf(500.00)) > 0) {
            return 0.10;
        } else
            return 0;
    }
}
