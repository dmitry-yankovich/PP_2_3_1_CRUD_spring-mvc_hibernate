package web.dao;

import web.models.User;

import java.util.List;


public interface UserDao {

    User findById (long id);
    List<User> index();
    List<User> userList(int number);

    void save(User user);

    void delete(long id);

    void update(long id, User user);
}
