package org.example.hotelreservationsystem.model.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.example.hotelreservationsystem.model.entity.RoomType;

import java.math.BigDecimal;

@Data
public class RoomRequestDto {


    @NotNull(message = "Room number boş ola bilməz")
    @Min(value = 1, message = "Room number 1-dən kiçik ola bilməz")
    private int roomNumber;

    @NotNull(message = "Room type boş ola bilməz")
    private RoomType roomType;

    @NotNull(message = "Price boş ola bilməz")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price 0-dan böyük olmalıdır")
    private BigDecimal price;



}
