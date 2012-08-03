package com.example.bbstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Book;

import com.example.bbstore.dao.BookDao;



@Transactional
@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
    public boolean addPerson(Book bk){
        return bookDao.addBook(bk);
    }
}
