package com.aust.clanguagemanage.config.myinterface;

import java.lang.annotation.*;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJson {
    String value() default "";

    boolean required() default true;

    String defaultValue() default "";
}
