package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.PacienteDTO;
import com.example.trabajoIntegrador.entity.Paciente;
import com.example.trabajoIntegrador.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    public PacienteDTO agregarPaciente(PacienteDTO pacienteDto){
        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDto;
    }

    public Collection<PacienteDTO> listarPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDtoSet = new HashSet<>();
        for (Paciente paciente: pacientes){
            pacientesDtoSet.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDtoSet;
    }

    public PacienteDTO modificarPaciente(PacienteDTO pacienteDto){
        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDto;
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO buscarPaciente(Long id){
        PacienteDTO pacienteDto = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            pacienteDto = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDto;
    }
}


