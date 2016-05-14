package com.kxw.service;

import com.kxw.dao.IUserDao;
import com.kxw.model.User;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * createMock验证不验证方法的执行顺序,只验证方法的执行次数
 * createStrictMock既验证顺序又验证次数
 *
 * Created by kangxiongwei on 16/5/14 下午1:03.
 */
public class EasyMockTest {

    @Test
    public void testLoad() {
        User user = new User("admin", "管理员", "123456");
        //进入record阶段
        IUserDao userDao = createMock(IUserDao.class);
        //记录userDao可能会发生的操作
        //验证阶段验证的是这里所记录的过程,指的是程序中的所有流程,即userService中load方法中执行的所有操作
        expect(userDao.load("test")).andReturn(user);
        //返回值为void的处理
        userDao.delete("test");
        expectLastCall();
        expect(userDao.load("admin")).andReturn(user);
        //replay阶段,进入测试阶段
        replay(userDao);
        IUserService userService = new UserService();
        userService.setUserDao(userDao);
        User u = userService.load("admin");
        assertEquals(user.getUsername(), u.getUsername());
        assertEquals(user.getNickname(), u.getNickname());
        assertEquals(user.getPassword(), u.getPassword());
        //verify阶段,验证交互关系
        verify(userDao);
    }

}
