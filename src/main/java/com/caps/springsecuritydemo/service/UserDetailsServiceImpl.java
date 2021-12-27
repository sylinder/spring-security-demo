package com.caps.springsecuritydemo.service;

import com.caps.springsecuritydemo.domain.UserInfo;
import com.caps.springsecuritydemo.entity.RolePo;
import com.caps.springsecuritydemo.entity.UserPo;
import com.caps.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPo> userPoOptional = userRepository.findByUsername(username);
        if (!userPoOptional.isPresent()) {
            throw new UsernameNotFoundException("username not found");
        }
        UserPo userPo = userPoOptional.get();
        Set<RolePo> roles = userPo.getRoles();
        List<String> roleNames = roles.stream().map(RolePo::getRoleName).collect(Collectors.toList());
        return UserInfo.builder()
                .username(userPo.getUsername())
                .password(userPo.getPassword())
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", roleNames)))
                .build();
    }
}
