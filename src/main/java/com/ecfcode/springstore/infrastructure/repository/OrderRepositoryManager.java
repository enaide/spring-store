package com.ecfcode.springstore.infrastructure.repository;

import com.ecfcode.springstore.domain.models.OrderDO;

import com.ecfcode.springstore.domain.repository.OrderRepositoryDO;
import com.ecfcode.springstore.infrastructure.abstracts.OrderRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Order;
import com.ecfcode.springstore.infrastructure.entities.mappers.OrderDOMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryManager implements OrderRepositoryDO {

    private final OrderRepository orderRepository;
    private final OrderDOMapper orderDOMapper;

    public OrderRepositoryManager(OrderRepository orderRepository, OrderDOMapper orderDOMapper) {
        this.orderRepository = orderRepository;
        this.orderDOMapper = orderDOMapper;
    }

    @Override
    public Optional<OrderDO> findById(Long id) {
        Optional<OrderDO> order = orderRepository.findById(id).map(orderDOMapper);

        if (order.isPresent()) {
            return order;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public OrderDO save(OrderDO order) {
        Order o =  orderRepository.save(new Order(order));
        return o.toOrder();
    }
}
