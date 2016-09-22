package com.calc.operations.operations.impl;

import com.calc.operations.operations.BinaryOperator;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class MultiplyOperator implements BinaryOperator {

    public double calculate(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public int operatorOrder() {
        return 2;
    }
}
