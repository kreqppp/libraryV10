package com.kreqppp.demo.dao;

import com.kreqppp.demo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends CrudRepository<Author, Integer> {
}
