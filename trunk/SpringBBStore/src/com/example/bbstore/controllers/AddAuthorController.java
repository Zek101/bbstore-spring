package com.example.bbstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dom.Author;

@Controller
public class AddAuthorController {
    @Autowired    AuthorDao authorDao;
    
    @RequestMapping(value={"/createAuthor"})
    public String createAuthor(){
        return "addauthor";
    } 
    
    @RequestMapping(value={"/addauthor"})
    public String addAuthor( @ModelAttribute Author author){

        authorDao.persist(author);
        return "index";
    } 
}
