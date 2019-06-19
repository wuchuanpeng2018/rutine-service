package com.onecard.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
    public enum  Priority {L,M,H}
    public enum Status {STATUS, NO_STATU}
    String author() default  "";
    Priority priority() default Priority.H;
    Status status() default Status.STATUS;
}
