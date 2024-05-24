package com.back.user_services.model.dto;

import java.util.Date;

public record UserResponse(
Integer id,
String username,
String email,
Date creationDate) {

}