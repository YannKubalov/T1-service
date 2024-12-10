package org.t1.service;

import org.springframework.stereotype.Service;
import org.t1.data.User;
import org.t1.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String username) {
        var user = new User();
        user.setUserName(username);
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, String username) {
        var user = getUserById(id);
        user.setUserName(username);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        var user = getUserById(id);
        userRepository.delete(user);
    }
}

