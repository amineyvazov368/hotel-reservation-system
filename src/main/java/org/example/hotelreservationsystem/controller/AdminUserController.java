package org.example.hotelreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.model.dto.request.UserRequestDto;
import org.example.hotelreservationsystem.model.dto.response.UserResponseDto;
import org.example.hotelreservationsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/userss")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.addUser(dto));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getByID(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
