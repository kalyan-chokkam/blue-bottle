package com.blue.bottle.services;


import com.blue.bottle.design_patterns.creational.SingletonClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/l/design_pattern")
public class DesignControllerLight {

    @Autowired
    private SingletonClass singletonClass;


    @GetMapping("/singleton")
    public ResponseEntity<String> getSingleton() {
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        String res = "This is a singleton instance: " + singletonClass1.toString();
         res += "\n " + singletonClass.toString();
         res += "\n " + SingletonClass.getInstance().toString();
        return ResponseEntity.ok(res);
    }
}
