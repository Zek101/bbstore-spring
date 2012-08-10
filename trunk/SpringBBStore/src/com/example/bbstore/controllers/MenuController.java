package com.example.bbstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.ShoppingBasket;



@Controller
public class MenuController{
    @Autowired    ShoppingBasket shoppingBasket;
  
 
    @RequestMapping(value={"/menu","/index"})
    public ModelAndView showMenu(){
        return new ModelAndView("menu","shoppingBasket",shoppingBasket);
    } 
    public ModelAndView redirectMenu(){
        return new ModelAndView("menu","shoppingBasket",shoppingBasket);
    } 
       
}
