package com.back.task_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.back.task_services.execeptions.TaskNotFoundExeception;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({TaskNotFoundExeception.class})
    public ResponseEntity<Object> handleTaskNotFound(TaskNotFoundExeception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
