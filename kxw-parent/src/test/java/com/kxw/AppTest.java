package com.kxw;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kangxiongwei on 16/5/14.
 */
public class AppTest {

    @Test
    public void test01(){
        String expect = "kangxiongwei";
        App app = EasyMock.createStrictMock(App.class);
        String info = "word! ";
        EasyMock.expect(app.say(info)).andReturn(expect);
        EasyMock.replay(app);
        String actual = app.say(info);
        Assert.assertEquals(expect, actual);
        EasyMock.verify(app);
    }

}
