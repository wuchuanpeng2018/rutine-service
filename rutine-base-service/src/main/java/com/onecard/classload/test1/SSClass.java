package com.onecard.classload.test1;

/**
 * @description: 超类
 * @author: wuchu
 * @date: Created in 2019/6/21 14:00
 */
public class SSClass {

    static {
        System.out.println("static hello i m SSClass！");
    }

    public SSClass() {
        System.out.println("Hello i m SSClass Construct !" );
    }
}
