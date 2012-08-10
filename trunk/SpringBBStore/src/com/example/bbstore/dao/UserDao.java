package com.example.bbstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bbstore.dom.Book;
import com.example.bbstore.dom.User;
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UserDao extends BaseRepository<User> {
	
	public  List<Book> findAllUsers(){
        return em.createQuery("select u from User u").getResultList();
    }

}
