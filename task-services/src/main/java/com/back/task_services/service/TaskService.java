package com.back.task_services.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.task_services.execeptions.TaskNotFoundExeception;
import com.back.task_services.model.dto.TaskDto;
import com.back.task_services.model.entity.Task;
import com.back.task_services.model.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<TaskDto> get(){
        List<Task> tasks =  this.taskRepository.findAll();
        return tasks.stream().map(this::toDto).collect(Collectors.toList());
    }

    public TaskDto get(Integer id){
        Optional<Task> task =  this.taskRepository.findById(id);
        if (task.isPresent()) {
            return this.toDto(task.get());    
        } else {
            throw new TaskNotFoundExeception("No se ha podido encontrar la task");
        }
        
    }

    public TaskDto create(TaskDto taskDto){
        Task task = this.toEntity(taskDto);
        Task saveTask = this.taskRepository.save(task);
        return this.toDto(saveTask);
    }

    public void delete(Integer id){
        this.taskRepository.deleteById(id);;
    }

    public TaskDto modify(Integer id, TaskDto taskDto){
        Optional<Task> task =  this.taskRepository.findById(id);
        if (task.isPresent()){
            task.get().setName(taskDto.name());
            task.get().setComplete(taskDto.isComplete());
            task.get().setMilestoneId(taskDto.milestoneId());
            task.get().setOrderValue(taskDto.orderValue());
        } else {
            throw new TaskNotFoundExeception("No se ha podido encontrar la task");
        }
        Task saveTask = this.taskRepository.save(task.get());
        return this.toDto(saveTask);
    }

    public Task toEntity (TaskDto taskDto) {
        Task task = new Task();

        if (taskDto.id() != null ){
            task.setId(taskDto.id());
        }

        task.setComplete(taskDto.isComplete());
        task.setMilestoneId(taskDto.milestoneId());
        task.setName(taskDto.name());
        task.setOrderValue(taskDto.orderValue());
        return task;
    }

    public TaskDto toDto (Task task) {
        if (task.getId() != null) {
            return new TaskDto(task.getId(),task.getName(), task.getOrderValue(), task.isComplete(), task.getMilestoneId());
        }
        return new TaskDto(task.getName(), task.getOrderValue(), task.isComplete(), task.getMilestoneId());
    }

}
