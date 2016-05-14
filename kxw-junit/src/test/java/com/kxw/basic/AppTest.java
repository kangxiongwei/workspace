package com.kxw.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * junit的基本测试
 * 静态导入目的是兼容junit3
 * <p>
 * Created by kangxiongwei on 16/5/14 上午11:16.
 */
public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testAdd() {
        int actual = app.add(5, 3);
        assertEquals("加法有问题", actual, 8);
    }

    @Test
    public void testDivision() {
        int actual = app.division(5, 3);
        assertEquals("除法有问题", actual, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionException() {
        app.division(5, 0);
    }
}
