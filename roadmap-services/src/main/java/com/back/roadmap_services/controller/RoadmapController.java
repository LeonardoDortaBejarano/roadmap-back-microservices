package com.back.roadmap_services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back.roadmap_services.model.dto.RoadmapDto;
import com.back.roadmap_services.service.RoadmapServices;

@Controller
@RequestMapping(value = "/roadmap")
public class RoadmapController {
    @Autowired
    private RoadmapServices roadmapServices;

    @PostMapping()
    public ResponseEntity<RoadmapDto> createRoadmap(@RequestBody RoadmapDto roadmap) {
        return ResponseEntity.ok(this.roadmapServices.create(roadmap)); 
    }

    @GetMapping()
    public ResponseEntity<List<RoadmapDto>> getRoadmaps() {
        return ResponseEntity.ok(this.roadmapServices.getAll()); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapDto> getRoadmap(@PathVariable Integer id) {
        return ResponseEntity.ok(this.roadmapServices.get(id)); 
    }

}
