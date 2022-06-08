package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(long id);
    List<User> listUsers();
    User showUser(long id);
    void update(User user, long id);
}
