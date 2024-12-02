package org.t1.service;

import org.t1.data.User;

import java.util.List;

public interface UserService {

    void createUser(String username);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(Long id, String username);

    void deleteUser(Long id);
}
