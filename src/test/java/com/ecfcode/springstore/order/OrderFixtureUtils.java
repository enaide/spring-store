package com.ecfcode.springstore.order;

import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.domain.models.ProductDO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OrderFixtureUtils {
    public static List<OrderLineDO> anyOrderLines() {
        return Arrays.asList(new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(100)), 1));
    }

    public static List<OrderLineDO> orderLineItemsWorthNDollars(int totalCost) {
        return Arrays.asList(new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(totalCost)), 1));
    }

}
