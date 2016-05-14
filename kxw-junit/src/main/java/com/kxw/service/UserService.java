package com.kxw.service;

import com.kxw.dao.IUserDao;
import com.kxw.model.User;
import com.kxw.model.UserException;

/**
 * UserService
 * <p>
 * Created by kangxiongwei on 16/5/14 下午12:29.
 */
public class UserService implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        User u = this.load(user.getUsername());
        if (u != null) throw new UserException("用户已经存在");
        userDao.add(user);
    }

    @Override
    public void delete(String username) {
        User u = this.load(username);
        if (u == null) throw new UserException("需要删除的用户不存在");
        userDao.delete(username);
    }

    @Override
    public User load(String username) {
        userDao.load("test");
        userDao.delete("test");
        return userDao.load(username);
    }
}
