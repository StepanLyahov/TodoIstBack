package com.lyahov.stepa.MyTodoIstBack.business.service.impl;

import com.lyahov.stepa.MyTodoIstBack.business.dao.ProjectRepository;
import com.lyahov.stepa.MyTodoIstBack.business.dao.TaskRepository;
import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import com.lyahov.stepa.MyTodoIstBack.business.service.ProjectService;
import com.lyahov.stepa.MyTodoIstBack.utils.mappers.ProjectMapper;
import com.lyahov.stepa.MyTodoIstBack.web.dto.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService  {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void createProject(ProjectDto projectDto) {
        if (projectDto == null) {
            log.info("project is void");
            return;
        }
        log.info("create new project : " + projectDto.getTitle());
        projectRepository.save(projectMapper.toEntity(projectDto));
    }

    @Override
    public void deleteProject(Long id) {
        log.info("del project by id : " + id);
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        if (projectDto == null || projectDto.getId() == null) {
            log.info("project is void");
            return;
        }
        log.info("update project: " + projectDto.getId());
        projectRepository.save(projectMapper.toEntity(projectDto));
    }

    @Override
    public List<ProjectDto> getAllProject() {
        log.info("get all project");
        return projectRepository.findAll()
                .stream().map(projectMapper::toDto)
                .collect(Collectors.toList());
    }
}
