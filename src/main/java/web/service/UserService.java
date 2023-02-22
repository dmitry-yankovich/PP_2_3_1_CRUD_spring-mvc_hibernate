package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    User findById (long id);
    List<User> userList(int number);

    void save(User user);

    void delete(long id);

    void update(long id, User user);
}
