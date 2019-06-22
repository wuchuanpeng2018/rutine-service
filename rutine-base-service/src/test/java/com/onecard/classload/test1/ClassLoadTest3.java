package com.onecard.classload.test1;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 11:03
 */

class A {


    static A a = new A();

    static {
        System.out.println("A的静态块");
    }

    {
        System.out.println("A的普通代码块");
    }
    public  A(){
        System.out.println("A的构造方法");
        System.out.println("aaa = "+aaa +" ; bbb = "+bbb);
    }
    public static void staticMethod(){
        System.out.println("A的静态方法");
    }
    int aaa = 1;
    static int bbb = 2;


}

public class ClassLoadTest3 {
    public static void main(String[] args) {
        A.staticMethod();
    }
}
