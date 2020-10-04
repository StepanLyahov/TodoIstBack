package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.service.ProjectService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService  {
    @Override
    public void createProject(Project project) {
        log.info("create new project : " + project.getTitle());
    }

    @Override
    public void deleteProject(Long id) {
        log.info("del project by id : " + id);
    }

    @Override
    public void updateProject(Project project) {
        log.info("update project: " + project.getId());
    }

    @Override
    public List<Project> getAllProject() {
        log.info("get all project");
        return null;
    }

    @Override
    public void addTaskToProject(Long projectId, Long taskId) {
        log.info("add task: " + taskId + "to project: " + projectId);
    }

    @Override
    public void delTaskToProject(Long projectId, Long taskId) {
        log.info("add task: " + taskId + "to project: " + projectId);
    }
}
