package org.example.hotelreservationsystem.repository;

import org.example.hotelreservationsystem.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByUserId(Long userId);
    Reservation findByRoomId(Long roomId);
}
