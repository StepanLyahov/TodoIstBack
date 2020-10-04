package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Task;
import com.lyahov.stepa.MyTodoIstBack.web.dto.enums.StatusTask;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.TASK;

@RestController
@RequiredArgsConstructor
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }

    @GetMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/createTask")
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @PostMapping("/updateTask")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @GetMapping("/getAllTask")
    public List<Task> getAllTask(@RequestParam List<StatusTask> statuses) {
        return taskService.getAllTask(statuses);
    }
}
