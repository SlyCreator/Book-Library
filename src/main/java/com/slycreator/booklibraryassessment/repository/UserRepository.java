package com.slycreator.booklibraryassessment.repository;

import com.slycreator.booklibraryassessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {}
