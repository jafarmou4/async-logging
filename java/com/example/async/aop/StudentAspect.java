package com.example.async.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class StudentAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void selectedMethods() {
    }

    @Before("selectedMethods()")
    public void measureMethodExecutionTime(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("-" + methodName + "- is Called at " + LocalTime.now());
    }
}
