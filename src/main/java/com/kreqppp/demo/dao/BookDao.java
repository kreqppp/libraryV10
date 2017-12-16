package com.kreqppp.demo.dao;

import com.kreqppp.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {
}
