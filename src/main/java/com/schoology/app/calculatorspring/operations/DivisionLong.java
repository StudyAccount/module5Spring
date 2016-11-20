package com.schoology.app.calculatorspring.operations;

import com.schoology.app.calculatorlibrary.types.SupportedType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by User on 19.11.2016.
 */
public class DivisionLong implements Division {

    private BigDecimal result = BigDecimal.ZERO;
    private SupportedType supportedType;

    @Override
    public String count(List<String> inputData) {

        if (inputData.size() >= 1 && supportedType.checkType(inputData.get(0)) == true){
            Long firstElement = Long.parseLong(inputData.get(0));
            result = BigDecimal.valueOf(firstElement);
            inputData.remove(0);
        }

        for (String element:inputData){

            try {

                if (supportedType.checkType(element) == true) {

                    Long termLong = Long.parseLong(element);
                    BigDecimal termBigDecimal = BigDecimal.valueOf(termLong);
                    result = result.divide(termBigDecimal);
                }

            }catch (ArithmeticException ex){
                return "error";
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
