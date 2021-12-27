package com.caps.springsecuritydemo.controller;

import com.caps.springsecuritydemo.entity.UserPo;
import com.caps.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserPo> findAllUsers() {
        return userService.findAllUsers();
    }
}
