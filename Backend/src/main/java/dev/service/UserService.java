package dev.service;

import dev.domain.User;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository customerRepository;

    @Autowired
    public UserService(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(User user) throws SQLException {
        try {
            customerRepository.createCustomer(user);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error creating user", ex);
        }
    }

    public void updateCustomer(int id, User updatedUser) throws SQLException {
        try {
            // Perform validation or additional logic if needed
            customerRepository.updateCustomer(id, updatedUser);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error updating user", ex);
        }
    }

    public List<User> getAllCustomers() throws SQLException {
        try {
            return customerRepository.findAll();
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving all users", ex);
        }
    }

    public User getCustomerById(int id) throws SQLException {
        try {
            return customerRepository.findById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving user by ID", ex);
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        try {
            customerRepository.deleteById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error deleting user", ex);
        }
    }

    public boolean signIn(String email, String password) throws SQLException {
        try {
            User user = customerRepository.findByEmail(email);
            return user != null && user.getPassword().equals(password);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error signing in", ex);
        }
    }
}
