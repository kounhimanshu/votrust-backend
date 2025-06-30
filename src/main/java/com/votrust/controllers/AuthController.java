package com.votrust.controllers;

import com.votrust.dto.LoginDTO;
import com.votrust.entity.User;
import com.votrust.repositories.UserRepository;
import com.votrust.response.ApiResponse;
import com.votrust.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());

        if (Objects.isNull(user) || !user.getPassword().equals(loginDTO.getPassword())) {
            return doErrorResponse("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return doSuccessResponse(LoginDTO.builder()
                .token(token)
                .username(user.getUsername())
                .build()
        , "Login successful");
    }
}

