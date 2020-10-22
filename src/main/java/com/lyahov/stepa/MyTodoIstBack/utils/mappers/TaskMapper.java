package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {

    @Mapping(target = "projectId", expression = "java(setProject(entity.getProjectId()))")
    TaskDto toDto(TaskEntity entity);

    default Long setProject(ProjectEntity projectEntity) {
        return projectEntity.getId();
    }

    @Mapping(target = "projectId", ignore = true)
    TaskEntity toEntity(TaskDto dto);
}
