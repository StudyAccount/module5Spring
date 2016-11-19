package com.schoology.app.calculatorspring;


import com.schoology.app.calculatorlibrary.calculator.Calculator;
import com.schoology.app.calculatorspring.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Created by User on 13.11.2016.
 */
public class Bootstrap {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculate(calculator);

    }

    public static String calculate(Calculator calculator) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter expression:");
            String input = scanner.nextLine();

            if ("quit".equals(input)){
                break;
            }

            String currentOperation = calculator.calculate(input);
            System.out.println("Result " + currentOperation);
        }

        return null;
    }
}
