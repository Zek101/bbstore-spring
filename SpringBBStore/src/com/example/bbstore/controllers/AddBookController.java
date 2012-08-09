package com.example.bbstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;
import com.example.bbstore.dom.Book;

@Controller
public class AddBookController {
    @Autowired    BookDao bookDao;
    @Autowired    AuthorDao authorDao;
    
    
    @RequestMapping(value={"/createbook"})
    public ModelAndView createNewBookForm(){
        ModelAndView mv = new ModelAndView( "addbook");
        mv.addObject("listAuthor",authorDao.getAllAuthors());
        return mv;
    } 
    
    @RequestMapping(value={"/addbook"})
    public String addBook(@RequestParam("isbn") String isbn,
                                @RequestParam("title") String title,
                                @RequestParam("idAuthor") long authorid,
                                @RequestParam("price") String price){
        Book bk =new Book(isbn,title,authorDao.find(authorid),Integer.parseInt(price));
        bookDao.addBook(bk);
        return "index";
    } 
}
