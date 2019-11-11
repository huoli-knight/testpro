package com.huoli.enableload.annotation;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnAutoHelloWorld {

}
