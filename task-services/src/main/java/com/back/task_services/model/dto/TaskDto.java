package com.back.task_services.model.dto;

public record TaskDto(
    Integer id,
    String name,
    Integer orderValue,
    boolean isComplete,
    Integer milestoneId) {
        
        public  TaskDto(String name, Integer orderValue, boolean isComplete, Integer milestoneId) {
            this(null,name, orderValue,isComplete,milestoneId);
        }

}

 
