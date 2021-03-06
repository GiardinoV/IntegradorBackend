package com.example.trabajoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@Getter
@Setter
@Entity
@Table(name="turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name="odontologo_id")
    private Odontologo odontologo;

    @Column
    private LocalDate fecha;

    @Column
    private LocalTime hora;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha, LocalTime hora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }
}
