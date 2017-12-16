package com.kreqppp.demo.service;

import com.kreqppp.demo.dao.BookDao;
import com.kreqppp.demo.model.Book;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Setter
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void save(Book book){
        bookDao.save(book);
    }

    public List<Book> getAll() {
        return (List<Book>) bookDao.findAll();
    }
}
