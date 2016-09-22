package com.calc.operations;

import com.calc.operations.exception.CalcualtorException;
import com.calc.operations.service.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Karthikeyan on 9/22/2016.
 */
public class CalculatorAppTest {

    private CalculatorService calculatorService;

    private final double DELTA = 1e-15;

    @Before
    public void setUp(){
        this.calculatorService = new CalculatorService();
    }

    @Test
    public void testCalculator() throws CalcualtorException {
        String[] args=new String[]{"4","+","2"};
        assertEquals(6.0,calculatorService.caluclate(args),DELTA);
        args=new String[]{"4","+","2","/","3"};
        assertEquals(4.666666666666667,calculatorService.caluclate(args),DELTA);
        args=new String[]{"4","+","2","*","2","/","3"};
        assertEquals(5.333333333333333,calculatorService.caluclate(args),DELTA);

    }
}