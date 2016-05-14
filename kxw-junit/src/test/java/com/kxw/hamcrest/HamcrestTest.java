package com.kxw.hamcrest;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * hamcrest增强了junit的能力,提供了各种比较函数
 * <p>
 * Created by kangxiongwei on 16/5/14 上午11:32.
 */
public class HamcrestTest {

    @Test
    public void testHamcrest() {
        assertThat(50, greaterThan(30));
    }

    /**
     * allOf 里面多个条件,会全部执行成功才算成功
     */
    @Test
    public void testHamcrest02() {
        String a = "abcdhelloworld";
        assertThat(a, instanceOf(String.class));
        assertThat(a, allOf(startsWith("a"), endsWith("d"), containsString("hello")));
    }

}
