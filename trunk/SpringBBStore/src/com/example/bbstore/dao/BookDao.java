package com.example.bbstore.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Book;


@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BookDao extends BaseRepository<Book>{
    
    public  List<Book> findAllBooks(){
        return em.createQuery("select b from Book b").getResultList();
    }
    
    public Book findBookByIsbn(String isbn){
        return (Book)em.createQuery("select b from Book b where b.isbn = :isbn").setParameter("isbn", isbn).getResultList().get(0);
    }
}
