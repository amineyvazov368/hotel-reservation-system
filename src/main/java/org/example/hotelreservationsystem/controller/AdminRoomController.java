package org.example.hotelreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.model.dto.request.RoomRequestDto;
import org.example.hotelreservationsystem.model.dto.response.RoomResponseDto;
import org.example.hotelreservationsystem.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rooms")
@RequiredArgsConstructor
public class AdminRoomController {


    private final RoomService roomService;


    @PostMapping
    public ResponseEntity<RoomResponseDto> create(@RequestBody RoomRequestDto dto) {
        return ResponseEntity.ok(roomService.create(dto));
    }


    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAll() {
        return ResponseEntity.ok(roomService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(roomService.getById(id));
    }
}
