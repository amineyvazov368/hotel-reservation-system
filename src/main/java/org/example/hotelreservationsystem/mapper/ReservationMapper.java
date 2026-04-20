package org.example.hotelreservationsystem.mapper;

import org.example.hotelreservationsystem.model.dto.request.ReservationRequestDto;
import org.example.hotelreservationsystem.model.dto.response.ReservationResponseDto;
import org.example.hotelreservationsystem.model.entity.Reservation;
import org.example.hotelreservationsystem.model.entity.Room;
import org.example.hotelreservationsystem.model.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ReservationMapper {

    public Reservation toEntity(ReservationRequestDto reservationRequestDto, User user, Room room) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setCheckIn(reservationRequestDto.getCheckIn());
        reservation.setCheckOut(reservationRequestDto.getCheckOut());

        return reservation;
    }

    public static ReservationResponseDto toDto(Reservation reservation) {
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
        reservationResponseDto.setId(reservation.getId());
        reservationResponseDto.setUserId(reservation.getUser().getId());
        reservationResponseDto.setUsername(reservation.getUser().getName());
        reservationResponseDto.setRoomId(reservation.getRoom().getId());
        reservationResponseDto.setRoomNumber(reservation.getRoom().getRoomNumber());
        reservationResponseDto.setCheckIn(reservation.getCheckIn());
        reservationResponseDto.setCheckOut(reservation.getCheckOut());
        reservationResponseDto.setTotalPrice(reservation.getTotalPrice());
        return reservationResponseDto;
    }
}
