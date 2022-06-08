package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Qualifier
    @PersistenceContext
    EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public void delete(long id) {
        User user = showUser(id);
        entityManager.remove(user);
    }

    public List<User> listUsers() {

        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user", User.class);
        return query.getResultList();
    }

    public User showUser(long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user, long id) {
        entityManager.merge(user);
    }
}
