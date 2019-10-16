package com.cenjil.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author CenJIl
 * @date 2019/9/9 10:06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
    String name() default "";

    String key() default "";

    String prefix() default "";

    int period();

    int count();

    LimitType limitType() default LimitType.CUSTOMER;
}
