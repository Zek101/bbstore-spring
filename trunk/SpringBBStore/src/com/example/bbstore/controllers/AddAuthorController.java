package com.example.bbstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bbstore.dao.AuthorDao;

@Controller
public class AddAuthorController {
    @Autowired    AuthorDao aDao;
    
    @RequestMapping(value={"/createAuthor"})
    public String createAuthorForm(){
        return "newauthor";
    } 
    @RequestMapping(value={"/addauthor"})
    public String createNewAuthor( @RequestParam("name")String name, @RequestParam("forname") String forname){

        aDao.addAuthor(name,forname);
        return "index";
    } 
}
