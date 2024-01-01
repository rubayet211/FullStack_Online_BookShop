package dev.repository;

import dev.domain.CustomerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDetailRepository {

    private final SessionFactory sessionFactory;


    public CustomerDetailRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCustomerDetail(CustomerDetail customerDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customerDetail);
    }

    public List<CustomerDetail> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CustomerDetail", CustomerDetail.class).list();
    }

    public CustomerDetail findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CustomerDetail.class, id);
    }

    public void updateCustomerDetail(CustomerDetail customerDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customerDetail);
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerDetail customerDetail = findById(id);
        session.delete(customerDetail);

    }
}
