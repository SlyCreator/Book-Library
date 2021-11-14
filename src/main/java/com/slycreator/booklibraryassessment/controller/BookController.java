package com.slycreator.booklibraryassessment.controller;

import com.slycreator.booklibraryassessment.dtos.BookDto;
import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto BookDto){
        return ResponseEntity.ok(bookService.createBook(BookDto));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllCategories() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto BookDto, @PathVariable Long id){
        return ResponseEntity.ok(bookService.editBook(id, BookDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @DeleteMapping("/{id}")
    public String  deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "success";
    }
}
