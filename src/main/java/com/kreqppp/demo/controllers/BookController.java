package com.kreqppp.demo.controllers;

import com.kreqppp.demo.model.Book;
import com.kreqppp.demo.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("The Pit and the Pendulum","Edgar Poe","horror",1842));
        books.add(new Book("Kobzar","Taras Shevchenko","Poetyca",1840));
    }


    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String welcome(){
        return "index";
    }

    @RequestMapping(value = {"/bookTable"}, method = RequestMethod.GET)
    public String bookTable(Model model){
        model.addAttribute("books", books);
        return "bookTable";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/addBook/submit", method = RequestMethod.POST)
    public String submitBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:../bookTable";
    }




}
