package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import web.models.Color;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManagerFactory emf;

    public User findById (long id) {
        EntityManager em = emf.createEntityManager();

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

        TypedQuery<User> query = emf.createEntityManager().createQuery("select u from User u", User.class);
        if (number != 0) {
            query.setMaxResults(number);
        }
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, id);

        em.getTransaction().begin();

        em.remove(user);

        em.getTransaction().commit();
    }

    @Override
    public void update(long id, User user) {

        EntityManager em = emf.createEntityManager();

        User userToBeUpdated = em.find(User.class, id);

        em.getTransaction().begin();

        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());

        em.getTransaction().commit();
    }
}
