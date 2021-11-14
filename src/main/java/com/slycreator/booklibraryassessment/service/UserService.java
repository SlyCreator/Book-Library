package com.slycreator.booklibraryassessment.service;


import com.slycreator.booklibraryassessment.dtos.UserGetDto;
import com.slycreator.booklibraryassessment.dtos.UserRegisterDto;


public interface UserService {
    UserRegisterDto createUser(UserRegisterDto userRegisterDto);
    UserGetDto getFavoriteBooks(Long UserId);

}
