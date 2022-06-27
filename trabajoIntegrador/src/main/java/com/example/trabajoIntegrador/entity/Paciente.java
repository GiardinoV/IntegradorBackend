package com.example.trabajoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name="domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @Column
    private int dni;

    @Column
    private LocalDate fechaIngreso;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>();

    public Paciente() {
    }

}
