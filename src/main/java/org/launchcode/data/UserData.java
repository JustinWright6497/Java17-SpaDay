package org.launchcode.data;

import org.launchcode.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public static Collection<User> getAll() {
        return users.values();
    }

    public static User getById(int id) {
        return users.get(id);
    }

}
