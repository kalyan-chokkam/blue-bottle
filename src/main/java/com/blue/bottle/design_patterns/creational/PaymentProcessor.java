package com.blue.bottle.design_patterns.creational;

import com.blue.bottle.utils.EnumUtils.PaymentType;
import com.blue.bottle.utils.EnumUtils.Status;

public interface PaymentProcessor {

    void processPayment();

    Status getStatus();

    PaymentType getType();
}
