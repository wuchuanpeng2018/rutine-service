package com.onecard.test2.context;

import com.google.common.collect.Maps;
import com.onecard.test2.annotation.HandlerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 18:00
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    public static final String SCAN_PACKAGE= "com.onecard.test2.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String,Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScaner.scan(SCAN_PACKAGE, HandlerType.class).forEach(
            clazz-> {
                String type = clazz.getAnnotation(HandlerType.class).value();
                handlerMap.put(type, clazz);
        });
        HandlerContext handler = new HandlerContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(HandlerContext.class.getName(), handler);
    }
}
