package com.kreqppp.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private int yearOfPublication;

    public Book() {
    }

    public Book(String title, String author, String genre, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
    }
}
