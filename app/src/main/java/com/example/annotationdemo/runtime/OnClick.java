package com.example.annotationdemo.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {
    
    /**
     * value值为{数组}的原因是同一个函数可以设置成多个组件的触发函数。
     **/
    int[] value() default {0};
}