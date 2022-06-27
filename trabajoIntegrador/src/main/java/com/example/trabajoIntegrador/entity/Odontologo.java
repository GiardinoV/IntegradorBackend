package com.example.trabajoIntegrador.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name="odontologos")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String matricula;

    @OneToMany(mappedBy = "odontologo",fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>();

    public Odontologo() {
    }


}
