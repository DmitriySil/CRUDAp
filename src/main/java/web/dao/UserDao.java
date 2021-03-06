package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(long id);
    List<User> listUsers();
    User showUser(long id);
    void update(User user, long id);
}
