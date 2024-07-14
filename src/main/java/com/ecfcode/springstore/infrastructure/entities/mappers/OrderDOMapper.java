package com.ecfcode.springstore.infrastructure.entities.mappers;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.infrastructure.entities.concretes.Order;
import com.ecfcode.springstore.infrastructure.entities.concretes.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class OrderDOMapper implements Function<Order, OrderDO> {

    @Override
    public OrderDO apply(Order order) {

        OrderDO orderDO = new OrderDO( order.getOrderId(), order.getOrderDate(), order.getRequiredDate(),
                order.getShippedDate(), order.getCustomer().getCustomerNumber(), order.getEmployee().getEmployeeId(),
                order.getShipper().getShipper_id(), order.getFreight(), order.getShipName(),
                order.getShipAddress(), order.getShipCity(), order.getShipRegion(),
                order.getShipPostalCode(), order.getShipCountry()
        );
        order.getOrderDetails().forEach(orderDetail ->
                orderDO.addLineItem(
                        // orderDetail.toOrderLineObject()
                        new OrderLineDO(
                            // orderDetail.toOrderDO(), orderDetail.toProductDO(), orderDetail.getDiscount(),
                            orderDetail.getOrderId(), orderDetail.toProductDO(), orderDetail.getDiscount(),
                            orderDetail.getQuantity(), orderDetail.getUnitPrice()
                        )
                )
        );

        return orderDO;
    }
}
