package dev.repository;

import dev.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    public Book findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book", Book.class).list();
    }

    public List<Book> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book where name = :name", Book.class)
                .setParameter("name", name)
                .list();
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = findById(id);
        session.delete(book);
    }

    public void updateById(int id, Book updatedBook) {
        Session session = sessionFactory.getCurrentSession();
        Book existingBook = findById(id);

        if (existingBook != null) {
            // Update the existing book with the new details
            existingBook.setName(updatedBook.getName());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCost(updatedBook.getCost());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setOrders(updatedBook.getOrders());

            // Save the updated book
            session.update(existingBook);
        }
    }
}
