package com.back.task_services.execeptions;

public class TaskNotFoundExeception extends RuntimeException {
    public TaskNotFoundExeception(String message) {
        super(message);
    }
}
