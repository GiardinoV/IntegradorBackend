package com.example.trabajoIntegrador.controller;
import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.entity.Paciente;
import com.example.trabajoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.listarOdontolgos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.agregarOdontologo(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo (@PathVariable Long id) {
        ResponseEntity response = null;
        if (odontologoService.buscarOdontologo(id).isPresent()){
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontolgo(@PathVariable Long id){
        if(odontologoService.buscarOdontologo(id).isPresent()){
            return ResponseEntity.ok(odontologoService.buscarOdontologo(id).get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
