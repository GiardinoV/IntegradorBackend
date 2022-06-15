package com.example.trabajoIntegrador.controller;

import com.example.trabajoIntegrador.model.Paciente;
import com.example.trabajoIntegrador.repository.PacienteRepository;
import com.example.trabajoIntegrador.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private PacienteService pacienteService = new PacienteService((new PacienteRepository()));

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PutMapping
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente (@PathVariable Integer id) {
        ResponseEntity response = null;
        if (pacienteService.eliminarPaciente(id))
            response = ResponseEntity.status(HttpStatus.OK).build();
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPaciente(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }
}
