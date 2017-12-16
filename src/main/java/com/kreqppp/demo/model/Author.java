package com.kreqppp.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String book;

    public Author() {
    }

    public Author(String firstName, String lastName, String book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
    }
}
