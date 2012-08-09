package com.example.bbstore.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.ShoppingBasket;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;



@Controller
public class IndexController{

    @Autowired    BookDao bDao;
    @Autowired    AuthorDao aDao;
    @Autowired    ShoppingBasket bookBasket;

   
 
    @RequestMapping(value={"/index","/",""})
    public ModelAndView backToMenu(HttpSession session){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject( "bookBasket",bookBasket);
        return mv;
    } 
       
}
