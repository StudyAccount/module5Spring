package com.schoology.app.calculatorspring.operations;

import com.schoology.app.calculatorlibrary.types.SupportedType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */
public class MultiplicationDouble implements Multiplication {

    BigDecimal result = BigDecimal.ONE;
    SupportedType supportedType;

    @Override
    public String count(List<String> inputData) {

        for(String element:inputData){

            if (supportedType.checkType(element) == true) {
                double termDouble = Double.parseDouble(element);

                BigDecimal termBigDecimal = BigDecimal.valueOf(termDouble);
                result = result.multiply(termBigDecimal);
            }
        }

        return result.toString();
    }

    @Override
    public String getTypeOfOperands() {
        return "double";
    }

    public void setSupportedType(SupportedType supportedType) {
        this.supportedType = supportedType;
    }
}
