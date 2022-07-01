package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    void agregarOdontologo() {
        OdontologoDTO odontologoDto = new OdontologoDTO();

        odontologoDto.setApellido("Perez");
        odontologoDto.setNombre("Maria");
        odontologoDto.setMatricula("ABC123");

        odontologoService.agregarOdontologo(odontologoDto);
        Collection<OdontologoDTO> listaOdontologos = odontologoService.listarOdontolgos();
        assertTrue(listaOdontologos.size() > 0);

    }
}
