package org.example.hotelreservationsystem.mapper;

import org.example.hotelreservationsystem.model.dto.request.UserRequestDto;
import org.example.hotelreservationsystem.model.dto.response.UserResponseDto;
import org.example.hotelreservationsystem.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public  static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setName(user.getName());

        return dto;
    }

    public User toEntity(UserRequestDto dto) {
        User user = new User();

        user.setName(dto.getName());

        return user;
    }


}
