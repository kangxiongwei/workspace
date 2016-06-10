package com.kxw.ch01;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kangxiongwei on 16/6/11 上午1:45.
 */
public class CalculatorTest01 {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        Assert.assertEquals(60, result, 0);
    }


}
