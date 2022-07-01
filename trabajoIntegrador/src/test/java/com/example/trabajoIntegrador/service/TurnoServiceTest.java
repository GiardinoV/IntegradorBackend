package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.TurnoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    TurnoService turnoService;

    @Test
    void agregarTurno() {

        TurnoDTO turnoDto = new TurnoDTO();

        turnoDto.setFecha(LocalDate.of(2022,04,12));
        turnoService.agregarTurno(turnoDto);
        Collection<TurnoDTO> turnos = turnoService.listarTurnos();
        assertNotNull(turnos);
    }
}