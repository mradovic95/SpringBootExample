package com.example.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ExampleServiceImpl2 implements ExampleService {

    @Override
    public String echo(String string) {
        return String.format("ECHO2:%s", string);
    }

}

