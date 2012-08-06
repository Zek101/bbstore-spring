package com.example.bbstore.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.Book;
import com.example.bbstore.dom.ShoppingBasket;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;


@Controller
public class ListBookControler {
    @Autowired    BookDao bDao;
    @Autowired    AuthorDao aDao;
    @Autowired     ShoppingBasket bookBasket;
    
    @RequestMapping(value="/viewlist")
    public ModelAndView viewBookList(){
        
        if (bookBasket == null){
            bookBasket = new ShoppingBasket();
           // session.setAttribute("bookBasket", bookBasket);
        }
        List<Book> lb = bDao.getAllBooks();
        ModelAndView mv =new ModelAndView("booklist");
        mv.addObject( "listBook",lb);
        mv.addObject( "bookBasket",bookBasket);
        return mv;
    } 
    
    @RequestMapping(value="/vieweditlist")
    public  ModelAndView viewBookListToEdit(){
        ModelAndView mv = viewBookList();
        mv.addObject("edit","1");
        return mv;
    }
    @RequestMapping(value={"/editbook"})
    public ModelAndView editBook(@RequestParam("isbn") String isbn){
        ModelAndView mv = new ModelAndView("editbook");
        mv.addObject( "book",bDao.getBookByIsbn(isbn));
        mv.addObject( "listAuthor",aDao.getAllAuthors());
        return mv;
    }
    
}
