package com.huoli.enableload.annotation.services;

import com.huoli.enableload.annotation.HelloWorldConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

public class TestServiceImpl implements TestService{
    @Override
    public void showTest() {
        System.out.println(new HelloWorldConfiguration().getTest() + "TestServiceImpl");
    }
}
