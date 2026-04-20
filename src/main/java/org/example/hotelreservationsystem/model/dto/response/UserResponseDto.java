package org.example.hotelreservationsystem.model.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    @NotNull(message = "Name bos ola bilmez")
    private String name;

}
