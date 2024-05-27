package com.back.task_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.back.task_services.model.dto.TaskDto;
import com.back.task_services.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAll() {
        return new ResponseEntity<List<TaskDto>>(this.taskService.get(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getMethodName(@PathVariable Integer id) {
        return new ResponseEntity<TaskDto>(this.taskService.get(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TaskDto> post(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<TaskDto>(this.taskService.create(taskDto),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> modify(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        return new ResponseEntity<TaskDto>(this.taskService.modify(id,taskDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.taskService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    

}
