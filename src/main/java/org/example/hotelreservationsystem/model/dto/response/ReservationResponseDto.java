package org.example.hotelreservationsystem.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReservationResponseDto {

    private Long id;

    private Long userId;
    private String username; // optional (çox yaxşı practice)

    private Long roomId;
    private Integer roomNumber;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private BigDecimal totalPrice;



}
