package com.calc.operations.util;

import com.calc.operations.operations.BinaryOperator;
import com.calc.operations.operations.impl.AdditionOperator;
import com.calc.operations.operations.impl.DivOperator;
import com.calc.operations.operations.impl.MultiplyOperator;
import com.calc.operations.operations.impl.SubOperator;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public enum OperatorEnum {

    Addition("+",new AdditionOperator()),
    Subtraction("-",new SubOperator()),
    Division("/",new DivOperator()),
    Multiplication("*",new MultiplyOperator());

    private String operand;

    private BinaryOperator operator;

    OperatorEnum(String operand,BinaryOperator operator){
        this.operand = operand;
        this.operator = operator;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(BinaryOperator operator) {
        this.operator = operator;
    }
}
