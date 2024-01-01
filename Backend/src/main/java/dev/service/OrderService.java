package dev.service;

import dev.domain.Order;
import dev.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(int id, Order updatedOrder) {
        // Perform validation or additional logic if needed
        updatedOrder.setId(id);
        orderRepository.save(updatedOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
