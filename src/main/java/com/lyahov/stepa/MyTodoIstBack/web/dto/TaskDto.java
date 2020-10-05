package com.lyahov.stepa.MyTodoIstBack.web.dto;

import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    Long id;
    String title;
    String description;

    @Enumerated(EnumType.STRING)
    StatusTask status;
}
