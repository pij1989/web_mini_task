package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.exception.UserServiceException;

public interface UserService {
    boolean checkUser(String email, String password) throws UserServiceException;

    boolean createUser(String email, String password) throws UserServiceException;
}
