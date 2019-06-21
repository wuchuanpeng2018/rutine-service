package com.onecard.classload.test1;

import com.onecard.classload.test1.SuperClass;

/**
 * @description: 子类
 * @author: wuchu
 * @date: Created in 2019/6/21 14:04
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("static Hello i m SubClass!");
    }

    static  int aa = 11;

    public SubClass() {
        System.out.println("Hello i m SubClass Construct!");
    }

}
