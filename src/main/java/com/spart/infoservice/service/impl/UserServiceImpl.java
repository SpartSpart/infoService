package com.spart.infoservice.service.impl;

import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.mapper.UserMapper;
import com.spart.infoservice.repository.UserRepository;
import com.spart.infoservice.repository.model.User;
import com.spart.infoservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Long addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user.getId();
//        return null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserDto userDto;
        Optional<User> user = Optional.ofNullable(userRepository.findById(userId)).orElseThrow(() -> new RuntimeException(""));
        userDto = userMapper.toDto(user.get());
        return userDto;

    }
}
