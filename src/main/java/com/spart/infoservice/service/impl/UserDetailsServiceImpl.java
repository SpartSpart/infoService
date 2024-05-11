package com.spart.infoservice.service.impl;

import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.mapper.UserMapper;
import com.spart.infoservice.repository.UserRepository;
import com.spart.infoservice.repository.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDetails userDetails =  userMapper.toDto(user);
        return userDetails;
    }

    public UserDetails getCurrent() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean isUser(String login) {
        if (!userRepository.findByLogin(login).equals(null))
            return true;
        return false;
    }

    private UserDto getUserData() {

        return  (UserDto) this.getCurrent();
    }

    public User getUser(){
        return userRepository.findByLogin(getUserData().getLogin()).get();
    }


}