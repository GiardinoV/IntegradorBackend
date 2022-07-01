package com.example.trabajoIntegrador.controller;

import com.example.trabajoIntegrador.dto.PacienteDTO;
import com.example.trabajoIntegrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Collection<PacienteDTO>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> registrarPaciente(@RequestBody PacienteDTO pacienteDto){
        return ResponseEntity.ok(pacienteService.agregarPaciente(pacienteDto));
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> modificarPaciente(@RequestBody PacienteDTO pacienteDto){
        return ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente (@PathVariable Long id) {
        ResponseEntity response = null;
        if (pacienteService.buscarPaciente(id) != null){
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable Long id){
        if(pacienteService.buscarPaciente(id) != null){
            return ResponseEntity.ok(pacienteService.buscarPaciente(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
