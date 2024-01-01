package dev.service;

import dev.domain.Customer;
import dev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    public void updateCustomer(int id, Customer updatedCustomer) {
        // Perform validation or additional logic if needed
        customerRepository.updateCustomer(id, updatedCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public boolean signIn(String email, String password) {

        Customer customer = customerRepository.findByEmail(email);


        return customer != null && customer.getPassword().equals(password);
    }
}
