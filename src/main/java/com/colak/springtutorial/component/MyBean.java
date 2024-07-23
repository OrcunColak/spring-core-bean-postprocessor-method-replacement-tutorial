package com.colak.springtutorial.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyBean {

    public void originalMethod() {
        log.info("Original method execution");
    }

    public void originalMethod(Person person) {
        log.info("Original method execution with Person: {}", person);
    }
}

