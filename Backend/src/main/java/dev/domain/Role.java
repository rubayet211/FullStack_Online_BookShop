package dev.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Role name is required")
    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(int id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getCustomers() {
        return users;
    }

    public void setCustomers(List<User> users) {
        this.users = users;
    }
}
