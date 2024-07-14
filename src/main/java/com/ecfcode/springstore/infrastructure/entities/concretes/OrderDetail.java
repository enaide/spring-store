package com.ecfcode.springstore.infrastructure.entities.concretes;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.domain.models.ProductDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false,
            referencedColumnName = "order_id",
            foreignKey = @ForeignKey(
                    name = "order_details_order_fk"
            ))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, nullable = false,
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "order_details_product_fk"
            ))
    private Product product;

    public OrderDetail(final OrderLineDO orderLine) {
        // TODO
//        this.orderId = orderLine.getOrderLineId();
//        this.order = new Order(orderLine.getOrder());
//
//        this.productId = orderLine.getProduct().getProductId();
//        this.product = new Product(orderLine.getProduct());
//
//        this.quantity = orderLine.getQuantity();
//        this.discount = orderLine.getDiscount();
//        this.product = new Product(orderLine.getProduct());
    }

    public OrderLineDO toOrderLine() {
        return new OrderLineDO(
                orderId,
                toProductDO(),
                discount,
                quantity,
                unitPrice
        );
    }

    public OrderDO toOrderDO() {
        return new OrderDO(
                order.getOrderId(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getCustomer().getCustomerNumber(),
                order.getEmployee().getEmployeeId(),
                order.getShipper().getShipper_id(),
                order.getFreight(),
                order.getShipName(),
                order.getShipAddress(),
                order.getShipCity(),
                order.getShipRegion(),
                order.getShipPostalCode(),
                order.getShipCountry()
        );
    }

    public ProductDO toProductDO() {
        return new ProductDO(
                this.product.getProductId(),
                this.product.getProductName(),
                this.product.getSupplier().getSupplierId(),
                this.product.getCategory().getCategoryId(),
                this.product.getQuantityPerUnit(),
                this.product.getUnitPrice(),
                this.product.getUnitsInStock(),
                this.product.getUnitsOnOrder(),
                this.product.getReorderLevel(),
                this.product.getDiscontinued()
        );
    }

    public OrderLineDO toOrderLineObject() {
        return new OrderLineDO(
                toOrderDO(),
                toProductDO(),
                discount,
                quantity,
                unitPrice
        );
    }
}
