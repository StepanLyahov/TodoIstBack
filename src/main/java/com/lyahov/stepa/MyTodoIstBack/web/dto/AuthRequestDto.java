package com.lyahov.stepa.MyTodoIstBack.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequestDto {
    String email;
    String password;
}
