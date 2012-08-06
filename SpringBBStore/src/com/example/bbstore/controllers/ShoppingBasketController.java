package com.example.bbstore.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
    @Autowired     ShoppingBasket bookBasket;
    
    @RequestMapping(value="/addbooktobasket")
    public ModelAndView addToBasket(@RequestParam("isbn")String bookIsbn){
        bookBasket.addBook(bDao.getBookByIsbn(bookIsbn));
        List<Book> lb = bDao.getAllBooks();
        ModelAndView mv =new ModelAndView("booklist");
        mv.addObject( "listBook",lb);
        mv.addObject( "bookBasket",bookBasket);
        
        return mv;
    } 
    
    @RequestMapping(value={"/viewshoppingcart"})
    public ModelAndView createShoppingBasketForm(HttpSession session){
        ModelAndView mv =new ModelAndView("shoppingbasket");
        mv.addObject( "bookBasket",bookBasket);
        return mv;
    } 
    @RequestMapping(value={"/removefrombasket"})
    public String removeFromBasket(HttpSession session, @RequestParam("bookId")Long bookId){
        bookBasket.remove(bDao.find(bookId));
        return "shoppingbasket";
    } 
}
