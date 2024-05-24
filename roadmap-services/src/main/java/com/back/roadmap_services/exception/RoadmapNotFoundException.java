package com.back.roadmap_services.exception;

public class RoadmapNotFoundException extends RuntimeException{
    public RoadmapNotFoundException(String message){
        super(message);
    }
}

