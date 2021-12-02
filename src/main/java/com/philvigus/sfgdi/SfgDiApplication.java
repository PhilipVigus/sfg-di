package com.philvigus.sfgdi;

import com.philvigus.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        /**
         * The spring framework creates an instance of the controller for you from
         * inside the spring context.
         *
         * The framework is effectively managing the construction of the controller
         */
        MyController myController = (MyController) ctx.getBean("myController");

        String greeting = myController.sayHello();

        System.out.println(greeting);
    }

}
