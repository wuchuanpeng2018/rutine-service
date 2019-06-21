package com.onecard.classload.test1;

import com.onecard.classload.test1.SubClass;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/21 14:07
 */
public class ClassLoadTest1 {

    /**
     *  对于静态字段，只有直接定义这个字段的类才会被初始化，
     *  因此通过其子类来引用父类中定义的静态字段，
     *  只会触发父类的初始化而不会触发子类的初始化
     * @author: wuchu
     * @date: Created in 2019/6/21 14:15
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        System.out.println(SubClass.value);
//        static hello i m SSClass！
//        static Hello i m SuperClass!
//        1
    }

}
