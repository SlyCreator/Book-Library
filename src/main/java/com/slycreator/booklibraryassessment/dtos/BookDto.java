package com.slycreator.booklibraryassessment.dtos;

import com.slycreator.booklibraryassessment.entity.Book;
import com.slycreator.booklibraryassessment.entity.Category;
import com.slycreator.booklibraryassessment.mapper.MapStructMapper;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String isbn;
    @NotNull
    private Date release_date;


    private CategoryDto categoryDto;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.isbn = book.getIsbn();
        this.release_date = book.getReleaseDate();
        this.categoryDto =  new CategoryDto(book.getCategory());
    }

    public void setCategoryDtoFromCategory(Category category){
        this.categoryDto = new CategoryDto(category);
    }


}
