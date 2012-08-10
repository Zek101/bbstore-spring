package com.example.bbstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.Book;
import com.example.bbstore.dom.ShoppingBasket;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;


@Controller
public class ListBookController {
    @Autowired    BookDao bookDao;
    @Autowired    AuthorDao authorDao;
    @Autowired    ShoppingBasket shoppingBasket;
    
    @RequestMapping(value="/viewlist")
    public ModelAndView viewList(@RequestParam(value ="edit")boolean edit){
        List<Book> lb = bookDao.findAllBooks();
        ModelAndView mv =new ModelAndView("listbook");
        mv.addObject( "listBook",lb);
        mv.addObject( "bookBasket",shoppingBasket);
        mv.addObject("edit",edit);
        return mv;
    } 

}
