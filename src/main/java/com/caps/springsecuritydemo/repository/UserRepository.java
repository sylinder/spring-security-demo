package com.caps.springsecuritydemo.repository;

import com.caps.springsecuritydemo.entity.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPo, Long> {

    Optional<UserPo> findByUsername(String username);
}
