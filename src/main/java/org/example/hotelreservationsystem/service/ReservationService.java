package org.example.hotelreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.mapper.ReservationMapper;
import org.example.hotelreservationsystem.model.dto.request.ReservationRequestDto;
import org.example.hotelreservationsystem.model.dto.response.ReservationResponseDto;
import org.example.hotelreservationsystem.model.entity.Reservation;
import org.example.hotelreservationsystem.model.entity.Room;
import org.example.hotelreservationsystem.model.entity.User;
import org.example.hotelreservationsystem.repository.ReservationRepository;
import org.example.hotelreservationsystem.repository.RoomRepository;
import org.example.hotelreservationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationMapper reservationMapper;


    public ReservationResponseDto createReservation(ReservationRequestDto reservationRequestDto) {
        User user = userRepository.findById(reservationRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        Room room = roomRepository.findById(Math.toIntExact(reservationRequestDto.getRoomId()))
                .orElseThrow(()->new RuntimeException("Room Not Found"));

        if (!room.getAvailable()){
            throw new RuntimeException("Room Not Available");
        }
        long days = ChronoUnit.DAYS.between(reservationRequestDto.getCheckIn(), reservationRequestDto.getCheckOut());

        if (days <= 0) {
        throw new RuntimeException("Invalid reservation dates");
        }

       BigDecimal totalPrice= room.getPrice().multiply(BigDecimal.valueOf(days));

        Reservation reservation = reservationMapper.toEntity(reservationRequestDto, user,room);
        reservation.setTotalPrice(totalPrice);
        room.setAvailable(false);
        reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);

    }

    public List<ReservationResponseDto> getAllReservations() {
        return reservationRepository.findAll()
                .stream().map(ReservationMapper::toDto)
                .toList();
    }

    public ReservationResponseDto getReservationById(Long id) {
       Reservation reservation=  reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation Not Found"));
        return ReservationMapper.toDto(reservation);
    }

    public ReservationResponseDto deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation Not Found"));
        Room room = reservation.getRoom();
        room.setAvailable(true);
        reservationRepository.delete(reservation);
       return reservationMapper.toDto(reservation);

    }

}
