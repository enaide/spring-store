package com.ecfcode.springstore.domain.repository;

import com.ecfcode.springstore.domain.models.OrderDO;

import java.util.Optional;

public interface OrderRepositoryDO {
    Optional<OrderDO> findById(Long id);
    OrderDO save(OrderDO order);
}
