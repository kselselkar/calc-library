package com.calc.operations.operations;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public interface BinaryOperator {

    public abstract double calculate(double operand1, double operand2);

    public abstract int operatorOrder();
}
