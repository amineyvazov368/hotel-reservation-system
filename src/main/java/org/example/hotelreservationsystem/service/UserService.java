package org.example.hotelreservationsystem.service;


import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.mapper.UserMapper;
import org.example.hotelreservationsystem.model.dto.request.UserRequestDto;
import org.example.hotelreservationsystem.model.dto.response.UserResponseDto;
import org.example.hotelreservationsystem.model.entity.User;
import org.example.hotelreservationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByName(userRequestDto.getName())){
            throw new RuntimeException("Username already exists");
        }
        User user= userMapper.toEntity(userRequestDto);
        User saveUser=  userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponseDto getByID(Long id) {
       User user=  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
       return userMapper.toDto(user);
    }

    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public void delete(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.delete(user);
    }





}
