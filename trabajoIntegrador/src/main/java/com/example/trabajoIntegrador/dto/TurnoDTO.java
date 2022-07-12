package com.example.trabajoIntegrador.dto;

import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
    private LocalTime hora;
}
