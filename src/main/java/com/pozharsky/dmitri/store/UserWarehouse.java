package com.pozharsky.dmitri.store;

import com.pozharsky.dmitri.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserWarehouse {
    public static final UserWarehouse INSTANCE = new UserWarehouse();
    private final List<User> users;

    private UserWarehouse() {
        users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public User setUser(int index, User user) {
        return users.set(index, user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean containsUser(User user) {
        return users.contains(user);
    }

    public int size() {
        return users.size();
    }
}
