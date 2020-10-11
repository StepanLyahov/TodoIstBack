package com.lyahov.stepa.MyTodoIstBack.web.dto.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Priority {
    PRIORITY_1("1"),
    PRIORITY_2("2"),
    PRIORITY_3("3"),
    PRIORITY_4("4");

    final String name;
}
