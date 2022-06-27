package com.example.trabajoIntegrador.controller;

import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.entity.Paciente;
import com.example.trabajoIntegrador.entity.Turno;
import com.example.trabajoIntegrador.service.OdontologoService;
import com.example.trabajoIntegrador.service.PacienteService;
import com.example.trabajoIntegrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos() {
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        Optional<Paciente> paciente = pacienteService.buscarPaciente(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.buscarOdontologo(turno.getOdontologo().getId());
        if(paciente.isPresent() && odontologo.isPresent()){
            response = ResponseEntity.ok(turnoService.agregarTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> modificarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.modificarTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTurno (@PathVariable Long id) {
        ResponseEntity response = null;
        if (turnoService.buscarTurno(id).isPresent()){
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){
        if(turnoService.buscarTurno(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscarTurno(id).get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
