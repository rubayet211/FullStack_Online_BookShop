package dev.repository;

import dev.domain.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(role);
    }

    public Role findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    public List<Role> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Role", Role.class).list();
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = findById(id);
        session.delete(role);
    }

    public void updateById(int id, Role updatedRole) {
        Session session = sessionFactory.getCurrentSession();
        Role existingRole = session.get(Role.class, id);

        if (existingRole != null) {
            existingRole.setName(updatedRole.getName());
            // Update other fields as needed

            session.update(existingRole);
        }
    }
}
