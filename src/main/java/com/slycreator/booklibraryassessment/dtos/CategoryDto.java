package com.slycreator.booklibraryassessment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slycreator.booklibraryassessment.entity.Category;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private Set<BookSlimDto> bookSlimDto;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
    }

}
