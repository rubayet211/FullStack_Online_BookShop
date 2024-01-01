package dev.repository;

import dev.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCustomer(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void updateCustomer(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        // Retrieve the existing customer
        User existingUser = session.get(User.class, id);

        // Update the existing customer with the new details
        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // Update other fields as needed

            // Save the updated customer
            session.update(existingUser);
        }
    }

    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }

    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }
}
