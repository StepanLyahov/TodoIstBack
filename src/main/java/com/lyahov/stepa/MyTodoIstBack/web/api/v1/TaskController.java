package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
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
    public TaskDto getTask(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }

    @GetMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/createTask")
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
    }

    @PostMapping("/updateTask")
    public void updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto);
    }

    @GetMapping("/getAllTask")
    public List<TaskDto> getAllTask(@RequestParam List<StatusTask> statuses) {
        return taskService.getAllTask(statuses);
    }
}
