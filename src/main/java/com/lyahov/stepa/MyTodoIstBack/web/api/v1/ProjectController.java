package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.business.service.ProjectService;
import com.lyahov.stepa.MyTodoIstBack.web.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.PROJECT;

@RestController
@RequiredArgsConstructor
@RequestMapping(PROJECT)
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/createProject")
    @PreAuthorize("hasAuthority('read, write')")
    public void createProject(@RequestBody ProjectDto projectDto) {
        projectService.createProject(projectDto);
    }

    @GetMapping("/deleteProject/{id}")
    @PreAuthorize("hasAuthority('read, write')")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/updateProject")
    @PreAuthorize("hasAuthority('read, write')")
    public void updateProject(@RequestBody ProjectDto projectDto) {
        projectService.updateProject(projectDto);
    }

    @GetMapping("/getAllProject")
    @PreAuthorize("hasAuthority('read, write')")
    public List<ProjectDto> getAllProject() {
        return projectService.getAllProject();
    }
}
