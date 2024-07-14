package com.ecfcode.springstore.domain.models;

import com.ecfcode.springstore.domain.exception.DomainException;
import com.ecfcode.springstore.domain.services.abstracts.SpecialDiscountPolicy;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class OrderDO {

    private Long orderId;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String customerNumber;
    private Long employeeId;
    private Long shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    private BigDecimal totalCost;
    private OrderStatus status;

    private final List<OrderLineDO> orderLines;

    @JsonCreator
    public OrderDO(@JsonProperty("orderLines") List<OrderLineDO> orderLines) {
        validateOrderLines(orderLines);
        this.orderLines = new ArrayList<>(orderLines);
        status = OrderStatus.CREATED;
        totalCost = calculateTotalCost();
    }

    @JsonCreator
    public OrderDO(
            @JsonProperty("orderId") Long orderId,
            @JsonProperty("orderDate") LocalDate orderDate,
            @JsonProperty("requiredDate") LocalDate requiredDate,

            @JsonProperty("shippedDate") LocalDate shippedDate,
            // TODO
            @JsonProperty("customerNumber") String customerNumber,
            // TODO
            @JsonProperty("employeeId") Long employeeId,
            // TODO
            @JsonProperty("shipVia") Long shipVia,

            @JsonProperty("freight") BigDecimal freight,
            @JsonProperty("shipName") String shipName,
            @JsonProperty("shipAddress") String shipAddress,
            @JsonProperty("shipCity") String shipCity,
            @JsonProperty("shipRegion") String shipRegion,
            @JsonProperty("shipPostalCode") String shipPostalCode,
            @JsonProperty("shipCountry") String shipCountry,
            @JsonProperty("orderLines") List<OrderLineDO> orderLines) {

        this.orderId = orderId;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.customerNumber = customerNumber;
        this.employeeId = employeeId;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;

        validateOrderLines(orderLines);
        this.orderLines = new ArrayList<>(orderLines);
        status = OrderStatus.CREATED;
        totalCost = calculateTotalCost();
    }

    @JsonCreator
    public OrderDO(
            @JsonProperty("orderId") Long orderId,
            @JsonProperty("orderDate") LocalDate orderDate,
            @JsonProperty("requiredDate") LocalDate requiredDate,

            @JsonProperty("shippedDate") LocalDate shippedDate,
            // TODO
            @JsonProperty("customerNumber") String customerNumber,
            // TODO
            @JsonProperty("employeeId") Long employeeId,
            // TODO
            @JsonProperty("shipVia") Long shipVia,

            @JsonProperty("freight") BigDecimal freight,
            @JsonProperty("shipName") String shipName,
            @JsonProperty("shipAddress") String shipAddress,
            @JsonProperty("shipCity") String shipCity,
            @JsonProperty("shipRegion") String shipRegion,
            @JsonProperty("shipPostalCode") String shipPostalCode,
            @JsonProperty("shipCountry") String shipCountry) {

        this.orderId = orderId;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.customerNumber = customerNumber;
        this.employeeId = employeeId;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;

        this.orderLines = new ArrayList<>();
        status = OrderStatus.CREATED;
        totalCost = BigDecimal.ZERO;
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(final ProductDO product, final int quantity) {
        validateState();
        checkNotNull(product);
        OrderLineDO ol = new OrderLineDO(product, quantity);
        orderLines.add(ol);
        totalCost = totalCost.add(ol.cost());
    }

    public void addLineList(List<OrderLineDO> OrderL) {
        validateState();
        for(OrderLineDO orderLineItem : OrderL) {
            checkNotNull(orderLineItem);
//            orderLineItem.setOrder(this); TODO REVIEW LOOP LACK MEMORY
            this.orderLines.add(orderLineItem);
            totalCost = totalCost.add(orderLineItem.cost());
        }
    }

    public void addLineItem(OrderLineDO orderLine) {
        validateState();
        checkNotNull(orderLine);

        // orderLine.setOrder(this);
        orderLines.add(orderLine);
        totalCost = totalCost.add(orderLine.cost());
    }

    public void removeLineItemByProductId(Long productId) {
        validateState();
        OrderLineDO orderLine = getOrderLineByProductId(productId);
        orderLines.remove(orderLine);

        totalCost = totalCost.subtract(orderLine.cost());
    }

    public void removeLineItemByOrderLineId(Long orderLineId) {
        validateState();
        OrderLineDO orderLine = getOrderLineByLineId(orderLineId);
        orderLines.remove(orderLine);

        totalCost = totalCost.subtract(orderLine.cost());
    }

    public List<OrderLineDO> getOrderLines() {
        return Collections.unmodifiableList(orderLines);
    }

    private OrderStatus getStatus() {
        return status;
    }

    private OrderLineDO getOrderLineByLineId(final Long id) {
        // return orderLines.get(line);
        return orderLines.stream()
                .filter(orderItem -> orderItem.getOrderLineId().equals(id))
                .findFirst().orElseThrow(() -> new DomainException("OrderLine with " + id + " doesn't exist."));
    }

    private OrderLineDO getOrderLineByProductId(final Long id) {
        return orderLines.stream()
                .filter((orderLine -> orderLine.getProduct().getProductId().equals(id)))
                .findFirst().orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
    }

    public BigDecimal totalCost() {
        return totalCost;
    }

    public BigDecimal totalCost(SpecialDiscountPolicy discountPolicy) {
        BigDecimal amountToBePaid = totalCost().multiply(BigDecimal.valueOf(1 - applyDiscountPolicy(discountPolicy)));
        return amountToBePaid.setScale(2, RoundingMode.HALF_EVEN);
    }

    protected double applyDiscountPolicy(SpecialDiscountPolicy discountPolicy) {
        return discountPolicy.discount(this);
    }

    private BigDecimal calculateTotalCost() {
        return orderLines.stream()
                .map(orderLineDO -> orderLineDO.cost())
                .reduce((total, num) -> total.add(num))
                .orElseThrow(() -> new DomainException("OrderLine doesn't exist."));
    }

    private static void checkNotNull(Object par) {
        if (par == null) {
            throw new NullPointerException("Product cannot be null");
        }
    }

    private static void validateOrderLines(final List<OrderLineDO> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new DomainException("Order must have at least one order line item");
        }
    }

    private void validateState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("The order is in completed state.");
        }
    }

}
