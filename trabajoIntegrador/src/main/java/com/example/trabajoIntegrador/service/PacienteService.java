package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.model.Odontologo;
import com.example.trabajoIntegrador.model.Paciente;
import com.example.trabajoIntegrador.repository.IRepository;

import java.util.List;

public class PacienteService {

    public IRepository<Paciente> pacienteRepository;

    public PacienteService(IRepository<Paciente> pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente agregarPaciente(Paciente paciente){
        return this.pacienteRepository.agregar(paciente);
    }

    public List<Paciente> listarPacientes(){
        List<Paciente> pacientes = pacienteRepository.listar();
        return pacientes;
    }

    public Paciente modificarPaciente(Paciente paciente){
        return pacienteRepository.modificar(paciente);
    }

    public Boolean eliminarPaciente(Integer id){
        return pacienteRepository.eliminar(id);
    }

    public Paciente buscarPaciente(Integer id){
        return pacienteRepository.buscar(id);
    }
}
