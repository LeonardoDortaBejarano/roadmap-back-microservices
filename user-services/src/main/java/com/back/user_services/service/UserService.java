package com.back.user_services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.user_services.exception.UserNotFoundException;
import com.back.user_services.model.dto.UserRequest;
import com.back.user_services.model.dto.UserResponse;
import com.back.user_services.model.entity.User;
import com.back.user_services.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse create(UserRequest userRequest){
        User user = this.mapToUser(userRequest);
        return this.mapToUserResponse(this.userRepository.save(user));
    }
    
    public List<UserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        System.out.println("Buscando");
        List<UserResponse> userResponses =users.stream().map(this::mapToUserResponse).toList();
        return userResponses;
        
    }

    public UserResponse get(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return this.mapToUserResponse(user.get());
        } else {
            throw new UserNotFoundException("no se pudo encontrar el usuario");
        }
    }

    public User mapToUser(UserRequest UserRequest){
        User user = new User();
        user.setUsername(UserRequest.username());
        user.setEmail(UserRequest.email());
        /* user.setCreationDate(UserRequest.creationDate()); */
        user.setPassword(UserRequest.password());
        return user;
    }

    public UserResponse mapToUserResponse(User user){
        UserResponse userResponse = new UserResponse(user.getId(),user.getUsername(),user.getEmail(),user.getCreationDate());
        return userResponse;
    }

}
