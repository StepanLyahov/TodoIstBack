package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskDto toDto(TaskEntity entity);
    TaskEntity toEntity(TaskDto dto);
}
