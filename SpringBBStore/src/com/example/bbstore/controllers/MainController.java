package com.example.bbstore.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dom.Book;
import com.example.bbstore.dom.ShoppingBasket;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;



@Controller
public class MainController{

    @Autowired    BookDao bDao;
    @Autowired    AuthorDao aDao;

   
 
    @RequestMapping(value={"/index","/",""})
    public String backToMenu(HttpSession session){
        ShoppingBasket bookBasket = (ShoppingBasket)session.getAttribute("bookBasket");
        if (bookBasket == null){
            bookBasket = new ShoppingBasket();
            session.setAttribute("bookBasket", bookBasket);
        }
        return "index";
    } 
   

    @RequestMapping(value="/admincreate")
    public String adminCreate(){
//        Author a1 = new Author();
//        a1.setName("Stevenson");
//        a1.setForname("Robert Louis");
//        bDao.persist(a1);
//        Author a2 = new Author();
//        a2.setName("Doyle");
//        a2.setForname("Arthur Conan");
//        bDao.persist(a2);
//        Book bk1 = new Book("1111","Martine à amsterdam",a1,12);
//        bDao.AddBook(bk1);
//        Book bk2 = new Book("1122","Martine en désintox",a1,8);
//        bDao.AddBook(bk2);
//        Book bk3 = new Book("1133","Sherlock contre shakira",a2,13);
//        bDao.AddBook(bk3);
//        
        return "booklist";
    } 

    
}