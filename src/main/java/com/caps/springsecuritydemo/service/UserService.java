package com.caps.springsecuritydemo.service;

import com.caps.springsecuritydemo.common.CommonException;
import com.caps.springsecuritydemo.entity.UserPo;
import com.caps.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserPo> findAllUsers() {
        return userRepository.findAll();
    }

    public UserPo findByUsername(String username) {
        Optional<UserPo> userPoOptional = userRepository.findByUsername(username);
        if (!userPoOptional.isPresent()) {
            throw new CommonException("user not found");
        }
        return userPoOptional.get();
    }
}
