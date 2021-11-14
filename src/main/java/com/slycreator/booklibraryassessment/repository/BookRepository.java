package com.slycreator.booklibraryassessment.repository;

import com.slycreator.booklibraryassessment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {}
