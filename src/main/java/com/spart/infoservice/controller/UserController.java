package com.spart.infoservice.controller;

import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public Long addUser(@RequestBody @Valid UserDto userDto) {
            return userService.addUser(userDto);

    }

    @GetMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public UserDto getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

}
