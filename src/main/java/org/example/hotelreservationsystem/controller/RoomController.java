package org.example.hotelreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.model.dto.response.RoomResponseDto;
import org.example.hotelreservationsystem.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {


    private final RoomService roomService;


    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }


    @GetMapping("/available")
    public ResponseEntity<List<RoomResponseDto>> getAvailableRooms() {
        return ResponseEntity.ok(roomService.getAvailableRooms());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(roomService.getById(id));
    }
}
