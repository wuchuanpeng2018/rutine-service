package com.onecard.config;

import com.onecard.annotations.Todo;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description: 注解处理
 * @author: wuchu
 * @date: Created in 2019/6/19 18:15
 */
@AspectJ
@Component
public class AnnotationInterceptor {

    @Pointcut("@annotation(com.onecard.annotations.Todo)")
    public void annotationPointcut() {
    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Todo todo=method.getAnnotation(Todo.class);
        String value = todo.author();
        System.out.println("准备"+value);
    }

    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Todo todo=method.getAnnotation(Todo.class);
        String value = todo.author();
        System.out.println("结束"+value);
    }

}
