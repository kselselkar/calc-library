package com.calc.operations;

import com.calc.operations.exception.CalcualtorException;
import com.calc.operations.service.CalculatorService;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class CalculatorApp {

    public static void main(String[] args) throws CalcualtorException {
        System.out.println("Calculator App evaluates expression entered in command line args ");
        CalculatorService calculatorService=new CalculatorService();
        System.out.println("Value of entered expression is " + calculatorService.caluclate(args));
    }
}
