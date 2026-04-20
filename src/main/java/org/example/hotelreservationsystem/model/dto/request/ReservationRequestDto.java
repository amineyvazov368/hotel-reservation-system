package org.example.hotelreservationsystem.model.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDto {

    @NotNull(message = "User id boş ola bilməz")
    private Long userId;

    @NotNull(message = "Room id boş ola bilməz")
    private Long roomId;

    @NotNull(message = "Check-in tarixi boş ola bilməz")
    @FutureOrPresent(message = "Check-in keçmiş tarix ola bilməz")
    private LocalDate checkIn;

    @NotNull(message = "Check-out tarixi boş ola bilməz")
    @Future(message = "Check-out gələcək tarix olmalıdır")
    private LocalDate checkOut;


}
