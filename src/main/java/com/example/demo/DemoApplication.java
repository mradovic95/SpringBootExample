package com.example.demo;

import com.example.demo.controllers.ExampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        ExampleController exampleController = (ExampleController) applicationContext.getBean("exampleController");
        System.out.println(exampleController.getExampleService().echo("Hello"));
        System.out.println(exampleController.getValue1());

    }
}
