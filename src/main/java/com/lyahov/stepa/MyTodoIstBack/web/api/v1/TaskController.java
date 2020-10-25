package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.TaskService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.TASK;

@RestController
@RequiredArgsConstructor
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/deleteTask/{id}")
    @PreAuthorize("hasAuthority('read, write')")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/createTask")
    @PreAuthorize("hasAuthority('read, write')")
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
    }

    @PostMapping("/updateTask")
    @PreAuthorize("hasAuthority('read, write')")
    public void updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto);
    }

    @GetMapping("/getAllTask")
    @PreAuthorize("hasAuthority('read, write')")
    public List<TaskDto> getAllTask(@RequestParam(required = false) Long projectId) {
        return taskService.getAllTask(projectId);
    }
}
