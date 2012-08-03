package com.example.bbstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bbstore.dao.AuthorDao;
import com.example.bbstore.dao.BookDao;
import com.example.bbstore.dom.Book;

@Controller
public class EditBookController {

    @Autowired    BookDao bDao;
    @Autowired    AuthorDao aDao;


    @RequestMapping(value={"/updatebook"})
    public ModelAndView updateBook(@ModelAttribute Book bk){
        bDao.updateBook(bk);
        List<Book> lb = bDao.getAllBooks();
        ModelAndView mv = new ModelAndView("booklist", "listBook",lb);
        mv.addObject("edit","1");
        return mv;
    }

    @ModelAttribute
    public Book findBook(@RequestParam("id")Long id ,@RequestParam("idAuthor") Long idAuthor){
        Book result = bDao.find(id);
        result.setAuthor(aDao.find(idAuthor));
        return  result;
    }
    
}
