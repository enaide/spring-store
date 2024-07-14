package com.ecfcode.springstore.domain.services.abstracts;

import com.ecfcode.springstore.domain.models.SpecialOrderDO;

public interface SpecialDiscountPolicy extends DiscountPolicy {
    double discount(SpecialOrderDO order);
}
