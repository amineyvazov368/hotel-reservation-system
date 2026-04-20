package org.example.hotelreservationsystem.model.dto.response;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.hotelreservationsystem.model.entity.RoomType;

import java.math.BigDecimal;

@Data
public class RoomResponseDto {

    @NotNull
    private Long id;
    @NotNull
    @Min(1)
    private int roomNumber;

    @NotNull
    private RoomType roomType;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotNull
    private Boolean available;


}
