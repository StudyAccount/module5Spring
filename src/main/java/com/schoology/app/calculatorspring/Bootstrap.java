package com.schoology.app.calculatorspring;


import com.schoology.app.calculatorlibrary.calculator.Calculator;
import com.schoology.app.calculatorspring.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 13.11.2016.
 */
public class Bootstrap {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        System.out.println( calculator.calculate("+,3,4"));

    }

}
