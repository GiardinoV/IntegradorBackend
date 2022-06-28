package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.TurnoDTO;
import com.example.trabajoIntegrador.entity.Turno;
import com.example.trabajoIntegrador.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public TurnoDTO agregarTurno(TurnoDTO turnoDto){
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
        return turnoDto;
    }

    public Collection<TurnoDTO> listarTurnos(){
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDtoSet = new HashSet<>();
        for (Turno turno: turnos){
            turnosDtoSet.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDtoSet;
    }

    public TurnoDTO modificarTurno(TurnoDTO turnoDto){
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
        return turnoDto;
    }

    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public TurnoDTO buscarTurno(Long id){
        TurnoDTO turnoDto = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isPresent()){
            turnoDto = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDto;
    }

}
