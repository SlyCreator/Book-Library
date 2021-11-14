package com.slycreator.booklibraryassessment.service;

import com.slycreator.booklibraryassessment.dtos.CategoryDto;
import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.entity.Category;
import com.slycreator.booklibraryassessment.mapper.MapStructMapper;
import com.slycreator.booklibraryassessment.mapper.MapStructMapperImpl;
import com.slycreator.booklibraryassessment.repository.BookRepository;
import com.slycreator.booklibraryassessment.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private MapStructMapper mapStructMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = mapStructMapper.categoryDtoToCategory(categoryDto);
       return mapStructMapper.categoryToCategoryDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto editCategory(Long categoryId, CategoryDto categoryDto) {
        Category category = mapStructMapper.categoryDtoToCategory(getCategory(categoryId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        return mapStructMapper.categoryToCategoryDto(category);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        return mapStructMapper.categoryToCategoryDto(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Category with id " + categoryId + " does not exist")));
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return mapStructMapper.ListCategoryToListCategoryDto(categoryRepository.findAll());
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void addBookToCategory(Book book) {
    }

    @Override
    public void removeBookFromCategory(Book book) {

    }
}
