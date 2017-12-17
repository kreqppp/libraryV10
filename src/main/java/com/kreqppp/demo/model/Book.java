package com.kreqppp.demo.model;



import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book implements Comparable<Book> {

    @Id
    @Column
    @GeneratedValue
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                yearOfPublication == book.yearOfPublication &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, author, genre, yearOfPublication);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
