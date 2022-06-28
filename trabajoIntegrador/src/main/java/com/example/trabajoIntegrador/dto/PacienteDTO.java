package com.example.trabajoIntegrador.dto;

import com.example.trabajoIntegrador.entity.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private int dni;
    private LocalDate fechaIngreso;
}
