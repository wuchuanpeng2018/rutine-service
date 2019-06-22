package com.onecard.classload.test1;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/21 14:16
 */
public class ClassLoadTest2 {

    public static final int a= 1;


    public int setName(int a) {
        a = 123;
        return a;
    }

    public static void main(String[] args) {

//        //通过数组定义来引用类，不会触发此类的初始化

//        //常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，
//        //因此不会触发定义常量的类的初始化：
//        System.out.println(SubClass.value);
//        //1

//        System.out.println(new ClassLoadTest2().setName(a));
//        System.out.println(a);
//        //123
//        //1

//        System.out.println(new SuperClass());
//        //static hello i m SSClass！
//        //static Hello i m SuperClass!
//        //Hello i m SSClass Construct !
//        //Hello i m SuperClass Construct !
//        //com.onecard.classload.SuperClass@13221655


//        System.out.println(new SubClass());
//        //static hello i m SSClass！
//        //static Hello i m SuperClass!
//        //static Hello i m SubClass!
//        //Hello i m SSClass Construct !
//        //Hello i m SuperClass Construct !
//        //Hello i m SubClass Construct!
//        //com.onecard.classload.SubClass@13221655

//        System.out.println(new SubClass().aa);
//        //a为变量
//        //static hello i m SSClass！
//        //static Hello i m SuperClass!
//        //static Hello i m SubClass!
//        //Hello i m SSClass Construct !
//        //Hello i m SuperClass Construct !
//        //Hello i m SubClass Construct!
//        //11

//         System.out.println(SubClass.aa);
//         //aa 为static int aa返回以下
//         //static hello i m SSClass！
//         //static Hello i m SuperClass!
//         //static Hello i m SubClass!
//         //11
    }

}
