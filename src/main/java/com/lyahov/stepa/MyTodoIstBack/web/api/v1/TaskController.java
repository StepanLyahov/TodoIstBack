package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyahov.stepa.MyTodoIstBack.web.Api.TASK;

@RestController
@RequiredArgsConstructor
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable("id") Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PostMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @GetMapping("/getAllTask")
    public List<Task> getAllTask(@RequestParam List<StatusTask> statuses) {
        return taskService.getAllTask(statuses);
    }
}
