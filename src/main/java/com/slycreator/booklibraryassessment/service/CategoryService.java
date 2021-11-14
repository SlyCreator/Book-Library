package com.slycreator.booklibraryassessment.service;

import com.slycreator.booklibraryassessment.dtos.CategoryDto;
import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto editCategory(Long categoryId, CategoryDto categoryDto);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Long categoryId);
    void addBookToCategory(Book book);
    void removeBookFromCategory(Book book);
}
