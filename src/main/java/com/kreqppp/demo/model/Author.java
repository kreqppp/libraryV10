package com.kreqppp.demo.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Author implements Comparable<Author>{

    @Id
    @Column
    @GeneratedValue
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(book, author.book);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", book='" + book + '\'' +
                '}';
    }

    @Override
    public int compareTo(Author o) {
        return 0;
    }
}
