package dev.rest;

import dev.domain.CustomerDetail;
import dev.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-details")
public class CustomerDetailRestController {

    private final CustomerDetailService customerDetailService;

    @Autowired
    public CustomerDetailRestController(CustomerDetailService customerDetailService) {
        this.customerDetailService = customerDetailService;
    }

    @GetMapping
    public List<CustomerDetail> getAllCustomerDetails() {
        return customerDetailService.getAllCustomerDetails();
    }

    @GetMapping("/{id}")
    public CustomerDetail getCustomerDetailById(@PathVariable int id) {
        return customerDetailService.getCustomerDetailById(id);
    }

    @PostMapping
    public String createCustomerDetail(@RequestBody CustomerDetail customerDetail) {
        customerDetailService.createCustomerDetail(customerDetail);
        return "Successful";
    }

    @PutMapping("/{id}")
    public String updateCustomerDetail(@PathVariable int id, @RequestBody CustomerDetail customerDetail) {
        CustomerDetail existingDetail = customerDetailService.getCustomerDetailById(id);
        if (existingDetail != null) {
            customerDetail.setId(id);
            customerDetailService.updateCustomerDetail(customerDetail);
            return "Successful";
        } else {
            return "Customer detail not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerDetail(@PathVariable int id) {
        customerDetailService.deleteCustomerDetailById(id);
        return "Successful";
    }
}
