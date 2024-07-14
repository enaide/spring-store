package com.ecfcode.springstore.domain.services.abstracts;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.domain.models.ProductDO;

import java.util.List;

public interface OrderService {
    Long createOrder(List<OrderLineDO> orderLine);

    void addProduct(Long id, ProductDO product);

    void deleteProduct(Long id, Long productId);

    void addOrderLine(Long id, OrderLineDO orderLine);

    void deleteOrderLine(Long id, Long orderLine);

    void completeOrder(Long id);

    OrderDO fetchOrder(Long id);
}
