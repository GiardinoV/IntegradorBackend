package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    @Test
    void listarPacientes() {
        PacienteDTO pacienteDto = new PacienteDTO();

        pacienteDto.setApellido("Garcia");
        pacienteDto.setNombre("Juan");
        pacienteDto.setDni(33453121);

        pacienteService.agregarPaciente(pacienteDto);
        Collection<PacienteDTO> pacientes = pacienteService.listarPacientes();
        assertNotNull(pacientes);
    }
}
