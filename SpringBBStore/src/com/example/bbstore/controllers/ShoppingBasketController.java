package com.example.bbstore.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dao.BookDao;
import com.example.bbstore.dom.Book;
import com.example.bbstore.dom.ShoppingBasket;

@Controller
public class ShoppingBasketController {
    
    @Autowired    BookDao bDao;
    @Autowired    ShoppingBasket bookBasket;
    @Autowired    ListBookController lbc;
    
    @RequestMapping(value="/addbooktobasket")
    public ModelAndView addToBasket(@RequestParam("isbn")String bookIsbn){
        bookBasket.addBook(bDao.getBookByIsbn(bookIsbn));
        return lbc.viewBookList();
    } 
    
    @RequestMapping(value={"/viewshoppingcart"})
    public ModelAndView createShoppingBasketForm(){
        ModelAndView mv =new ModelAndView("shoppingbasket");
        mv.addObject( "bookBasket",bookBasket);
        return mv;
    } 
    @RequestMapping(value={"/removefrombasket"})
    public String removeFromBasket( @RequestParam("bookId")Long bookId){
        bookBasket.remove(bDao.find(bookId));
        return "shoppingbasket";
    } 
}
