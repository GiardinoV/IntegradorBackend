package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.entity.Odontologo;
import com.example.trabajoIntegrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;


    public Odontologo agregarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> listarOdontolgos(){
        return odontologoRepository.findAll();
    }

    public Odontologo modificarOdontologo(Odontologo odontologo){
       if(buscarOdontologo(odontologo.getId()).isPresent()){
           return odontologoRepository.save(odontologo);
       }else
           return null;
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public Optional<Odontologo> buscarOdontologo(Long id){
        return odontologoRepository.findById(id);
    }
}
