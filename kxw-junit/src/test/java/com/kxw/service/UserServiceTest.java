package com.kxw.service;

import com.kxw.dao.IUserDao;
import com.kxw.dao.UserStubDao;
import com.kxw.model.User;
import com.kxw.model.UserException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kangxiongwei on 16/5/14 下午12:14.
 */
public class UserServiceTest {

    private User user;

    private IUserService userService;
    private IUserDao userDao;

    @Before
    public void setUp() {
        user = new User("kangxiongwei", "kxw", "123456");
        userService = new UserService();
        userDao = new UserStubDao();
        userService.setUserDao(userDao);
    }


    @Test
    public void testAdd() {
        User expect = user;
        userService.add(expect);
        User actual = userService.load(user.getUsername());

        assertEquals(expect.getUsername(), actual.getUsername());
        assertEquals(expect.getNickname(), actual.getNickname());
        assertEquals(expect.getPassword(), actual.getPassword());
    }

    @Test(expected = UserException.class)
    public void testAddException() {
        userService.add(user);
        User user1 = new User("kangxiongwei", "kxw", "123456");
        userService.add(user1);
    }

    @Test
    public void testDelete() {
        userService.add(user);
        User u = userService.load(user.getUsername());
        assertNotNull(u);
        userService.delete(user.getUsername());
        assertNull(userService.load(u.getUsername()));
    }

    @Test(expected = UserException.class)
    public void testDeleteUserNotExist(){
        userService.delete("abc");
    }


}
