package com.blue.bottle.utils;

import java.util.Arrays;

public class EnumUtils {
    public enum PaymentType {
        CARD,
        UPI
    }

    public enum Status {
        INITIATED,
        DONE
    }

    public static boolean isValidPaymentType(String type) {
        return Arrays.stream(PaymentType.values()).anyMatch(value -> value.toString().contentEquals(type));
    }

}
