package com.slycreator.booklibraryassessment.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter @Setter
public class BookSlimDto {

    private Long id;
    private String title;
    private String description;
    private String isbn;
    @Basic
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
}
