package com.kxw.ch01;

/**
 * Created by kangxiongwei on 16/6/11 上午1:28.
 */
public class CalculatorTest {

    private int nbErrors = 0;

    void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(5, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.testAdd();
        } catch (Exception e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors + " errors");
        }
    }

}
