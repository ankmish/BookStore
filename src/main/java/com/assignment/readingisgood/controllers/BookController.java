package com.assignment.readingisgood.controllers;

import com.assignment.readingisgood.exceptions.BookAlreadyPresent;
import com.assignment.readingisgood.exceptions.BookNotFound;
import com.assignment.readingisgood.exceptions.InvalidQuantity;
import com.assignment.readingisgood.models.Book;
import com.assignment.readingisgood.models.BookQuantity;
import com.assignment.readingisgood.models.BookResponse;
import com.assignment.readingisgood.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/update/{bookId}/quantity/{quantity}",method = RequestMethod.GET)
    @ResponseBody
    public BookResponse updateQuantity(@PathVariable String bookId, @PathVariable Integer quantity) {
        try{
            BookQuantity bookQuantity = bookService.updateQuantity(bookId,quantity);
            return new BookResponse("Success",bookQuantity);
        } catch (BookNotFound | InvalidQuantity exception) {
            return new BookResponse("Fail",exception.getMessage());
        }
    }

    @RequestMapping(value = "/books/add/{quantity}",method = RequestMethod.POST)
    @ResponseBody
    public BookResponse addBook(@PathVariable int quantity,@RequestBody Book book) {
        try{
            String id = bookService.addBook(book,quantity);
            return new BookResponse("Success",id);
        } catch (InvalidQuantity | BookAlreadyPresent exception) {
            return new BookResponse("Fail",exception.getMessage());
        }
    }

    @RequestMapping(value = "/books/stock",method = RequestMethod.GET)
    @ResponseBody
    public BookResponse getAllStock() {
        return new BookResponse("Success",bookService.getAllStock());
    }
}
