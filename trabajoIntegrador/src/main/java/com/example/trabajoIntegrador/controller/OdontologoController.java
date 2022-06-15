package com.example.trabajoIntegrador.controller;
import com.example.trabajoIntegrador.model.Odontologo;
import com.example.trabajoIntegrador.repository.OdontologoRepository;
import com.example.trabajoIntegrador.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService((new OdontologoRepository()));

    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listarOdontolgos();
    }

    @PutMapping
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo (@PathVariable Integer id) {
        ResponseEntity response = null;
        if (odontologoService.eliminarOdontologo(id))
            response = ResponseEntity.status(HttpStatus.OK).build();
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarOdontolgo(@PathVariable Integer id){
        return ResponseEntity.ok(odontologoService.buscarOdontologo(id));
    }
}
