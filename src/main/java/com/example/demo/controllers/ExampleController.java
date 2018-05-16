package com.example.demo.controllers;

import com.example.demo.services.ExampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
public class ExampleController {

    @Value("${value1}")
    private String value1;

    //@Autowired
    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public ExampleService getExampleService() {
        return exampleService;
    }

    //    @Autowired
//    @Qualifier("exampleService")
    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
}
