package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.ProjectDto;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ProjectMapper {

    @Mapping(target = "taskDtos", expression = "java(setTasks(entity.getTasks(), entity))")
    ProjectDto toDto(ProjectEntity entity);

    default List<TaskDto> setTasks(List<TaskEntity> res, ProjectEntity projectEntity) {

        List<TaskDto> resList = new ArrayList<>();
        for (TaskEntity entity : res) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(entity.getId());
            taskDto.setTitle(entity.getTitle());
            taskDto.setStatus(entity.getStatus());
            taskDto.setDescription(entity.getDescription());
            taskDto.setProjectId(projectEntity.getId());

            resList.add(taskDto);
        }

        return resList;
    }

    ProjectEntity toEntity(ProjectDto dto);
}
