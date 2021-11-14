package com.slycreator.booklibraryassessment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksCollectionDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;
}
