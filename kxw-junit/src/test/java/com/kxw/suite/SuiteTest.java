package com.kxw.suite;

import com.kxw.basic.AppTest;
import com.kxw.hamcrest.HamcrestTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试组件,将多个测试组装在一起测试
 * <p>
 * Created by kangxiongwei on 16/5/14 上午11:47.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {AppTest.class, HamcrestTest.class})
public class SuiteTest {

}
