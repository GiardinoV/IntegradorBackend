package com.example.trabajoIntegrador.controller;

import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.entity.Paciente;
import com.example.trabajoIntegrador.entity.Turno;
import com.example.trabajoIntegrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.agregarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente (@PathVariable Long id) {
        ResponseEntity response = null;
        if (pacienteService.buscarPaciente(id).isPresent()){
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id){
        if(pacienteService.buscarPaciente(id).isPresent()){
            return ResponseEntity.ok(pacienteService.buscarPaciente(id).get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
