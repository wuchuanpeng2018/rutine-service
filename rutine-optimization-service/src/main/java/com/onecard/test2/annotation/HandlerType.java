package com.onecard.test2.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface HandlerType {

    public static enum  OrderType {NORMAL, GROUP}

    String value();

}
