package com.back.task_services.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.task_services.model.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
