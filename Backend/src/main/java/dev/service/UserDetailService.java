package dev.service;

import dev.domain.UserDetail;
import dev.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserDetailService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    public void createCustomerDetail(UserDetail userDetail) throws SQLException {
        try {
            userDetailRepository.createDetail(userDetail);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error creating user detail", ex);
        }
    }

    public List<UserDetail> getAllCustomerDetails() throws SQLException {
        try {
            return userDetailRepository.findAll();
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving all user details", ex);
        }
    }

    public UserDetail getCustomerDetailById(int id) throws SQLException {
        try {
            return userDetailRepository.findById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error retrieving user detail by ID", ex);
        }
    }

    public void updateCustomerDetail(int id, UserDetail userDetail) throws SQLException {
        try {
            userDetailRepository.updateCustomerDetail(id, userDetail);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error updating user detail", ex);
        }
    }

    public void deleteCustomerDetailById(int id) throws SQLException {
        try {
            userDetailRepository.deleteById(id);
        } catch (Exception ex) {
            // Log the exception or rethrow a more specific exception
            throw new SQLException("Error deleting user detail by ID", ex);
        }
    }
}
