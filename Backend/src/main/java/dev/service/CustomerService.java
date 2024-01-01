package dev.service;

import dev.domain.Customer;
import dev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) throws SQLException {
        try {
            customerRepository.createCustomer(customer);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error creating customer", ex);
        }
    }

    public void updateCustomer(int id, Customer updatedCustomer) throws SQLException {
        try {
            // Perform validation or additional logic if needed
            customerRepository.updateCustomer(id, updatedCustomer);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error updating customer", ex);
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        try {
            return customerRepository.findAll();
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving all customers", ex);
        }
    }

    public Customer getCustomerById(int id) throws SQLException {
        try {
            return customerRepository.findById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving customer by ID", ex);
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        try {
            customerRepository.deleteById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error deleting customer", ex);
        }
    }

    public boolean signIn(String email, String password) throws SQLException {
        try {
            Customer customer = customerRepository.findByEmail(email);
            return customer != null && customer.getPassword().equals(password);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error signing in", ex);
        }
    }
}
