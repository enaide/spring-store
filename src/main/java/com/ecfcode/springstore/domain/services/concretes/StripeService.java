package com.ecfcode.springstore.domain.services.concretes;

import com.ecfcode.springstore.domain.models.CardPaymentCharge;
import com.ecfcode.springstore.domain.models.Currency;
import com.ecfcode.springstore.domain.services.PaymentCharger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StripeService implements PaymentCharger {

    @Override
    public CardPaymentCharge chargeCard(String cardSource, BigDecimal amount, Currency currency, String description) {
        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");
    }
}
