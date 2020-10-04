package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.dao.TaskRepository;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.utils.mappers.TaskMapper;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;


    @Override
    public void deleteTask(Long id) {
        log.info("delete task by " + id);
        if (null == id) {
            log.info("task by" + id + " is not found");
            taskRepository.deleteById(id);
        }
    }

    @Override
    public Task getTask(Long id) {
        log.info("get task by " + id);
        TaskEntity entity = taskRepository.getOne(id);
        if (null == entity) {
            log.info("task by" + id + " is not found");
            return null;
        }
        return mapper.toDto(entity);
    }

    @Override
    public void createTask(Task task) {
        log.info("create task");
        if (task != null) {
            task.setStatus(StatusTask.IN_PROGRESS);
            TaskEntity entity = mapper.toEntity(task);
            taskRepository.save(entity);
        }
    }

    @Override
    @SneakyThrows
    public void updateTask(Task task) {
        log.info("update task");

        if (task == null || task.getId() == null) {
            log.info("task is void");
            throw new Exception("Такой задачи не существует");
        }

        taskRepository.save(mapper.toEntity(task));
    }

    @Override
    public List<Task> getAllTask(List<StatusTask> statuses) {
        log.info("get all task");
        return taskRepository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
