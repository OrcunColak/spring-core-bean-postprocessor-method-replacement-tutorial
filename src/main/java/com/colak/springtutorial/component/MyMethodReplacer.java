package com.colak.springtutorial.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
public class MyMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        log.info("Replaced method execution with Person: {}", ((Person) args[0]).getName());
        return null;
    }
}

