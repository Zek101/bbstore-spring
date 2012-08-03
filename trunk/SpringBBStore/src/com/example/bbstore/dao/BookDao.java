package com.example.bbstore.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Book;


@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BookDao extends BaseRepository<Book>{
    
    public  List<Book> getAllBooks(){
        Long i = (Long)em.createQuery("select count(b) from Book b").getSingleResult();
        List<Book> lp = new ArrayList<Book>();
        if (i>0){
           lp = em.createQuery("select b from Book b").getResultList();
        }
        return lp;
    }
    
    public boolean addBook(Book bk){
        Long i = (Long)em.createQuery("select count(b) from Book b where b.isbn = :isbn")
        .setParameter("isbn", bk.getIsbn()).getSingleResult();
        if (i>0){
            return false;
        }
        em.persist(bk);
        return true;
    }
    
    public void updateBook(Book bk){
         em.merge(bk);
        
    }
    
    public Book getBookByIsbn(String isbn){
        Long i = (Long)em.createQuery("select count(b) from Book b where b.isbn = :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        if (i==0){
            return null;
        }
        return (Book)em.createQuery("select b from Book b where b.isbn = :isbn")
        .setParameter("isbn", isbn).getSingleResult();
    }
    

}
