package dev.service;

import dev.domain.Role;
import dev.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) throws SQLException {
        try {
            roleRepository.createRole(role);
        } catch (Exception ex) {
            throw new SQLException("Error creating role", ex);
        }
    }

    public Role findById(int id) throws SQLException {
        try {
            return roleRepository.findById(id);
        } catch (Exception ex) {
            throw new SQLException("Error retrieving role by ID", ex);
        }
    }

    public List<Role> findAll() throws SQLException {
        try {
            return roleRepository.findAll();
        } catch (Exception ex) {
            throw new SQLException("Error retrieving all roles", ex);
        }
    }

    public void deleteById(int id) throws SQLException {
        try {
            roleRepository.deleteById(id);
        } catch (Exception ex) {
            throw new SQLException("Error deleting role", ex);
        }
    }

    public void updateById(int id, Role updatedRole) throws SQLException {
        try {
            roleRepository.updateById(id, updatedRole);
        } catch (Exception ex) {
            throw new SQLException("Error updating role by ID", ex);
        }
    }
}