package com.pozharsky.dmitri.dao;

import com.pozharsky.dmitri.entity.Entity;
import com.pozharsky.dmitri.exception.UserDaoException;

import java.util.List;

public interface BaseDao<T extends Entity> {
    List<T> findAll() throws UserDaoException;

    T findById(long id) throws UserDaoException;

    boolean delete(long id) throws UserDaoException;

    boolean delete(T entity) throws UserDaoException;

    boolean create(T entity) throws UserDaoException;

    T update(T entity) throws UserDaoException;
}
