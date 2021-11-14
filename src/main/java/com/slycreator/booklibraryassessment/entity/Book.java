package com.slycreator.booklibraryassessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slycreator.booklibraryassessment.dtos.CategoryDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter @Setter
@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String isbn;
    @Basic @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "books"
//    )
//    private Set<User>users = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        return Objects.equals(isbn, ((Book) o).isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}
