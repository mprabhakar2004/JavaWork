package com.home.test.secondfactorauthenticator.model;

public class User {
    User(){}

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    private String userId;

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    private String secretKey;
}
