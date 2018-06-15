package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> showList() {
        return memoryBookService.getList();
    }

    @RequestMapping("/{id}")
    public Book showId(@PathVariable long id) {
        return memoryBookService.getItemById(id);
    }

    @RequestMapping(value = "/addBook" ,method = RequestMethod.POST)
    public Book addBook(@RequestParam Long id,@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        Book book = new Book(id,isbn,title,author,publisher,type);
        memoryBookService.addBook(book);
        return book;
    }

}
