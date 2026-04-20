package org.example.hotelreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservationsystem.mapper.RoomMapper;
import org.example.hotelreservationsystem.model.dto.request.RoomRequestDto;
import org.example.hotelreservationsystem.model.dto.response.RoomResponseDto;
import org.example.hotelreservationsystem.model.entity.Room;
import org.example.hotelreservationsystem.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponseDto create(RoomRequestDto dto) {

        if (roomRepository.existsByRoomNumber(dto.getRoomNumber())) {
            throw new RuntimeException("Room already exists with number: " + dto.getRoomNumber());
        }

        Room room = RoomMapper.toEntity(dto);
        Room savedRoom = roomRepository.save(room);

        return RoomMapper.toDto(savedRoom);
    }


    public RoomResponseDto getById(int id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        return RoomMapper.toDto(room);
    }


    public List<RoomResponseDto> getAll() {

        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RoomResponseDto> getAvailableRooms() {

        return roomRepository.findAll()
                .stream()
                .filter(Room::getAvailable)
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }



}
