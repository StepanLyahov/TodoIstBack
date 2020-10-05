package com.lyahov.stepa.MyTodoIstBack.business.service;

import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;

import java.util.List;

public interface TaskService {

    void deleteTask(Long id);

    TaskDto getTask(Long id);

    void createTask(TaskDto taskDto);

    void updateTask(TaskDto taskDto);

    List<TaskDto> getAllTask(List<StatusTask> statuses);
}
