package com.example.demo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ExampleServiceImpl1 implements ExampleService {

    @Override
    public String echo(String string) {
        return String.format("ECHO1:%s", string);
    }

}
