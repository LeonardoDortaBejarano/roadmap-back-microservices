package com.back.roadmap_services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.roadmap_services.exception.RoadmapNotFoundException;
import com.back.roadmap_services.model.dto.RoadmapDto;
import com.back.roadmap_services.model.entity.Roadmap;
import com.back.roadmap_services.model.repository.RoadmapRepository;

@Service
public class RoadmapServices {
    @Autowired
    private RoadmapRepository roadmapRepository;

    public RoadmapDto create(RoadmapDto requestRoadmap){
        Roadmap roadmap = this.mapToRoadmap(requestRoadmap);
        return this.mapToRoadmapDto(this.roadmapRepository.save(roadmap));
    }
    
    public List<RoadmapDto> getAll() {
        List<Roadmap> roadmaps = this.roadmapRepository.findAll();
        System.out.println("Buscando");
        List<RoadmapDto> roadmapsDTO =roadmaps.stream().map(this::mapToRoadmapDto).toList();
        return roadmapsDTO;
        
    }

    public RoadmapDto get(Integer id) {
        Optional<Roadmap> roadmap = this.roadmapRepository.findById(id);
        if (roadmap.isPresent()) {
            return this.mapToRoadmapDto(roadmap.get());
        } else {
            throw new RoadmapNotFoundException("no se pudo encontrar el roadma");
        }
    }

    public Roadmap mapToRoadmap(RoadmapDto roadmapDto){
        Roadmap roadmap = new Roadmap();
        roadmap.setName(roadmapDto.name());
        roadmap.setColor(roadmapDto.color());
        roadmap.setDescription(roadmapDto.description());
        if (roadmapDto.id() != null) {
            roadmap.setId(roadmapDto.id());
        }
        roadmap.setOrderValue(roadmapDto.orderValue());
        roadmap.setUserId(roadmapDto.userId());
        return roadmap;
    }

    public RoadmapDto mapToRoadmapDto(Roadmap roadmap){
        RoadmapDto roadmapDto = new RoadmapDto(roadmap.getId(),roadmap.getName(),roadmap.getDescription(), roadmap.getColor(),roadmap.getOrderValue(),roadmap.getUserId()); 
        return roadmapDto;
    }

}

