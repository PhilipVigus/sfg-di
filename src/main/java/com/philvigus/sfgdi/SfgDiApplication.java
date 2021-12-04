package com.philvigus.sfgdi;

import com.philvigus.sfgdi.controllers.ConstructorInjectedController;
import com.philvigus.sfgdi.controllers.MyController;
import com.philvigus.sfgdi.controllers.PropertyInjectedController;
import com.philvigus.sfgdi.controllers.SetterInjectedController;
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

        /**
         * The following Spring-managed DI examples reply on the appropriate annotations
         *      @Controller, @Autowired and @Service
         *
         *      Note that there is little functional difference between @Controller
         *      and @Service annotations - they're more to signal intent
         */
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
