package org.example.hotelreservationsystem.mapper;

import org.example.hotelreservationsystem.model.dto.request.RoomRequestDto;
import org.example.hotelreservationsystem.model.dto.response.RoomResponseDto;
import org.example.hotelreservationsystem.model.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {


    public static RoomResponseDto toDto(Room room) {
        RoomResponseDto dto = new RoomResponseDto();

        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setAvailable(room.getAvailable());

        return dto;
    }

    public static   Room toEntity(RoomRequestDto dto) {
        Room room = new Room();

        room.setRoomNumber(dto.getRoomNumber());
        room.setType(dto.getRoomType());
        room.setPrice(dto.getPrice());
        room.setAvailable(true);

        return room;
    }
}
