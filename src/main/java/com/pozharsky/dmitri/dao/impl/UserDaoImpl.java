package com.pozharsky.dmitri.dao.impl;

import com.pozharsky.dmitri.dao.UserDao;
import com.pozharsky.dmitri.entity.User;
import com.pozharsky.dmitri.exception.UserDaoException;
import com.pozharsky.dmitri.store.UserWarehouse;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public final static UserDaoImpl INSTANCE = new UserDaoImpl();

    private UserDaoImpl() {
    }

    @Override
    public User findUserByEmail(String email) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        User user = null;
        for (int i = 0; i < userWarehouse.size(); i++) {
            User warehouseUser = userWarehouse.getUser(i);
            if (email.equals(warehouseUser.getEmail())) {
                user = warehouseUser;
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userWarehouse.size(); i++) {
            users.add(userWarehouse.getUser(i));
        }
        return users;
    }

    @Override
    public User findById(long id) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        User user = null;
        for (int i = 0; i < userWarehouse.size(); i++) {
            User warehouseUser = userWarehouse.getUser(i);
            if (id == warehouseUser.getId()) {
                user = warehouseUser;
            }
        }
        return user;
    }

    @Override
    public boolean delete(long id) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        boolean flag = false;
        for (int i = 0; i < userWarehouse.size(); i++) {
            User warehouseUser = userWarehouse.getUser(i);
            if (id == warehouseUser.getId()) {
                flag = userWarehouse.removeUser(warehouseUser);
            }
        }
        return flag;
    }

    @Override
    public boolean delete(User entity) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        return userWarehouse.removeUser(entity);
    }

    @Override
    public boolean create(User entity) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        return userWarehouse.addUser(entity);
    }

    @Override
    public User update(User entity) throws UserDaoException {
        UserWarehouse userWarehouse = UserWarehouse.INSTANCE;
        User user = null;
        for (int i = 0; i < userWarehouse.size(); i++) {
            User warehouseUser = userWarehouse.getUser(i);
            if (entity.getId() == warehouseUser.getId()) {
                user = userWarehouse.setUser(i, entity);
            }
        }
        return user;
    }
}
