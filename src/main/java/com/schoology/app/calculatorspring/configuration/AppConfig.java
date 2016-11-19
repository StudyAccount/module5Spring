package com.schoology.app.calculatorspring.configuration;

import com.schoology.app.calculatorlibrary.calculator.Calculator;
import com.schoology.app.calculatorlibrary.calculator.SimpleCalculator;
import com.schoology.app.calculatorlibrary.operations.AdditionDouble;
import com.schoology.app.calculatorlibrary.operations.AdditionLong;
import com.schoology.app.calculatorlibrary.operations.SubtractionDouble;
import com.schoology.app.calculatorlibrary.operations.SubtractionLong;
import com.schoology.app.calculatorlibrary.registry.Registry;
import com.schoology.app.calculatorlibrary.types.DoubleSupportedType;
import com.schoology.app.calculatorlibrary.types.LongSupportedType;
import com.schoology.app.calculatorspring.operations.MultiplicationDouble;
import com.schoology.app.calculatorspring.operations.MultiplicationLong;
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
    public Calculator calculator(Registry registry){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        simpleCalculator.setRegistry(registry);
        return simpleCalculator;
    }

    @Bean
    public Registry registry(){

        Registry registry = new Registry();
        registry.addNewType(doubleSupportedType());
        registry.addNewType(longSupportedType());
        registry.addNewOperation(additionDouble());
        registry.addNewOperation(additionLong());
        registry.addNewOperation(subtractionDouble());
        registry.addNewOperation(subtractionLong());
        registry.addNewOperation(multiplicationLong(longSupportedType()));
        registry.addNewOperation(multiplicationDouble(doubleSupportedType()));
        return registry;
    }

    @Bean
    @Scope("prototype")
    public DoubleSupportedType doubleSupportedType(){

        return new DoubleSupportedType();
    }

    @Bean
    @Scope("prototype")
    public LongSupportedType longSupportedType(){

        return new LongSupportedType();
    }

    @Bean
    public AdditionDouble additionDouble(){

        return new AdditionDouble();
    }

    @Bean
    public SubtractionDouble subtractionDouble(){

        return new SubtractionDouble();
    }

    @Bean
    public AdditionLong additionLong(){

        return new AdditionLong();
    }

    @Bean
    public SubtractionLong subtractionLong(){

        return new SubtractionLong();
    }

    @Bean
    public MultiplicationLong multiplicationLong(LongSupportedType longSupportedType){

        MultiplicationLong multiplicationLong = new MultiplicationLong();
        multiplicationLong.setSupportedType(longSupportedType);
        return multiplicationLong;
    }

    public MultiplicationDouble multiplicationDouble(DoubleSupportedType doubleSupportedType){
        MultiplicationDouble multiplicationDouble = new MultiplicationDouble();
        multiplicationDouble.setSupportedType(doubleSupportedType);

        return multiplicationDouble;
    }

}
