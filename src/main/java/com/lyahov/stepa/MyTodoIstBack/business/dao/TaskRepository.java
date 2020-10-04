package com.lyahov.stepa.MyTodoIstBack.business.dao;

import com.lyahov.stepa.MyTodoIstBack.business.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
