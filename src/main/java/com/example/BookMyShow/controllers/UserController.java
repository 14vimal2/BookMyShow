package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.dtos.SignUpRequestDTO;
import com.example.BookMyShow.dtos.SignUpResponseDTO;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            User user = userService.signUp(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception exception) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(exception.getMessage());
        }

        return responseDTO;

    }
}
