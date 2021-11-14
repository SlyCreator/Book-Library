package com.slycreator.booklibraryassessment.service;

import com.slycreator.booklibraryassessment.dtos.BookDto;
import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.mapper.MapStructMapper;
import com.slycreator.booklibraryassessment.repository.BookRepository;
import com.slycreator.booklibraryassessment.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private MapStructMapper mapStructMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = mapStructMapper.bookDtoToBook(bookDto);
        categoryRepository.findById(bookDto.getCategoryDto().getId())
                .map(category -> {
                    book.setCategory(category);
                    category.addBook(book);
                    return category;
                })
                .map(categoryRepository::save);
       return new BookDto(bookRepository.save(book));
    }

    @Override
    public BookDto editBook(Long bookId, BookDto bookDto) {
        Book book = mapStructMapper.bookDtoToBook(getBook(bookId));
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setIsbn(bookDto.getIsbn());
        book.setReleaseDate(bookDto.getRelease_date());
        return new BookDto(book);
    }

    @Override
    public BookDto getBook(Long bookId) {
        return new BookDto(bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Book with id " + bookId + " does not exist")));
    }

    @Override
    public List<BookDto> getAllBook() {

        List<Book> books = bookRepository.findAll();
        return mapStructMapper.ListBooksToListBookDto(books);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
    
}
