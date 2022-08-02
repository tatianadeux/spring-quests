package wcs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import wcs.rest.entity.Book;
import wcs.rest.repository.BookRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    /* Get All */
    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    /* Get One*/
    @GetMapping("/books/{id}")
    public Book getById(@PathVariable int id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        /* raccourci pour un if-else */
        return bookOptional.orElse(null);
    }

    /* Post : Create */
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

    /* Post : search by keword */
    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String keyword = body.get("text");
        return bookRepository.findByKewordInTitleOrDescription(keyword);
    }

    /* Put : update */
    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return bookRepository.save(bookToUpdate);
    }

    /* Delete */
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        bookRepository.deleteById(id);
        return true;
    }
}
