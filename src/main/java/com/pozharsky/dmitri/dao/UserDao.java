package com.pozharsky.dmitri.dao;

import com.pozharsky.dmitri.entity.User;
import com.pozharsky.dmitri.exception.UserDaoException;

public interface UserDao extends BaseDao<User> {
    User findUserByEmail(String email) throws UserDaoException;
}
