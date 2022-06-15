package com.example.trabajoIntegrador.service;

import com.example.trabajoIntegrador.model.Odontologo;
import com.example.trabajoIntegrador.repository.IRepository;

import java.util.List;

public class OdontologoService {

    public IRepository<Odontologo> odontologoRepository;

    public OdontologoService(IRepository<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo agregarOdontologo(Odontologo odontologo){
        return this.odontologoRepository.agregar(odontologo);
    }

    public List<Odontologo> listarOdontolgos(){
        List<Odontologo> odontologos = odontologoRepository.listar();
        return odontologos;
    }

    public Odontologo modificarOdontologo(Odontologo odontologo){
        return odontologoRepository.modificar(odontologo);
    }

    public Boolean eliminarOdontologo(Integer id){
        return odontologoRepository.eliminar(id);
    }

    public Odontologo buscarOdontologo(Integer id){
        return odontologoRepository.buscar(id);
    }
}
