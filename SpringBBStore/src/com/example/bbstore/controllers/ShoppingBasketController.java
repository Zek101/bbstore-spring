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
    
    @RequestMapping(value="/addbooktobasket")
    public ModelAndView addToBasket(@RequestParam("isbn")String bookIsbn,HttpSession session){
        ShoppingBasket bookBasket = (ShoppingBasket)session.getAttribute("bookBasket");
        if (bookBasket == null){
            bookBasket = new ShoppingBasket();
            session.setAttribute("bookBasket", bookBasket);
        }
        bookBasket.addBook(bDao.getBookByIsbn(bookIsbn));
        
        List<Book> lb = bDao.getAllBooks();
        ModelAndView mv =new ModelAndView("booklist");
        mv.addObject( "listBook",lb);
        mv.addObject( "bookBasket",bookBasket);
        
        return mv;
    } 
    
    @RequestMapping(value={"/viewshoppingcart"})
    public String createShoppingBasketForm(HttpSession session){
        ShoppingBasket bookBasket = (ShoppingBasket)session.getAttribute("bookBasket");
        ModelAndView mv =new ModelAndView("shoppingbasket");
        mv.addObject( "shopBasket",bookBasket);
        return "shoppingbasket";
    } 
    @RequestMapping(value={"/removefrombasket"})
    public String removeFromBasket(HttpSession session, @RequestParam("bookId")Long bookId){
        ShoppingBasket bookBasket = (ShoppingBasket)session.getAttribute("bookBasket");
        bookBasket.remove(bDao.find(bookId));
        return "shoppingbasket";
    } 
}
