package com.lyahov.stepa.MyTodoIstBack.business.service;

import com.lyahov.stepa.MyTodoIstBack.web.dto.Project;

import java.util.List;

public interface ProjectService {

    void createProject(Project project);

    void deleteProject(Long id);

    void updateProject(Project project);

    List<Project> getAllProject();

    void addTaskToProject(Long projectId, Long taskId);

    void delTaskToProject(Long projectId, Long taskId);
}
