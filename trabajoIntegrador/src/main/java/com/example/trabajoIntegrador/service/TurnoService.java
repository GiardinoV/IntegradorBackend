package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.entity.Turno;
import com.example.trabajoIntegrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    public Turno agregarTurno(Turno turno){
        return turnoRepository.save(turno);
    }

    public List<Turno> listarTurnos(){
        return turnoRepository.findAll();
    }

    public Turno modificarTurno(Turno turno){
        if(buscarTurno(turno.getId()).isPresent()) {
            return turnoRepository.save(turno);
        }else
            return null;
    }

    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public Optional<Turno> buscarTurno(Long id){
        return turnoRepository.findById(id);
    }

}
