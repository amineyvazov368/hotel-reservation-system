package org.example.hotelreservationsystem.repository;

import org.example.hotelreservationsystem.model.dto.response.UserResponseDto;
import org.example.hotelreservationsystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);
}
