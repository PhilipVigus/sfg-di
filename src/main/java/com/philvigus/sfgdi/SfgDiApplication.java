package com.philvigus.sfgdi;

import com.philvigus.sfgdi.controllers.*;
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
         *
         * Spring-managed DI examples rely on the appropriate annotations
         *      @Controller, @Autowired and @Service
         *
         *      Note that there is little functional difference between @Controller
         *      and @Service annotations - they're more to signal intent
         */

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("---------------- Primary");
        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController.sayHello());

        System.out.println("---------------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---------------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

    }

}
