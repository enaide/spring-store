package com.ecfcode.springstore.infrastructure.entities.concretes;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.domain.models.ProductDO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship_postal_code")
    private String shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false,
            referencedColumnName = "employee_id",
            foreignKey = @ForeignKey(
                    name = "orders_employees_fk"
            ))
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_number", nullable = false,
            referencedColumnName = "customer_number",
            foreignKey = @ForeignKey(
                    name = "orders_customers_fk"
            ))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ship_via", nullable = false,
            referencedColumnName = "shipper_id",
            foreignKey = @ForeignKey(
                    name = "orders_shippers_fk"
            ))
    private Shipper shipper;

    @Column(name = "freight")
    private BigDecimal freight;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order(OrderDO order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.requiredDate = order.getRequiredDate();
        this.shippedDate = order.getShippedDate();
    }

    public OrderDO toOrder() {
        OrderDO order = new OrderDO(orderId, orderDate, requiredDate, shippedDate,
                customer.getCustomerNumber(),
                employee.getEmployeeId(),
                shipper.getShipper_id(),
                freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry
        );

        List<OrderLineDO> orderItems = orderDetails.stream().map(orderDetail -> orderDetail.toOrderLine()).toList();
        order.addLineList(orderItems);

		/*
		List<ProductDO> namelessProducts = orderItems.stream()
				.map(orderItem -> new ProductDO(
						orderItem.getProduct().getProductId(),
						orderItem.getProduct().getUnitPrice())
		).toList();

		namelessProducts.forEach(product -> order.addOrder(product));
		if (status == OrderStatus.COMPLETED) {
			order.complete();
		}

		OrderDO order = new OrderDO(orderItems);
		*/

        return order;
    }
}
