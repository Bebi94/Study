package com.mykyong.common.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mykyong.common.models.dao.BookDAO;
import com.mykyong.common.models.entity.Book;

@Controller
@RequestMapping("/api")
public class BookAPIController {
    @Autowired
    private BookDAO bookDAO;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks() {
        List<Book> books = bookDAO.showAllBook();
        return new ResponseEntity<Object>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findBook(@PathVariable int id) {
        Book book = bookDAO.findBookByID(id);
        return new ResponseEntity<Object>(book, HttpStatus.OK);
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateNewBook(@PathVariable int id, @RequestBody Book book) {
        bookDAO.updateBook(id, book.getTitle());
        return new ResponseEntity<String>("Updated!", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteOldBook(@PathVariable int id) {
        bookDAO.deleteBook(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/books", method = RequestMethod.POST)
    public ResponseEntity<String> createNewBook(@RequestBody Book book){
        bookDAO.createBook(book);
        return new ResponseEntity<String>("Created", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/books/page_size/{page_size}/page_num/{page_num}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksBySize(@PathVariable Integer page_size, @PathVariable Integer page_num) {
        
        return new ResponseEntity<Object>(bookDAO.showBooksBySize(page_size, page_num), HttpStatus.OK);
    }
}
