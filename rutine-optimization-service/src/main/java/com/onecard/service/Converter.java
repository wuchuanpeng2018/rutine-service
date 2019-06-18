package com.onecard.service;

import java.util.function.Function;

/**
 * @description: GUAVA 的源码
 * 方式6
 * @author: wuchu
 * @date: Created in 2019/6/16 14:00
 */
public abstract class Converter<A, B> implements Function<A, B> {
    public abstract B doForward(A a);
    public abstract A doBackward(B b);
    //其他略
}
