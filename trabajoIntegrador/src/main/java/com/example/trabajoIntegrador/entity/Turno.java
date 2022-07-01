package com.example.trabajoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name="turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Odontologo odontologo;

    @Column
    private LocalDate fecha;

    public Turno() {
    }
}
