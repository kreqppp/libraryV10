package com.kreqppp.demo.dao;


import com.kreqppp.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer> {
}
