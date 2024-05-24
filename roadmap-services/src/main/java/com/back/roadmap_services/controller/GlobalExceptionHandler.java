package com.back.roadmap_services.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.back.roadmap_services.exception.RoadmapNotFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({RoadmapNotFoundException.class})
    public ResponseEntity<Object> handleRoadmapNotFound(RoadmapNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
    }

}
