package com.huoli;

import com.huoli.enableload.annotation.EnAchieveImportSelector;
import com.huoli.enableload.annotation.HelloWorldConfiguration;
import com.huoli.enableload.annotation.services.TestService;
import com.huoli.enableload.annotation.services.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@EnAchieveImportSelector
public class Application{
//主类中还没有加载，找不到
//    @Autowired
//    private TestServiceImpl testServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        test();
    }

    private static void test() {
//        log.info(new HelloWorldConfiguration().getTest());
//        testServiceImpl.showTest();
    }

}
