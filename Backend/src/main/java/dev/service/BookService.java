package dev.service;

import dev.domain.Book;
import dev.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book) throws SQLException {
        try {
            bookRepository.createBook(book);
        } catch (Exception ex) {
            throw new SQLException("Error creating book", ex);
        }
    }

    public Book findById(int id) throws SQLException {
        try {
            return bookRepository.findById(id);
        } catch (Exception ex) {
            throw new SQLException("Error retrieving book by ID", ex);
        }
    }

    public List<Book> findAll() throws SQLException {
        try {
            return bookRepository.findAll();
        } catch (Exception ex) {
            throw new SQLException("Error retrieving all books", ex);
        }
    }

    public List<Book> findByName(String name) throws SQLException {
        try {
            return bookRepository.findByName(name);
        } catch (Exception ex) {
            throw new SQLException("Error retrieving books by name", ex);
        }
    }

    public void deleteById(int id) throws SQLException {
        try {
            bookRepository.deleteById(id);
        } catch (Exception ex) {
            throw new SQLException("Error deleting book", ex);
        }
    }

    public void updateById(int id, Book updatedBook) throws SQLException {
        try {
            bookRepository.updateById(id, updatedBook);
        } catch (Exception ex) {
            throw new SQLException("Error updating book by ID", ex);
        }
    }
}