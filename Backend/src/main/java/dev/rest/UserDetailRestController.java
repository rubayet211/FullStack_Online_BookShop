package dev.rest;

import dev.domain.UserDetail;
import dev.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user-details")
public class UserDetailRestController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailRestController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public List<UserDetail> getAllCustomerDetails() throws SQLException {
        return userDetailService.getAllCustomerDetails();
    }

    @GetMapping("/{id}")
    public UserDetail getCustomerDetailById(@PathVariable int id) throws SQLException {
        return userDetailService.getCustomerDetailById(id);
    }

    @PostMapping
    public String createCustomerDetail(@RequestBody UserDetail userDetail) throws SQLException {
        userDetailService.createCustomerDetail(userDetail);
        return "Successful";
    }

    @PutMapping("/{id}")
    public String updateCustomerDetail(@PathVariable int id, @RequestBody UserDetail userDetail) throws SQLException {
        UserDetail existingDetail = userDetailService.getCustomerDetailById(id);
        if (existingDetail != null) {
            userDetail.setId(id);
            userDetailService.updateCustomerDetail(userDetail);
            return "Successful";
        } else {
            return "Customer detail not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerDetail(@PathVariable int id) throws SQLException {
        userDetailService.deleteCustomerDetailById(id);
        return "Successful";
    }
}
