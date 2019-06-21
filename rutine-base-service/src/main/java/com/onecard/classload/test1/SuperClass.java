package com.onecard.classload.test1;

import com.onecard.classload.test1.SSClass;

/**
 * @description: 父类
 * @author: wuchu
 * @date: Created in 2019/6/21 14:02
 */
public class SuperClass extends SSClass {

    static {
        System.out.println("static Hello i m SuperClass!");
    }

    public static  final int value = 1;

     /**
     *  功能描述
     * @author: wuchu
     * @date: Created in 2019/6/21 14:15
 * @param
     * @return
     */
    public SuperClass() {
        System.out.println("Hello i m SuperClass Construct !" );
    }

}