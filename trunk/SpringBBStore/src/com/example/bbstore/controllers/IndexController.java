package com.example.bbstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.ShoppingBasket;



@Controller
public class IndexController{
    @Autowired    ShoppingBasket shoppingBasket;
  
 
    @RequestMapping(value={"/index","/",""})
    public ModelAndView showIndex(){
        return new ModelAndView("index","shoppingBasket",shoppingBasket);
    } 
       
}
