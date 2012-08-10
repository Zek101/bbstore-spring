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

    @Autowired    BookDao bookDao;
    @Autowired    AuthorDao authorDao;
    @Autowired    ListBookController listBookController;

    @RequestMapping(value={"/editbook"})
    public ModelAndView editBook(@ModelAttribute Book bk){
        ModelAndView mv = new ModelAndView("editbook");
        mv.addObject( "book",bk);
        mv.addObject( "listAuthor",authorDao.getAllAuthors());
        return mv;
    }
    
    @RequestMapping(value={"/updatebook"})
    public ModelAndView updateBook(@ModelAttribute Book bk){
        bookDao.merge(bk);
        return listBookController.viewList(true);
    }

    @ModelAttribute
    public Book findBook(@RequestParam("id")Long id ,@RequestParam(value="author.id", required = false) Long idAuthor){
        Book result = bookDao.find(id);
        if(idAuthor !=null)
        {
        result.setAuthor(authorDao.find(idAuthor));
        }
        return  result;
    }
    
}
