package com.schoology.app.calculatorspring.configuration;

import com.schoology.app.calculatorlibrary.calculator.Calculator;
import com.schoology.app.calculatorlibrary.calculator.SimpleCalculator;
import com.schoology.app.calculatorlibrary.registry.Registry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by User on 13.11.2016.
 */

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Calculator calculator(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();


        simpleCalculator.init();
        return simpleCalculator;
    }

    @Bean
    public Registry registry(){
        return new Registry();
    }


}
