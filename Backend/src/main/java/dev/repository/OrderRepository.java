package dev.repository;

import dev.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    public Order findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> orderQuery =session.createQuery("from Order", Order.class);
        return orderQuery.getResultList();
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = findById(id);
        session.delete(order);
    }

    public void updateById(int id, Order updatedOrder) {
        Session session = sessionFactory.getCurrentSession();
        Order order = findById(id);
        session.update(order);

    }
}