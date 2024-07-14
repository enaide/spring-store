package com.ecfcode.springstore.order;

import com.ecfcode.springstore.domain.exception.DomainException;
import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.OrderLineDO;
import com.ecfcode.springstore.domain.models.ProductDO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class OrderTest {

    @DisplayName("given order with two items, when calculate total cost, then sum is returned")
    @Test
    void test0() {
        // given
        OrderLineDO ol0 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(10.00)), 2);
        OrderLineDO ol1 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(5.00)), 10);
        OrderDO order = new OrderDO(Arrays.asList(ol0, ol1));

        // when
        BigDecimal totalCost = order.totalCost();

        // then
        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(70.00));
    }

    @DisplayName("when create order without line items, then exception is thrown")
    @Test
    void test1() {
        // when
        Throwable throwable = catchThrowable(() -> new OrderDO(new ArrayList<>()));
        // then
        assertThat(throwable).isInstanceOf(DomainException.class);
    }

    @DisplayName("given order with two line items, when add another line item, then total cost is updated")
    @Test
    void test2() {
        // given
        OrderLineDO ol0 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(10.00)), 1);
        OrderLineDO ol1 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf( 5.00)), 1);
        OrderDO order = new OrderDO(Arrays.asList(ol0, ol1));

        // when
        order.addLineItem(new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf(20.00)), 2));

        // then
        assertThat(order.totalCost()).isEqualTo(BigDecimal.valueOf( 55.00));
    }

    @DisplayName("given order with three line items, when remove item, then total cost is updated")
    @Test
    void test3() {
        // given
        OrderLineDO ol0 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf( 10.00)), 1);
        OrderLineDO ol1 = new OrderLineDO(new ProductDO(2L,BigDecimal.valueOf(20.00)), 1);
        OrderLineDO ol2 = new OrderLineDO(new ProductDO(3L,BigDecimal.valueOf(30.00)), 1);
        OrderDO order = new OrderDO(Arrays.asList(ol0, ol1, ol2));

        // when
        order.removeLineItemByProductId(1L);

        // then
        assertThat(order.totalCost()).isEqualTo(BigDecimal.valueOf(50.00));
    }

    @DisplayName("given order with two line items, when add another line item then exception is thrown")
    @Test
    void test4() {
        // given
        OrderLineDO ol0 = new OrderLineDO(new ProductDO(1L,BigDecimal.valueOf( 10.00)), 1);
        OrderDO order = new OrderDO(List.of(ol0));

        // when
        Throwable throwable = catchThrowable(() -> order.addLineItem(null));

        // then
        assertThat(throwable).isInstanceOf(NullPointerException.class);
    }
}