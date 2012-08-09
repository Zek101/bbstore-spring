package com.example.bbstore.dom;

import java.io.Serializable;

import javax.persistence.*;

import com.example.bbstore.dao.BaseEntity;


@SuppressWarnings("serial")
@Entity
public class Book extends BaseEntity implements Serializable{
    private String isbn;
    private String title;
    @ManyToOne(fetch= FetchType.LAZY)
    private Author author;
    private int price;
    public Book(){}
    public Book(String isbn, String title, Author author,int price){
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }
    //GETTER
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    

    public String toString() {
        return this.getTitle();
    }
}
