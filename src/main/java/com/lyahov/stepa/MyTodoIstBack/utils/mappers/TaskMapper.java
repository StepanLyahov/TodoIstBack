package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    Task toDto(TaskEntity entity);
    TaskEntity toEntity(Task dto);
}
