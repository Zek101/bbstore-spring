package com.example.bbstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.bbstore.dao.BookDao;
import com.example.bbstore.dom.ShoppingBasket;

@Controller
public class ShoppingBasketController {
    
    @Autowired    BookDao bookDao;
    @Autowired    ShoppingBasket shoppingBasket;
    @Autowired    ListBookController listBookController;
    
    @RequestMapping(value="/addbooktobasket")
    public ModelAndView addBookToBasket(@RequestParam("id")Long id){
        shoppingBasket.addBook(bookDao.find(id));
        return listBookController.viewList(false);
    } 
    
    @RequestMapping(value={"/viewshoppingcart"})
    public ModelAndView viewShoppingCart(){
        ModelAndView mv =new ModelAndView("shoppingbasket");
        mv.addObject( "bookBasket",shoppingBasket);
        return mv;
    } 
    @RequestMapping(value={"/removefrombasket"})
    public ModelAndView removeFromBasket( @RequestParam("bookId")Long bookId){
        shoppingBasket.remove(bookDao.find(bookId));
        return viewShoppingCart();
    } 
}
