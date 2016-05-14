package com.kxw.dao;

import com.kxw.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kangxiongwei on 16/5/14 下午12:53.
 */
public class UserStubDao implements IUserDao {

    private Map<String, User> map = new HashMap<>();

    @Override
    public void add(User user) {
        map.put(user.getUsername(), user);
    }

    @Override
    public void delete(String username) {
        map.remove(username);
    }

    @Override
    public User load(String username) {
        return map.get(username);
    }
}
