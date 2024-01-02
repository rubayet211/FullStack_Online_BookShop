package dev.service;

import dev.domain.Book;
import dev.domain.UserDetail;
import dev.repository.BookRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void create(Book book) {
        bookRepository.create(book);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book get(int id) {
        return bookRepository.get(id);
    }

    public void delete(int id) {
        bookRepository.delete(id);
    }

    public Book updateBookById(int id, Book book)
    {
        return bookRepository.updateBookById(id, book);
    }




}