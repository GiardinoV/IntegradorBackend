package com.example.trabajoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String matricula;

    @OneToMany(mappedBy = "odontologo",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Odontologo() {
    }

}
