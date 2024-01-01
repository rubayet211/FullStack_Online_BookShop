package dev.repository;

import dev.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return session.createQuery("from Order", Order.class).list();
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = findById(id);
        session.delete(order);
    }

    public void updateById(int id, Order updatedOrder) {
        Session session = sessionFactory.getCurrentSession();
        Order existingOrder = findById(id);

        if (existingOrder != null) {
            // Update the existing order with the new details
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setAddress(updatedOrder.getAddress());
            existingOrder.setCustomerDetail(updatedOrder.getCustomerDetail());
            existingOrder.setBooks(updatedOrder.getBooks());

            // Save the updated order
            session.update(existingOrder);
        }
    }
}