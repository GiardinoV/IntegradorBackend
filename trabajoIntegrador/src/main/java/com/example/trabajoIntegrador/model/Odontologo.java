package com.example.trabajoIntegrador.model;

import java.util.Random;

public class Odontologo {

    private Integer idOdontologo;
    private String apellido;
    private String nombre;
    private int matricula;

    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, int matricula) {
        this.idOdontologo = new Random().nextInt();
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Integer getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Integer idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
