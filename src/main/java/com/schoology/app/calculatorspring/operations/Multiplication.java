package com.schoology.app.calculatorspring.operations;

import com.schoology.app.calculatorlibrary.operations.Operation;

/**
 * Created by User on 19.11.2016.
 */
public interface Multiplication extends Operation {

    @Override
    default String getOperationSymbol() {
        return "*";
    }
}
