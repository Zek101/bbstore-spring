package com.example.bbstore.dom;
import java.util.ArrayList;
import java.util.List;


public class ShoppingBasket {
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
