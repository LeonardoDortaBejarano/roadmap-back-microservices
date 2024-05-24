package com.back.millestone_services.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer orderValue;
    private String content;
    private Integer roadmapId;

    


    public Milestone() {
    }

    

    public Milestone(Integer id, String name, Integer orderValue, String content, Integer roadmapId) {
        this.id = id;
        this.name = name;
        this.orderValue = orderValue;
        this.content = content;
        this.roadmapId = roadmapId;
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getOrderValue() {
        return orderValue;
    }
    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getRoadmapId() {
        return roadmapId;
    }
    public void setRoadmapId(Integer roadmapId) {
        this.roadmapId = roadmapId;
    }

    
}
