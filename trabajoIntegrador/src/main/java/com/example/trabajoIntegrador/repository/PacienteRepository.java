package com.example.trabajoIntegrador.repository;

import com.example.trabajoIntegrador.model.Odontologo;
import com.example.trabajoIntegrador.model.Paciente;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PacienteRepository implements IRepository<Paciente> {

    private List<Paciente> pacientes;

    public PacienteRepository() {
        this.pacientes = cargarPacientes();
    }

    @Override
    public Paciente agregar(Paciente paciente) {
        if(paciente.getIdPaciente() == null)
            paciente.setIdPaciente(new Random().nextInt());
        this.pacientes.add(paciente);
        return paciente;
    }

    @Override
    public List<Paciente> listar() {
        return this.pacientes;
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        eliminar(paciente.getIdPaciente());
        agregar(paciente);
        return paciente;
    }

    @Override
    public Boolean eliminar(Integer id) {
        for(Paciente paciente : pacientes){
            if(paciente.getIdPaciente().equals(id)){
                pacientes.remove(paciente);
                return true;
            }
        }
        return false;
    }

    @Override
    public Paciente buscar(Integer id) {
        for(Paciente paciente : pacientes){
            if(paciente.getIdPaciente().equals(id)){
                return paciente;
            }
        }
        return null;
    }

    private List<Paciente> cargarPacientes(){
        List<Paciente> pacientesCargados = new ArrayList<>();
        pacientesCargados.add(new Paciente("Susana", "Rodriguez", "Calle falsa 123", 40876564, new Date(102,1,12)));
        pacientesCargados.add(new Paciente("Claudia", "Sanchez", "Calle 345", 30876599, new Date(106,7,22)));
        return pacientesCargados;
    }
}
