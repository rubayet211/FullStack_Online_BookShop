package dev.repository;

import dev.domain.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDetailRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createDetailDetail(UserDetail userDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userDetail);
    }

    public List<UserDetail> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserDetail", UserDetail.class).list();
    }

    public UserDetail findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserDetail.class, id);
    }

    public void updateCustomerDetail(int id, UserDetail userDetail) {
        Session session = sessionFactory.getCurrentSession();
        UserDetail existingUserDetail = session.get(UserDetail.class, id);
        session.update(existingUserDetail);
    }


    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserDetail userDetail = findById(id);
        session.delete(userDetail);

    }
}
