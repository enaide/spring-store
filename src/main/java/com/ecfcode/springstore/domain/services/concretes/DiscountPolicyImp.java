package com.ecfcode.springstore.domain.services.concretes;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.SpecialOrderDO;
import com.ecfcode.springstore.domain.services.abstracts.SpecialDiscountPolicy;

public class DiscountPolicyImp implements SpecialDiscountPolicy {
    @Override
    public double discount(OrderDO order) {
        return 0;
    }

    @Override
    public double discount(SpecialOrderDO order) {
        if (order.isEligibleForExtraDiscount())
            return 0.20;
        return 0.10;
    }
}
