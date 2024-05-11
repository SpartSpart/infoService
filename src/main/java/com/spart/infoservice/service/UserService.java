package com.spart.infoservice.service;

import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.repository.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Long addUser(UserDto userDto);

    UserDto getUserById(Long userId);
}
