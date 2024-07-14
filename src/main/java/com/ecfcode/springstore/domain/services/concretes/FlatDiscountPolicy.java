package com.ecfcode.springstore.domain.services.concretes;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.services.abstracts.DiscountPolicy;

public class FlatDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(OrderDO order) {
        return 0.01;
    }
}
