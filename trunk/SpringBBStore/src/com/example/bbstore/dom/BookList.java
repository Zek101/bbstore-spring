package com.example.bbstore.dom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bbstore.dao.BookDao;



public class BookList {
    
    Map<String,Book> listBooks = new HashMap<String, Book>();
    
    public BookList(){
    }
    public List<Book> getBooks(){
        return  new ArrayList<Book>(listBooks.values());
    }
    public Book getBook(String isbn){
        return listBooks.get(isbn);
    }
}
