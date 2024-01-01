package dev.rest;

import dev.domain.Order;
import dev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders/create")
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "Order created successfully";
    }

    @PutMapping("/orders/{id}")
    public String updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
        return "Update Successful";
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}