package com.kreqppp.demo.service;

import com.kreqppp.demo.dao.AuthorDao;
import com.kreqppp.demo.model.Author;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
public class AuthorService {

    private AuthorDao authorDao;

    public void save(Author author){
        authorDao.save(author);
    }
}
