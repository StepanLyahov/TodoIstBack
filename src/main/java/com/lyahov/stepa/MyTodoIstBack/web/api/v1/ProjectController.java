package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.ProjectService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.PROJECT;

@RestController
@RequiredArgsConstructor
@RequestMapping(PROJECT)
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/createProject")
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @GetMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/updateProject")
    public void updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
    }

    @GetMapping("/getAllProject")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @PostMapping("/{projectId}/addTask/{taskId}")
    public void addTaskToProject(@PathVariable("projectId") Long projectId,
                                 @PathVariable("taskId") Long taskId) {
        projectService.addTaskToProject(projectId, taskId);
    }

    @PostMapping("/{projectId}/delTask/{taskId}")
    public void delTaskToProject(@PathVariable("projectId") Long projectId,
                                 @PathVariable("taskId") Long taskId) {
        projectService.delTaskToProject(projectId, taskId);
    }

}
