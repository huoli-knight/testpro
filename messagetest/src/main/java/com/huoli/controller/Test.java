package com.huoli.controller;

import com.huoli.enableload.annotation.filecontent.FileContent;
import com.huoli.enableload.annotation.services.FileService;
import com.huoli.enableload.annotation.services.TestService;
import com.huoli.enableload.annotation.services.TestServiceImpl;
import com.huoli.enableload.annotation.utilEntity.ResultIndex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/test")
@CrossOrigin
public class Test {

    @Autowired
    private FileContent fileContent;

    @Autowired
    private TestServiceImpl testServiceImpl;

    @Autowired
    private FileService fileService;

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
//        testServiceImpl.showTest();
        testService.showTest();
    }

    @RequestMapping(value = "/index")
    @ResponseBody
    public List<ResultIndex> getIndexData() {
        return fileService.getFileData();
    }
}
