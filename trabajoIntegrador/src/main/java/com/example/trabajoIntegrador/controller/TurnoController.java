package com.example.trabajoIntegrador.controller;

import com.example.trabajoIntegrador.dto.OdontologoDTO;
import com.example.trabajoIntegrador.dto.PacienteDTO;
import com.example.trabajoIntegrador.dto.TurnoDTO;
import com.example.trabajoIntegrador.service.OdontologoService;
import com.example.trabajoIntegrador.service.PacienteService;
import com.example.trabajoIntegrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


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
    public ResponseEntity<Collection<TurnoDTO>> listarTurnos() {
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnoDto){
        ResponseEntity<TurnoDTO> response;
        PacienteDTO paciente = pacienteService.buscarPaciente(turnoDto.getPaciente().getId());
        OdontologoDTO odontologo = odontologoService.buscarOdontologo(turnoDto.getOdontologo().getId());
        if(paciente != null && odontologo != null){
            response = ResponseEntity.ok(turnoService.agregarTurno(turnoDto));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> modificarTurno(@RequestBody TurnoDTO turnoDto){
        return ResponseEntity.ok(turnoService.modificarTurno(turnoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTurno (@PathVariable Long id) {
        ResponseEntity response = null;
        if (turnoService.buscarTurno(id) != null){
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id){
        if(turnoService.buscarTurno(id) != null){
            return ResponseEntity.ok(turnoService.buscarTurno(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
