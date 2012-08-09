package com.example.bbstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Author;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class AuthorDao extends BaseRepository<Author>{
    public  List<Author> getAllAuthors(){
        Long i = (Long)em.createQuery("select count(a) from Author a").getSingleResult();
        List<Author> lp = new ArrayList<Author>();
        if (i>0){
           lp = em.createQuery("select a from Author a").getResultList();
        }
        return lp;
    }
    public void persist(Author author){
        em.persist(author);
       
    }
    public void addAuthor(String name, String forname){
        Author a = new Author();
        a.setForname(forname);
        a.setName(name);
        em.persist(a);
    }
    public void merge(Author bk){
        em.merge(bk);
       
   }
}
