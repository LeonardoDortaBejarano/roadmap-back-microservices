package com.back.user_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back.user_services.model.dto.UserRequest;
import com.back.user_services.model.dto.UserResponse;
import com.back.user_services.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> createRoadmap(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(this.userService.create(userRequest)); 
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getRoadmaps() {
        return ResponseEntity.ok(this.userService.getAll()); 
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> roadmapExists(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.roadmapExists(id)); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getRoadmap(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.get(id)); 
    }

}
