package com.spart.infoservice.mapper;

import com.spart.infoservice.controller.dto.UserDto;
import com.spart.infoservice.repository.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
