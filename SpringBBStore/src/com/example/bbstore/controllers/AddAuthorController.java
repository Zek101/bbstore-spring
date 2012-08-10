package com.example.bbstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dom.Author;

@Controller
public class AddAuthorController {
    @Autowired    AuthorDao authorDao;
    @Autowired    MenuController menuController;
    
    @RequestMapping(value={"/createAuthor"})
    public String createAuthor(){
        return "addauthor";
    } 
    
    @RequestMapping(value={"/addauthor"})
    public ModelAndView addAuthor( @ModelAttribute Author author){

        authorDao.persist(author);
        return menuController.showMenu();
    } 
}
