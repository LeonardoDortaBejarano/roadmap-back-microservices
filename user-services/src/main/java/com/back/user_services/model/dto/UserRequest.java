package com.back.user_services.model.dto;

import java.sql.Date;

public record UserRequest(
    Integer id,
    String username,
    String password,
    String email) {

            
    public UserRequest(String username, String password, String email) {
        this(null, username, password, email);
    }

}
