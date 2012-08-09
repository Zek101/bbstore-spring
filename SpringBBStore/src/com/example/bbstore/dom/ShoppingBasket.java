package com.example.bbstore.dom;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component 
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)

public class ShoppingBasket implements Serializable {
    List<Book> bookList = new ArrayList<Book>();
    public void addBook(Book bk){
        bookList.add(bk);
    }
    public void remove(Book bk){
        bookList.remove(bk);
    }
    public List<Book> getList(){
        return bookList;
    }
    public double getTotal(){
        double tot= 0;
        for(Book bk:bookList){
            tot +=bk.getPrice();
        }
        return tot;
    }
}
