package com.lyahov.stepa.MyTodoIstBack.business.service;

import com.lyahov.stepa.MyTodoIstBack.web.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    void createProject(ProjectDto projectDto);

    void deleteProject(Long id);

    void updateProject(ProjectDto projectDto);

    List<ProjectDto> getAllProject();

}
