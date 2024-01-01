package dev.rest;

import dev.domain.Customer;
import dev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return "Customer created successfully";
    }

    @PutMapping
    public String updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id);
        return "Update Successful";
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}
