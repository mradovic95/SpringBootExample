package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogBeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(com.example.demo.aspects.TrackTime)")
    public void before(JoinPoint joinPoint) throws Throwable {

        logger.info("Log before track time {}", joinPoint);

    }

}
