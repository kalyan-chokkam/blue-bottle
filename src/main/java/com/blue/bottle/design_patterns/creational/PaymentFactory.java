package com.blue.bottle.design_patterns.creational;

import com.blue.bottle.utils.EnumUtils.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    @Autowired
    CardProcessor cardProcessor;

    @Autowired
    UPIProcessor upiProcessor;

    public PaymentProcessor getProcessor(PaymentType type) {
        return switch (type) {
            case CARD -> cardProcessor;
            case UPI -> upiProcessor;
        };
    }
}
