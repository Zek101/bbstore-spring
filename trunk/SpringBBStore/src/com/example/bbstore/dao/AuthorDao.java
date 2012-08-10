package com.example.bbstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Author;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class AuthorDao extends BaseRepository<Author>{
    public  List<Author> getAllAuthors(){
        return em.createQuery("select a from Author a").getResultList();
    }
    public void addAuthor(String name, String forname){
        Author a = new Author();
        a.setForname(forname);
        a.setName(name);
        em.persist(a);
    }
}
