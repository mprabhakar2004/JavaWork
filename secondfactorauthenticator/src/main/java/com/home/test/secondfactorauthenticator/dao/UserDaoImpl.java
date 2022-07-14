package com.home.test.secondfactorauthenticator.dao;

import com.home.test.secondfactorauthenticator.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImpl implements UserDao{

    public UserDaoImpl(){
        loadUser();
    }

    @Override
    public void loadUser() {

        User user1 = new User("manish@sap.com");
        User user2 = new User("rohan@sap.com");
        User user3 = new User("aman@sap.com");
        userMap.put(user1.getUserId(),user1);
        userMap.put(user2.getUserId(),user2);
        userMap.put(user3.getUserId(),user3);
    }

    @Override
    public User saveUser(User user) {
        userMap.put(user.getUserId(),user);
        return user;
    }

    @Override
    public User getUser(String userId) {
        return userMap.getOrDefault(userId,new User(userId));
    }
}
