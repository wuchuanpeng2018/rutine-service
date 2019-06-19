package com.onecard;

import com.onecard.annotations.Todo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @description: 注解测试
 * @author: wuchu
 * @date: Created in 2019/6/19 18:14
 */
public class AnnotationsTest {

    public static void main(String[] args) {
        Class onecardRutineAnnotationsServiceApplicationClass = OnecardRutineAnnotationsServiceApplication.class;
        for(Method method : onecardRutineAnnotationsServiceApplicationClass.getMethods() ) {
            Todo todo=method.getAnnotation(Todo.class);
            System.out.println("todo ===== "+todo);
            if (!Objects.isNull(todo)) {
                System.out.println(todo.author());
                System.out.println(todo.priority());
            }
        }
    }

}
