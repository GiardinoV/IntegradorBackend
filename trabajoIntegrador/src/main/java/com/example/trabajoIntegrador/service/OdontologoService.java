package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.dto.OdontologoDTO;
import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDto){
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);
        return odontologoDto;
    }

    public Collection<OdontologoDTO> listarOdontolgos(){
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDtoSet = new HashSet<>();
        for(Odontologo odontologo: odontologos){
            odontologosDtoSet.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDtoSet;
    }

    public OdontologoDTO modificarOdontologo(OdontologoDTO odontologoDto){
       Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);
        return odontologoDto;
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public OdontologoDTO buscarOdontologo(Long id){
        OdontologoDTO odontologoDto = null;
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            odontologoDto = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDto;
    }
}
