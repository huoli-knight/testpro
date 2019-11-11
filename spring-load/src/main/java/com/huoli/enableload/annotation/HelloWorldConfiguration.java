package com.huoli.enableload.annotation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class HelloWorldConfiguration {

    private String test;

    public HelloWorldConfiguration(){
        log.info("HelloWorld!");
        test = "你好！";
    }
}
