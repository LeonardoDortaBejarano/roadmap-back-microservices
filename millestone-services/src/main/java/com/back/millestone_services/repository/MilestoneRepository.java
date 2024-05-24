package com.back.millestone_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.millestone_services.model.entity.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone,Integer> {

}
