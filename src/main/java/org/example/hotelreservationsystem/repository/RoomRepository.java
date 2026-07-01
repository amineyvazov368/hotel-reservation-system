package org.example.hotelreservationsystem.repository;

import org.example.hotelreservationsystem.model.entity.Room;
import org.example.hotelreservationsystem.model.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByAvailableTrue(boolean available);
    List<Room> findByType(RoomType type);
    boolean existsByRoomNumber(int roomNumber);
    List<Room> findByRoomTypeAndAvailableTrue(RoomType type);
}
