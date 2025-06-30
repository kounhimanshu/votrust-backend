package com.votrust.controllers;


import com.votrust.dto.UserDTO;
import com.votrust.response.ApiResponse;
import com.votrust.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody UserDTO dto) {
        try {
            UserDTO savedUser = userService.register(dto);
            return doSuccessResponse(savedUser,"User registered successfully");
        } catch (Exception e) {
            return doErrorResponse("Registration failed: " + e.getMessage());
        }
    }
}
