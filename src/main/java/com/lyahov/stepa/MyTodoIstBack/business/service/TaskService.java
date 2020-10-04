package com.lyahov.stepa.MyTodoIstBack.business.service;

import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;

import java.util.List;

public interface TaskService {
    Task getTask(Integer id);

    Task createTask(Task task);

    Task updateTask(Task task);

    List<Task> getAllTask(List<StatusTask> statuses);
}
