package com.example.trabajoIntegrador.controller;
import com.example.trabajoIntegrador.dto.OdontologoDTO;
import com.example.trabajoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<Collection<OdontologoDTO>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.listarOdontolgos());
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> registrarOdontologo(@RequestBody OdontologoDTO odontologoDto){
        return ResponseEntity.ok(odontologoService.agregarOdontologo(odontologoDto));
    }

    @PutMapping
    public ResponseEntity<OdontologoDTO> modificarOdontologo(@RequestBody OdontologoDTO odontologoDto){
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo (@PathVariable Long id) {
        ResponseEntity response = null;
        if (odontologoService.buscarOdontologo(id) != null){
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontolgo(@PathVariable Long id){
        if(odontologoService.buscarOdontologo(id) != null){
            return ResponseEntity.ok(odontologoService.buscarOdontologo(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
