package com.schoology.app.calculatorspring.operations;

import com.schoology.app.calculatorlibrary.types.SupportedType;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */

public class MultiplicationLong implements Multiplication {

    BigInteger result = BigInteger.ONE;
    SupportedType supportedType;

    @Override
    public String count(List<String> inputData) {

        for(String element:inputData){
            if (supportedType.checkType(element) == true) {
                Long termLong = Long.parseLong(element);
                BigInteger termBigInteger = BigInteger.valueOf(termLong);
                result = result.multiply(termBigInteger);
            }
        }

        return result.toString();
    }

    @Override
    public String getTypeOfOperands() {
        return "long";
    }

    public void setSupportedType(SupportedType supportedType) {
        this.supportedType = supportedType;
    }

}
