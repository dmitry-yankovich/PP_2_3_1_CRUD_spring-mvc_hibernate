package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById (long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> userList(int number) {

        return userDao.userList(number);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }
}
