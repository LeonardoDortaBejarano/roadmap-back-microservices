package com.back.millestone_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back.millestone_services.model.dto.MilestoneDto;
import com.back.millestone_services.service.MilestoneService;

@Controller
@RequestMapping(value = "milestone")
public class MilestoneController {
    @Autowired
    private MilestoneService milestoneService;

    @PostMapping()
    public ResponseEntity<MilestoneDto> createRoadmap(@RequestBody MilestoneDto milestoneDto) {
        return ResponseEntity.ok(this.milestoneService.create(milestoneDto)); 
    }

    @GetMapping()
    public ResponseEntity<List<MilestoneDto>> getRoadmaps() {
        return ResponseEntity.ok(this.milestoneService.getAll()); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilestoneDto> getRoadmap(@PathVariable Integer id) {
        return ResponseEntity.ok(this.milestoneService.get(id)); 
    }
}
