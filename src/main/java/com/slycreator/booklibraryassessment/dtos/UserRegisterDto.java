package com.slycreator.booklibraryassessment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class UserRegisterDto {
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("firstname")
    private String firstname;

    @NotNull
    @JsonProperty("lastname")
    private String lastname;

}
