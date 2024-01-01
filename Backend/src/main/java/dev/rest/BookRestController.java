package dev.rest;


import dev.domain.Book;
import dev.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/create")
    public String createBook(@RequestBody Book book) throws SQLException {
        bookService.createBook(book);
        return "Book created successfully";
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) throws SQLException {
        return bookService.findById(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() throws SQLException {
        return bookService.findAll();
    }

    @GetMapping("/books/search")
    public List<Book> getBooksByName(@RequestParam String name) throws SQLException {
        return bookService.findByName(name);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) throws SQLException {
        bookService.deleteById(id);
        return "Book deleted successfully";
    }

    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) throws SQLException {
        bookService.updateById(id, updatedBook);
        return "Update Successful";
    }
}