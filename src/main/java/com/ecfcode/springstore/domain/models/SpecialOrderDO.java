package com.ecfcode.springstore.domain.models;

import com.ecfcode.springstore.domain.services.abstracts.SpecialDiscountPolicy;

import java.util.List;

public class SpecialOrderDO extends OrderDO {

    private final boolean eligibleForExtraDiscount;

    public SpecialOrderDO(List<OrderLineDO> orderLines) {
        super(orderLines);
        this.eligibleForExtraDiscount = false;
    }

    public SpecialOrderDO(List<OrderLineDO> orderLines, boolean eligibleForSpecialDiscount) {
        super(orderLines);
        this.eligibleForExtraDiscount = eligibleForSpecialDiscount;
    }

    public boolean isEligibleForExtraDiscount() {
        return eligibleForExtraDiscount;
    }

    @Override
    protected double applyDiscountPolicy(SpecialDiscountPolicy discountPolicy) {
        return discountPolicy.discount(this);
    }
}
