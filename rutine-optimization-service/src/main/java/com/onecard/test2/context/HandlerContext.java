package com.onecard.test2.context;


import com.onecard.test2.handler.AbstractHandler;
import com.onecard.test2.handler.NormalHandler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 17:43
 */
public class HandlerContext {

    private Map<String,Class> handlerMap;

    public HandlerContext(Map<String,Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (Objects.isNull(clazz)) {
            throw new IllegalArgumentException("cc");
        }
        return new NormalHandler();
//        return (AbstractHandler)BeanUtil.getBean(clazz);
    }
}
