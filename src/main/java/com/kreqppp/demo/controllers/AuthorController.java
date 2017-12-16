package com.kreqppp.demo.controllers;

import com.kreqppp.demo.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {

    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author("Edgar","Poe", "The Pit and the Pendulum"));
        authors.add(new Author("Taras","Shevchenko","Kobzar"));
    }

    @RequestMapping(value = {"/authorTable"}, method = RequestMethod.GET)
    public String authorTable(Model model){
        model.addAttribute("authors", authors);
        return "/authorTable";
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }
}
