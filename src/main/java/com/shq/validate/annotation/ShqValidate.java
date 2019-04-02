package com.shq.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunhuaquan
 * @Title: ShqValidate
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3110:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShqValidate {

    boolean require() default false;

    String regex() default "";

    int minLength() default 0;

    int maxLength() default Integer.MAX_VALUE;
}
