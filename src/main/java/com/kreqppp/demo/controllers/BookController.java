package com.kreqppp.demo.controllers;

import com.kreqppp.demo.model.Book;
import com.kreqppp.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    /*
    private static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book("The Pit and the Pendulum","Edgar Poe","horror",1842));
        books.add(new Book("Kobzar","Taras Shevchenko","Poetyca",1840));
    }*/

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String welcome(){
        return "index";
    }

    @RequestMapping(value = {"/bookTable"}, method = RequestMethod.GET)
    public String bookTable(Model model){
        model.addAttribute("books", bookService.getAll());
        return "bookTable";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/addBook/submit", method = RequestMethod.POST)
    public String submitBook(Model model, @ModelAttribute("book") Book book) {
        if(!book.getTitle().isEmpty()) {
            if (!book.getAuthor().isEmpty())
                if (!book.getGenre().isEmpty())
                    if (book.getYearOfPublication() >= 0) {
                        this.bookService.save(book);
                        return "redirect:../bookTable";
                    }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addBook";

    }




}
