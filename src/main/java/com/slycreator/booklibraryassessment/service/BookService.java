package com.slycreator.booklibraryassessment.service;

import com.slycreator.booklibraryassessment.dtos.BookDto;
import com.slycreator.booklibraryassessment.entity.Book;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto BookDto);
    BookDto editBook(Long bookId,BookDto BookDto);
    BookDto getBook(Long BookId);
    List<BookDto> getAllBook();
    void deleteBook(Long BookId);
}
