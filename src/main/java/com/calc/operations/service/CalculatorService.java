package com.calc.operations.service;

import com.calc.operations.exception.CalcualtorException;
import com.calc.operations.factory.BinaryOperatorFactory;
import com.calc.operations.operations.BinaryOperator;
import com.calc.operations.util.OperatorCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class CalculatorService {


    public double caluclate(String[] equationArgs) throws CalcualtorException {
        double value = 0;
        try {
            this.validateInput(equationArgs);
            List<OperatorCalculator> operatorCalculators = getOperatorCalculator(equationArgs);
            int highOrderIndex = getHighestOrderValue(operatorCalculators);
            value = performCalculation(operatorCalculators, highOrderIndex);
        }catch (Exception e){
            throw  new CalcualtorException("Exeption occured in calculation " + e.getMessage());
        }
        return value;
    }

    private void validateInput(String[] equation) throws CalcualtorException {
        if (equation == null || equation.length == 0) {
            throw new CalcualtorException("Empty value is entered as equation");
        }

        String exceptionMessage = "Invalid input is entered .\n" +
                "Equation must contain only numbers and operands.Equations entered must match the pattern shown below \n" +
                "Examples : \n" +
                "4 + 2\n" +
                "4 + 2 / 3 * 2\n" +
                "Operands allowed are only +,-,/,*";

        if (equation.length < 3 && equation.length % 2 == 0) {
            throw new CalcualtorException(exceptionMessage);
        }
        for (int i = 0; i < equation.length; i++) {
            String val = equation[i];
            if (i == 0 || i % 2 == 0) {
                try {
                    Integer.parseInt(val);
                } catch (NumberFormatException e) {
                    throw new CalcualtorException(exceptionMessage);
                }
            } else {
                //Should be replaced by regex if operands becomes more.
                boolean operand = val.equals("+") || (val.equals("-") || (val.equals("*") || (val.equals("/"))));
                if (!operand) {
                    throw new CalcualtorException(exceptionMessage);
                }
            }

        }
    }


    private List<OperatorCalculator> getOperatorCalculator(String[] equationArgs) {
        List<OperatorCalculator> operatorCalculatorList = new ArrayList<OperatorCalculator>();
        for (int i = 0; i < equationArgs.length; i++) {
                if (i != 0 && (i == 1  || i % 2 != 0)) {
                    String operand = equationArgs[i];
                    BinaryOperator binaryOperator = BinaryOperatorFactory.getOperator(operand);
                    double operand1 = Double.parseDouble(equationArgs[i - 1]);
                    double operand2 = Double.parseDouble(equationArgs[i + 1]);
                    OperatorCalculator operatorCalculator = new OperatorCalculator(operand1, operand2, binaryOperator);
                    operatorCalculatorList.add(operatorCalculator);
                }
            }
        return operatorCalculatorList;
    }

    private  int getHighestOrderValue(List<OperatorCalculator> operatorCalculators){
        int highestOrder = 0;
        for (OperatorCalculator operatorCalculator : operatorCalculators) {
                if(highestOrder < operatorCalculator.getBinaryOperator().operatorOrder()){
                    highestOrder = operatorCalculator.getBinaryOperator().operatorOrder();
                }
        }
        return highestOrder;
    }

    private double performCalculation(List<OperatorCalculator> operatorCalculators,int highOrderIndex){
        double value=0;
        boolean isHigherOrderIndexDone = false;
        for (int i = highOrderIndex; i > 0; i--) {
            for (OperatorCalculator operatorCalculator : operatorCalculators) {
                if(!isHigherOrderIndexDone && operatorCalculator.getBinaryOperator().operatorOrder() == highOrderIndex){
                    isHigherOrderIndexDone = true;
                    value = operatorCalculator.getBinaryOperator().calculate(operatorCalculator.getOperand1(),operatorCalculator.getOperand2());
                }else if(operatorCalculator.getBinaryOperator().operatorOrder() == i){
                    value = operatorCalculator.getBinaryOperator().calculate(operatorCalculator.getOperand1(),value);
                }
            }
        }
        return value;
    }
}
