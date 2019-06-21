package com.onecard.classload.test1;

import com.onecard.classload.test1.ISSClass;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/21 16:29
 */
public class ISuperClass implements ISSClass {

    static {
//        final变量
//        a = 11;
        System.out.println("static ISuperClass list");
    }

    @Override
    public void iis() {
        System.out.println("ISuperClass list" + a);
    }
}
