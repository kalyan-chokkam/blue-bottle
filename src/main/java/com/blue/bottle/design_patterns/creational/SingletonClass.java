package com.blue.bottle.design_patterns.creational;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * scope singleton - same object across controllers
 * scope prototype - new objects across usage
 */
@Component
@Scope("prototype")
public class SingletonClass {
    private static SingletonClass singletonClass;

    private SingletonClass(){

    }
    public static SingletonClass getInstance() {
        return Objects.requireNonNullElseGet(singletonClass, SingletonClass::new);
    }
}
