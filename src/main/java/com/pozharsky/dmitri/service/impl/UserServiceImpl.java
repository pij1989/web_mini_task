package com.pozharsky.dmitri.service.impl;

import com.pozharsky.dmitri.dao.impl.UserDaoImpl;
import com.pozharsky.dmitri.entity.User;
import com.pozharsky.dmitri.exception.UserDaoException;
import com.pozharsky.dmitri.exception.UserServiceException;
import com.pozharsky.dmitri.generator.UserIdGenerator;
import com.pozharsky.dmitri.service.UserService;
import com.pozharsky.dmitri.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    public final static UserServiceImpl INSTANCE = new UserServiceImpl();

    private UserServiceImpl() {
    }

    @Override
    public boolean checkUser(String email, String password) throws UserServiceException {
        try {
            UserDaoImpl userDao = UserDaoImpl.INSTANCE;
            User user = userDao.findUserByEmail(email);
            if (user != null) {
                return user.getEmail().equals(email) && user.getPassword().equals(password);
            } else {
                return false;
            }
        } catch (UserDaoException e) {
            logger.error(e);
            throw new UserServiceException(e);
        }
    }

    @Override
    public boolean createUser(String email, String password) throws UserServiceException {
        try {
            UserDaoImpl userDao = UserDaoImpl.INSTANCE;
            UserValidator userValidator = UserValidator.INSTANCE;
            if (userValidator.isEmail(email) && userValidator.isPassword(password)) {
                if (userDao.findUserByEmail(email) == null) {
                    User user = new User(UserIdGenerator.generate(), email, password);
                    return userDao.create(user);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (UserDaoException e) {
            logger.error(e);
            throw new UserServiceException(e);
        }
    }
}
