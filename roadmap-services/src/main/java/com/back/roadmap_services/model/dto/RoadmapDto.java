package com.back.roadmap_services.model.dto;

public record RoadmapDto(
    Integer id,
    String name,
    String description,
    String color,
    Integer orderValue,
    Integer userId
) {
    // Primary constructor is implicitly provided by the record

    // Secondary constructor with default id value
    public RoadmapDto(String name, String description, String color, Integer orderValue, Integer userId) {
        this(null, name, description, color, orderValue, userId);
    }
}