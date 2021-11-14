package com.slycreator.booklibraryassessment.mapper;

import com.slycreator.booklibraryassessment.dtos.*;
import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.entity.Category;
import com.slycreator.booklibraryassessment.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MapStructMapper {

    @Mapping(target = "bookSlimDto", source = "books")
    CategoryDto categoryToCategoryDto(Category category);

    List<CategoryDto> ListCategoryToListCategoryDto(List<Category> categories);

    Category categoryDtoToCategory(CategoryDto categoryDto);


    UserRegisterDto userPostDtoToUser(UserRegisterDto userRegisterDto);
    UserGetDto userToUserGetDto(User user);

    @Mapping(target = "categoryDto", source = "category")
    BookDto bookToBookDto(Book book);

    BookSlimDto bookToBookSlimBto(Book book);

    Book bookDtoToBook(BookDto bookDto);
    List<BookDto> ListBooksToListBookDto(List<Book> books);


}
