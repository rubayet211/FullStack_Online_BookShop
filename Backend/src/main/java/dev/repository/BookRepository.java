package dev.repository;

import dev.domain.Book;
import dev.domain.Order;
import dev.domain.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class BookRepository {

    private final SessionFactory sessionFactory;
    @Autowired
    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> userQuery = session.createQuery("from Book", Book.class);
        return userQuery.getResultList();
    }
    public void edit(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = get(id);
        session.delete(book);
    }

    public Book get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public Book updateBookById(int id, Book updatedBook) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if (book != null) {
            book.setName(updatedBook.getName());
            book.setCost(updatedBook.getCost());
            book.setPrice(updatedBook.getPrice());
            session.saveOrUpdate(book);
        }
        return book;
    }

    public int count()
    {
        Session session = sessionFactory.getCurrentSession();
        Long cnt = session.createQuery("select count(*) from Book", Long.class).uniqueResult();
        return cnt.intValue();
    }
}
