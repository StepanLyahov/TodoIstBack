package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.dao.ProjectRepository;
import com.lyahov.stepa.MyTodoIstBack.business.dao.TaskRepository;
import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.business.service.ProjectService;
import com.lyahov.stepa.MyTodoIstBack.utils.mappers.ProjectMapper;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Project;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService  {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void createProject(Project project) {
        if (project == null) {
            log.info("project is void");
            return;
        }
        log.info("create new project : " + project.getTitle());
        projectRepository.save(projectMapper.toEntity(project));
    }

    @Override
    public void deleteProject(Long id) {
        log.info("del project by id : " + id);
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(Project project) {
        if (project == null || project.getId() == null) {
            log.info("project is void");
            return;
        }
        log.info("update project: " + project.getId());
        projectRepository.save(projectMapper.toEntity(project));
    }

    @Override
    public List<Project> getAllProject() {
        log.info("get all project");
        return projectRepository.findAll()
                .stream().map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private void checkProjectEntityIsEmpty(ProjectEntity projectEntity) {
        if (projectEntity == null) {
            log.info("There is no such project");
            throw new Exception("Такого проекта не существует");
        }
    }

    @SneakyThrows
    private void checkTaskEntityIsEmpty(TaskEntity taskEntity) {
        if (taskEntity == null) {
            log.info("There is no such task");
            throw new Exception("Такой задачи не существует");
        }
    }

    @Override
    @SneakyThrows
    public void addTaskToProject(Long projectId, Long taskId) {
        log.info("add task: " + taskId + "to project: " + projectId);

        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        checkProjectEntityIsEmpty(projectEntity);

        TaskEntity taskEntity = taskRepository.getOne(taskId);
        checkTaskEntityIsEmpty(taskEntity);

        List<TaskEntity> res = projectEntity.getTasks();
        if (res == null || res.isEmpty())
            res = new ArrayList<>();
        res.add(taskEntity);

        projectEntity.setTasks(res);

        projectRepository.save(projectEntity);
    }

    @Override
    @SneakyThrows
    public void delTaskToProject(Long projectId, Long taskId) {
        log.info("add task: " + taskId + "to project: " + projectId);

        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        checkProjectEntityIsEmpty(projectEntity);

        TaskEntity taskEntity = taskRepository.getOne(taskId);
        checkTaskEntityIsEmpty(taskEntity);

        List<TaskEntity> list = projectEntity.getTasks();
        list = list.stream().filter(task -> !task.equals(taskEntity)).collect(Collectors.toList());
        projectEntity.setTasks(list);

        projectRepository.save(projectEntity);
    }
}
