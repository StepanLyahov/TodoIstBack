package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task getTask(Integer id) {
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public List<Task> getAllTask(List<StatusTask> statuses) {
        return null;
    }
}
