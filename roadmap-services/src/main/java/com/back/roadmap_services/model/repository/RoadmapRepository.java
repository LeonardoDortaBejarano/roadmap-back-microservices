package com.back.roadmap_services.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.roadmap_services.model.entity.Roadmap;

@Repository
public interface RoadmapRepository extends JpaRepository<Roadmap, Integer>{

    
} 
