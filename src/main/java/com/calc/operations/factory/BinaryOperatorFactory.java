package com.calc.operations.factory;

import com.calc.operations.operations.BinaryOperator;
import com.calc.operations.util.OperatorEnum;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class BinaryOperatorFactory {

    public static BinaryOperator getOperator(String operand){
        for (OperatorEnum operatorEnum : OperatorEnum.values()) {
            if(operatorEnum.getOperand().equals(operand)){
                return operatorEnum.getOperator();
            }
        }
        return  null;
    }
}
