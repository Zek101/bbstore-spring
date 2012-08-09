package com.example.bbstore.controllers;

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
    @Autowired    ListBookController lbc;

    @RequestMapping(value={"/editbook"})
    public ModelAndView editBook(@ModelAttribute Book bk){
        ModelAndView mv = new ModelAndView("editbook");
        mv.addObject( "book",bk);
        mv.addObject( "listAuthor",aDao.getAllAuthors());
        return mv;
    }
    
    @RequestMapping(value={"/updatebook"})
    public ModelAndView updateBook(@ModelAttribute Book bk,@RequestParam("idAuthor") Long idAuthor){
        bk.setAuthor(aDao.find(idAuthor));
        bDao.updateBook(bk);
        return lbc.viewBookListToEdit();
    }

    @ModelAttribute
    public Book findBook(@RequestParam("id")Long id ){
        Book result = bDao.find(id);
        return  result;
    }
    
}
