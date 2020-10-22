package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.dao.ProjectRepository;
import com.lyahov.stepa.MyTodoIstBack.business.dao.TaskRepository;
import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.utils.mappers.TaskMapper;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private final ProjectRepository projectRepository;

    @Override
    public void deleteTask(Long id) {
        log.info("delete task by " + id);
        if (null == id) {
            log.info("task by" + id + " is not found");
            return;
        }
        taskRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public void createTask(TaskDto taskDto) {
        log.info("create task");
        if (taskDto == null) {
            log.info("task is void");
            return;
        }
        ProjectEntity projectEntity = projectRepository.findById(taskDto.getProjectId()).orElse(null);

        if (projectEntity == null) {
            log.info("project not found. id: " + taskDto.getProjectId());
            throw new Exception("Проект не найден");
        }

        taskDto.setStatus(StatusTask.IN_PROGRESS);
        TaskEntity entity = mapper.toEntity(taskDto);
        entity.setProjectId(projectEntity);
        taskRepository.save(entity);
    }

    @Override
    @SneakyThrows
    public void updateTask(TaskDto taskDto) {
        log.info("update task");

        if (taskDto == null || taskDto.getId() == null) {
            log.info("task is void");
            throw new Exception("Такой задачи не существует");
        }

        ProjectEntity projectEntity = projectRepository.findById(taskDto.getProjectId()).orElse(null);

        if (projectEntity == null) {
            log.info("project not found. id: " + taskDto.getProjectId());
            throw new Exception("Проект не найден");
        }
        TaskEntity taskEntity = mapper.toEntity(taskDto);
        taskEntity.setProjectId(projectEntity);
        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskDto> getAllTask(Long projectId) {
        log.info("get all task");
        return taskRepository.findAll()
                .stream().map(mapper::toDto).filter(t -> {
                    if (projectId != null)
                        return t.getProjectId().equals(projectId);
                    return true;
                })
                .collect(Collectors.toList());
    }
}
