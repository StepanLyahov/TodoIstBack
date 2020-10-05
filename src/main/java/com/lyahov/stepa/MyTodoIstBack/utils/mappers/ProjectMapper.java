package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {
    ProjectDto toDto(ProjectEntity entity);
    ProjectEntity toEntity(ProjectDto dto);
}
