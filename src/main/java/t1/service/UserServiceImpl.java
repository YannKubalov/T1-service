package t1.service;

import org.springframework.stereotype.Service;
import t1.data.User;
import t1.repository.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(String username) {
        userDao.createUser(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long id, String username) {
        var user = new User();
        user.setId(id);
        user.setUserName(username);
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}

