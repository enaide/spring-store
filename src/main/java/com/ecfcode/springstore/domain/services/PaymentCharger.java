package com.ecfcode.springstore.domain.services;

import com.ecfcode.springstore.domain.models.CardPaymentCharge;
import com.ecfcode.springstore.domain.models.Currency;

import java.math.BigDecimal;

public interface PaymentCharger {

    CardPaymentCharge chargeCard(
            String cardSource,
            BigDecimal amount,
            Currency currency,
            String description
    );
}
