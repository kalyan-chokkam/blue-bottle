package com.blue.bottle.design_patterns.creational;

import com.blue.bottle.utils.EnumUtils.PaymentType;
import com.blue.bottle.utils.EnumUtils.Status;
import org.springframework.stereotype.Component;


@Component
public class CardProcessor implements PaymentProcessor{
    @Override
    public void processPayment() {
        // initiated payment
    }

    @Override
    public Status getStatus() {
        return Status.INITIATED;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}
