package com.back.millestone_services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.millestone_services.exception.MilestoneNotFoundException;
import com.back.millestone_services.model.dto.MilestoneDto;
import com.back.millestone_services.model.entity.Milestone;
import com.back.millestone_services.repository.MilestoneRepository;

@Service
public class MilestoneService {
    @Autowired
    MilestoneRepository milestoneRepository;

    public MilestoneDto create(MilestoneDto milestoneDto){
        Milestone milestone = this.mapToMilestone(milestoneDto);
        return this.mapToMilestoneDto(this.milestoneRepository.save(milestone));
    }
    
    public List<MilestoneDto> getAll() {
        List<Milestone> milestones = this.milestoneRepository.findAll();
        System.out.println("Buscando");
        List<MilestoneDto> milestoneResponses =milestones.stream().map(this::mapToMilestoneDto).toList();
        return milestoneResponses;
        
    }

    public MilestoneDto get(Integer id) {
        Optional<Milestone> milestone = this.milestoneRepository.findById(id);
        if (milestone.isPresent()) {
            return this.mapToMilestoneDto(milestone.get());
        } else {
            throw new MilestoneNotFoundException("no se pudo encontrar el milestone");
        }
    }

    public Milestone mapToMilestone(MilestoneDto milestoneDto){
        Milestone milestone = new Milestone();
        milestone.setName(milestoneDto.name());
        milestone.setOrderValue(milestoneDto.orderValue());
        milestone.setRoadmapId(milestoneDto.roadmapId());
        milestone.setContent(milestoneDto.content());
        return milestone;
    }

    public MilestoneDto mapToMilestoneDto(Milestone milestone){
        MilestoneDto milestoneResponse = new MilestoneDto(milestone.getId(),milestone.getName(),milestone.getOrderValue(),milestone.getContent(), milestone.getRoadmapId());
        return milestoneResponse;
    }

}
