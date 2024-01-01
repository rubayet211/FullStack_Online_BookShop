package dev.service;

import dev.domain.CustomerDetail;
import dev.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerDetailService {

    private final CustomerDetailRepository customerDetailRepository;

    public CustomerDetailService(CustomerDetailRepository customerDetailRepository) {
        this.customerDetailRepository = customerDetailRepository;
    }

    public void createCustomerDetail(CustomerDetail customerDetail) {
        customerDetailRepository.createCustomerDetail(customerDetail);
    }

    public List<CustomerDetail> getAllCustomerDetails() {
        return customerDetailRepository.findAll();
    }

    public CustomerDetail getCustomerDetailById(int id) {
        return customerDetailRepository.findById(id);
    }

    public void updateCustomerDetail(CustomerDetail customerDetail) {
        customerDetailRepository.updateCustomerDetail(customerDetail);
    }

    public void deleteCustomerDetailById(int id) {
        customerDetailRepository.deleteById(id);
    }
}
