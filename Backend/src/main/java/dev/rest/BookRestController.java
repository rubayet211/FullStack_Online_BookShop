package dev.rest;

import dev.domain.Book;
import dev.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @PostMapping("/books")
    public String createBook(@RequestBody Book book) {
        bookService.create(book);
        return "Successful";
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.get(id);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.delete(id);
        return "Successful";
    }
}