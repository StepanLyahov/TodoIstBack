package com.lyahov.stepa.MyTodoIstBack.business.dao;

import com.lyahov.stepa.MyTodoIstBack.business.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
