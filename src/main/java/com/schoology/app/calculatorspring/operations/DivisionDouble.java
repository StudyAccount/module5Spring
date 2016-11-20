package com.schoology.app.calculatorspring.operations;

import com.schoology.app.calculatorlibrary.types.SupportedType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */
public class DivisionDouble implements Division {

    private BigDecimal result = BigDecimal.ZERO;
    private SupportedType supportedType;

    @Override
    public String count(List<String> inputData) {

        if (inputData.size() > 0 && supportedType.checkType(inputData.get(0))== true){

            double firstElement = Double.parseDouble(inputData.get(0));
            result = BigDecimal.valueOf(firstElement);
            inputData.remove(0);
        }

        for(String element:inputData){

            try {

                if (supportedType.checkType(element) == true) {
                    double termDouble = Double.parseDouble(element);
                    BigDecimal termBigDecimal = BigDecimal.valueOf(termDouble);
                    result = result.divide(termBigDecimal);
                }

            }catch (ArithmeticException ex){
                return "error";
            }
        }

        return result.toString() ;
    }

    @Override
    public String getTypeOfOperands() {
        return "double";
    }

    public void setSupportedType(SupportedType supportedType) {
        this.supportedType = supportedType;
    }
}
