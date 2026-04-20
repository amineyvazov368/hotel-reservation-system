package org.example.hotelreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.model.dto.request.ReservationRequestDto;
import org.example.hotelreservationsystem.model.dto.response.ReservationResponseDto;
import org.example.hotelreservationsystem.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    @PostMapping
    public ResponseEntity<ReservationResponseDto> create(@RequestBody ReservationRequestDto dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAll() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }
}
