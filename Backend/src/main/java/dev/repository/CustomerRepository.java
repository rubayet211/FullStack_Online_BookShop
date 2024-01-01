package dev.repository;

import dev.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    public Customer findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = findById(id);
        session.delete(customer);
    }
}
