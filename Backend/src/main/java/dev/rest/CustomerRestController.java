package dev.rest;

import dev.domain.Customer;
import dev.domain.CustomerDetail;
import dev.service.CustomerDetailService;
import dev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;
    private final CustomerDetailService customerDetailService;

    public CustomerRestController(CustomerService customerService, CustomerDetailService customerDetailService) {

        this.customerService = customerService;
        this.customerDetailService = customerDetailService;
    }

    @PostMapping("/customers/create")
    public String createCustomer(@RequestBody Customer customer) throws SQLException {
        customerService.createCustomer(customer);
        return "Customer created successfully";
    }

    @PutMapping("/customers/{id}")
    public String updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) throws SQLException {
        customerService.updateCustomer(id, customer);
        return "Update Successful";
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() throws SQLException {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) throws SQLException {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) throws SQLException {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String email, @RequestParam String password) throws SQLException {
        boolean signInSuccessful = customerService.signIn(email, password);

        if (signInSuccessful) {
            return "Sign in successful";
        } else {
            return "Invalid email or password";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody Customer customer, @RequestBody CustomerDetail customerDetail) throws SQLException {
        // Additional validation or business logic if needed
        customerService.createCustomer(customer);
        customerDetailService.createCustomerDetail(customerDetail);

        return "Registration Successful";
    }
}
