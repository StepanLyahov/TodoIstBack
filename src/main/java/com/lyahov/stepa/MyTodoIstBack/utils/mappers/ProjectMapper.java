package com.lyahov.stepa.MyTodoIstBack.utils.mappers;

import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {
    Project toDto(ProjectEntity entity);
    ProjectEntity toEntity(Project dto);
}
