package com.pozharsky.dmitri.stub;

public class UserStub {
    private static final String USER_EMAIL = "user@gmail.com";
    private static final String USER_PASSWORD = "123456789";

    public static boolean checkUser(String email, String password){
        return email.equals(USER_EMAIL) && password.equals(USER_PASSWORD);
    }
}
