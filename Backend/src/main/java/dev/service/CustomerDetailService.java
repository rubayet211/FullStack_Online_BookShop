package dev.service;

import dev.domain.CustomerDetail;
import dev.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CustomerDetailService {

    private final CustomerDetailRepository customerDetailRepository;

    @Autowired
    public CustomerDetailService(CustomerDetailRepository customerDetailRepository) {
        this.customerDetailRepository = customerDetailRepository;
    }

    public void createCustomerDetail(CustomerDetail customerDetail) throws SQLException {
        try {
            customerDetailRepository.createCustomerDetail(customerDetail);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error creating customer detail", ex);
        }
    }

    public List<CustomerDetail> getAllCustomerDetails() throws SQLException {
        try {
            return customerDetailRepository.findAll();
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving all customer details", ex);
        }
    }

    public CustomerDetail getCustomerDetailById(int id) throws SQLException {
        try {
            return customerDetailRepository.findById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving customer detail by ID", ex);
        }
    }

    public void updateCustomerDetail(CustomerDetail customerDetail) throws SQLException {
        try {
            customerDetailRepository.updateCustomerDetail(customerDetail);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error updating customer detail", ex);
        }
    }

    public void deleteCustomerDetailById(int id) throws SQLException {
        try {
            customerDetailRepository.deleteById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error deleting customer detail by ID", ex);
        }
    }
}
