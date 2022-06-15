package com.example.trabajoIntegrador.repository;

import com.example.trabajoIntegrador.model.Odontologo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OdontologoRepository implements IRepository<Odontologo> {

    private List<Odontologo> odontologos;

    public OdontologoRepository(){
        this.odontologos = cargarOdontologos();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        if(odontologo.getIdOdontologo() == null)
            odontologo.setIdOdontologo(new Random().nextInt());
        this.odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        return this.odontologos;
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        eliminar(odontologo.getIdOdontologo());
        agregar(odontologo);
        return odontologo;
    }

    @Override
    public Boolean eliminar(Integer id) {
        for(Odontologo odontologo : odontologos){
            if(odontologo.getIdOdontologo().equals(id)){
                odontologos.remove(odontologo);
                return true;
            }
        }
        return false;
    }

    @Override
    public Odontologo buscar(Integer id) {
        for(Odontologo odontologo : odontologos){
            if(odontologo.getIdOdontologo().equals(id)){
                return odontologo;
            }
        }
        return null;
    }

    private List<Odontologo> cargarOdontologos(){
        List<Odontologo> odontologosCargados = new ArrayList<>();
        odontologosCargados.add(new Odontologo("Perez", "Juan", 1234));
        odontologosCargados.add(new Odontologo("Garcia", "Maria", 5678));
        return odontologosCargados;
    }
}
