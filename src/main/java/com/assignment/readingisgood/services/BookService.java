package com.assignment.readingisgood.services;

import com.assignment.readingisgood.exceptions.BookAlreadyPresent;
import com.assignment.readingisgood.exceptions.BookNotFound;
import com.assignment.readingisgood.exceptions.InvalidQuantity;
import com.assignment.readingisgood.exceptions.OutOfStockException;
import com.assignment.readingisgood.models.Book;
import com.assignment.readingisgood.models.BookQuantity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookService {
    private Map<String, Book> booksMap;
    private Map<String, Integer> bookQuantityMap;

    public BookService() {
        this.booksMap = new HashMap<>();
        this.bookQuantityMap = new HashMap<>();
    }

    public String addBook(Book book,Integer quantity) throws BookAlreadyPresent, InvalidQuantity {
        String id = book.getId();
        if(booksMap.containsKey(id)){
            throw new BookAlreadyPresent("Book Id:"+ id + "already Present.");
        }else{
            if(quantity < 0){
                throw new InvalidQuantity("Quantity should be positive.");
            }else {
                booksMap.put(id,book);
                bookQuantityMap.put(id,quantity);
                return id;
            }
        }
    }
    public Integer getQuantity(String bookId) throws BookNotFound {
        if(bookQuantityMap.containsKey(bookId)){
            return bookQuantityMap.get(bookId);
        }else{
            throw new BookNotFound("Book not found with id:"+bookId);
        }
    }
    public List<BookQuantity> getAllStock(){
        List<BookQuantity> bookQuantityList = new ArrayList<>();
        for(Map.Entry<String,Integer> b:bookQuantityMap.entrySet()){
            bookQuantityList.add(new BookQuantity(b.getKey(),b.getValue()));
        }
        return bookQuantityList;
    }
    public void reduceQuantity(String bookId,Integer quantity) throws OutOfStockException {
        int actualQuantity = bookQuantityMap.get(bookId);
//        if(actualQuantity - quantity < 0 )
//            throw new OutOfStockException("Out of stock" + bookId);
        bookQuantityMap.put(bookId,bookQuantityMap.get(bookId)-quantity);
    }
    public Book getBook(String bookId) throws BookNotFound {
        if(booksMap.containsKey(bookId)){
           return booksMap.get(bookId);
        }else{
            throw new BookNotFound("Book not found with id:"+bookId);
        }
    }
    public BookQuantity updateQuantity(String bookId, Integer quantity) throws BookNotFound, InvalidQuantity {
        if(quantity < 0){
            throw new InvalidQuantity("Quantity should be positive.");
        }
        else if(booksMap.containsKey(bookId)){
            int newQuantity = bookQuantityMap.get(bookId)+quantity;
            bookQuantityMap.put(bookId,quantity);
            return new BookQuantity(bookId,newQuantity);
        }else{
            throw new BookNotFound("Book not found with id:"+bookId);
        }
    }
}
