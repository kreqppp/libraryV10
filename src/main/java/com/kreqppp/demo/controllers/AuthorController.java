package com.kreqppp.demo.controllers;

import com.kreqppp.demo.model.Author;
import com.kreqppp.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    /*
    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author("Edgar","Poe", "The Pit and the Pendulum"));
        authors.add(new Author("Taras","Shevchenko","Kobzar"));
    }*/

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/authorTable"}, method = RequestMethod.GET)
    public String authorTable(Model model){
        model.addAttribute("authors", authorService.getAll());
        return "/authorTable";
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @RequestMapping(value = "/addAuthor/submit", method = RequestMethod.POST)
    public String submitAuthor(Model model, @ModelAttribute("author") Author author) {

        if (!author.getFirstName().isEmpty())
            if  (!author.getLastName().isEmpty())
                if (!author.getBook().isEmpty()) {
                    this.authorService.save(author);
                    return "redirect:../authorTable";
                }
        model.addAttribute("errorMessage", errorMessage);
        return "addAuthor";
    }

}
