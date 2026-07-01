package org.example.hotelreservationsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userss")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
//wwwdedweefwefewfew
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
}
