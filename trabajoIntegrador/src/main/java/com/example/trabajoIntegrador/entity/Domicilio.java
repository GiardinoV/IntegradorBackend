package com.example.trabajoIntegrador.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name="domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String calle;
    @Column
    private String numero;
    @Column
    private String localidad;
    @Column
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    public Domicilio() {
    }


}
