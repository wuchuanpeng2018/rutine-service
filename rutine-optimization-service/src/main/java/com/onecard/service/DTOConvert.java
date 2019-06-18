package com.onecard.service;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description: 类型转化服务抽象
 * 方式4
 * @author: wuchu
 * @date: Created in 2019/6/16 11:57
 */
public interface DTOConvert<S,T> {

    //方式4
    T convert(S s);

    //方式5
    T convertToUser(S s);
}
