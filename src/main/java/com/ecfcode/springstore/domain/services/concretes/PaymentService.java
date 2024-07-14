package com.ecfcode.springstore.domain.services.concretes;

import com.ecfcode.springstore.domain.models.Currency;
import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.Payment;
import com.ecfcode.springstore.domain.services.PaymentCharger;
import com.ecfcode.springstore.domain.services.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private static final List<Currency> ACCEPTED_CURRENCIES = List.of(Currency.USD, Currency.GBP);

    private final PaymentCharger paymentCharger;
    private final OrderService orderService;

    public PaymentService(PaymentCharger paymentCharger, OrderService orderService) {
        this.paymentCharger = paymentCharger;
        this.orderService = orderService;
    }

    public void chargeCard(Payment payment) {
        OrderDO order = payment.getOrderDO();
        System.out.println(order);
    }
}
