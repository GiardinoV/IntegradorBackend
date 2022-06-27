package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.entity.Paciente;
import com.example.trabajoIntegrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente agregarPaciente(Paciente paciente){
        return this.pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente modificarPaciente(Paciente paciente){
        if(buscarPaciente(paciente.getId()).isPresent()){
            return pacienteRepository.save(paciente);
        }else
            return null;
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public Optional<Paciente> buscarPaciente(Long id){
        return pacienteRepository.findById(id);
    }
}
