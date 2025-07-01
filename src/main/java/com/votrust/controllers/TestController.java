package com.votrust.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    //this controller is only for testing purpose

    @GetMapping
    public String TestController() {
        return "Test Controller is working fine";
    }


}
