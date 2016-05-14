package com.kxw.dao;

import com.kxw.model.User;

/**
 * Created by kangxiongwei on 16/5/14 下午12:52.
 */
public interface IUserDao {

    void add(User user);

    void delete(String username);

    User load(String username);

}
