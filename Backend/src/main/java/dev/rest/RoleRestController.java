package dev.rest;

import dev.domain.Role;
import dev.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RoleRestController {

    private final RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/roles/create")
    public String createRole(@RequestBody Role role) throws SQLException {
        roleService.createRole(role);
        return "Role created successfully";
    }

    @GetMapping("/roles/{id}")
    public Role getRoleById(@PathVariable int id) throws SQLException {
        return roleService.findById(id);
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() throws SQLException {
        return roleService.findAll();
    }

    @DeleteMapping("/roles/{id}")
    public String deleteRole(@PathVariable int id) throws SQLException {
        roleService.deleteById(id);
        return "Role deleted successfully";
    }

    @PutMapping("/roles/{id}")
    public String updateRole(@PathVariable int id, @RequestBody Role updatedRole) throws SQLException {
        roleService.updateById(id, updatedRole);
        return "Update Successful";
    }
}