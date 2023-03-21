package ru.kirillvenediktov.philosophy.chapter20.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLLong {

    String name() default "";

    Constraints constraints() default @Constraints;
}