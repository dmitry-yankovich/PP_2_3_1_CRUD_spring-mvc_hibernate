package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    public User findById (long id) {

        User user = em.find(User.class, id);

        return user;
    }

    public List<User> index() {
        return userList();
    }

    public List<User> userList() {

        return userList(0);
    }

    public List<User> userList(int number) {

        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        if (number != 0) {
            query.setMaxResults(number);
        }
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(long id) {

        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void update(long id, User user) {

        User userToBeUpdated = em.find(User.class, id);

        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());
    }
}
