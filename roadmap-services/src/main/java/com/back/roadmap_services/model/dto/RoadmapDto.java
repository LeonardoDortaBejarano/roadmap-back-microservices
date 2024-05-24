package com.back.roadmap_services.model.dto;

public record RoadmapDto(
    Integer id,
    String name,
    String description,
    String color,
    Integer orderValue,
    Integer userId
) {
    

    
    public RoadmapDto(String name, String description, String color, Integer orderValue, Integer userId) {
        this(null, name, description, color, orderValue, userId);
    }
}