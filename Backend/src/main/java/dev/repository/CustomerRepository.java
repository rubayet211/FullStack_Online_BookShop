package dev.repository;

import dev.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public void updateCustomer(int id, Customer updatedCustomer) {
        Session session = sessionFactory.getCurrentSession();
        // Retrieve the existing customer
        Customer existingCustomer = session.get(Customer.class, id);

        // Update the existing customer with the new details
        if (existingCustomer != null) {
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            // Update other fields as needed

            // Save the updated customer
            session.update(existingCustomer);
        }
    }

    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    public Customer findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = findById(id);
        session.delete(customer);
    }

    public Customer findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer where email = :email", Customer.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }
}
