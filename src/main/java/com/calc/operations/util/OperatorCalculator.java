package com.calc.operations.util;

import com.calc.operations.operations.BinaryOperator;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class OperatorCalculator {

    private double operand1;

    private double operand2;

    private BinaryOperator binaryOperator;

    public OperatorCalculator(double operand1,double operand2,BinaryOperator binaryOperator){
        this.operand1=operand1;
        this.operand2=operand2;
        this.binaryOperator = binaryOperator;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public void setBinaryOperator(BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }
}
