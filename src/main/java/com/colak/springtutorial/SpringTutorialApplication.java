package com.colak.springtutorial;

import com.colak.springtutorial.component.MyBean;
import com.colak.springtutorial.component.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTutorialApplication implements CommandLineRunner {

    private MyBean myBean;

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    @Autowired
    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public void run(String... args) {
        myBean.originalMethod(new Person("Bob")); // Should print "Replaced method execution with Person: Bob"
        myBean.originalMethod(); // Should print "Original method execution"
    }
}
