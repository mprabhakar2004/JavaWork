package com.home.test.secondfactorauthenticator.dao;

import com.home.test.secondfactorauthenticator.model.User;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    Map<String, User> userMap=new HashMap<>();
    void loadUser();
    User saveUser(User user);
    User getUser(String userId);
}
