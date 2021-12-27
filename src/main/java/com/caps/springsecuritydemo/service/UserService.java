package com.caps.springsecuritydemo.service;

import com.caps.springsecuritydemo.entity.UserPo;
import com.caps.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserPo> findAllUsers() {
        return userRepository.findAll();
    }
}
