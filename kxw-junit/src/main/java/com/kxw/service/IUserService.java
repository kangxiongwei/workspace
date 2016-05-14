package com.kxw.service;

import com.kxw.dao.IUserDao;
import com.kxw.model.User;

/**
 * Created by kangxiongwei on 16/5/14 下午12:13.
 */
public interface IUserService {

    void add(User user);

    void delete(String username);

    User load(String username);

    void setUserDao(IUserDao userDao);

}
