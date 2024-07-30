package com.blue.bottle.services;


import com.blue.bottle.design_patterns.creational.PaymentFactory;
import com.blue.bottle.design_patterns.creational.PaymentProcessor;
import com.blue.bottle.design_patterns.creational.SingletonClass;
import com.blue.bottle.utils.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/design_pattern")
public class DesignController {

    @Autowired
    private SingletonClass singletonClass;

    @Autowired
    private PaymentFactory paymentFactory;

    @GetMapping("/singleton")
    public ResponseEntity<String> getSingleton() {
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        String res = "This is a singleton instance: " + singletonClass1.toString();
         res += "\n " + singletonClass.toString();
         res += "\n " + SingletonClass.getInstance().toString();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/factory/pay/{type}")
    public ResponseEntity<String> getPaymentStatus(@PathVariable("type") String type) {
        type = type.toUpperCase();
        if (EnumUtils.isValidPaymentType(type)){
            PaymentProcessor paymentProcessor = paymentFactory.getProcessor(EnumUtils.PaymentType.valueOf(type));
            String res = "starting payment at " + paymentProcessor.getType() + " with status" + paymentProcessor.getStatus();
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.badRequest().body("invalid payment type");
        }
    }
}
