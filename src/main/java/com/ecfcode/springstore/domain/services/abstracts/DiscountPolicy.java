package com.ecfcode.springstore.domain.services.abstracts;

import com.ecfcode.springstore.domain.models.OrderDO;

public interface DiscountPolicy {
    double discount(OrderDO order);
}
