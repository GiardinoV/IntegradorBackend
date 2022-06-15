package com.example.trabajoIntegrador.repository;

import java.util.List;

public interface IRepository <T> {

    T agregar(T t);
    List<T> listar();
    T modificar(T t);
    Boolean eliminar(Integer id);
    T buscar(Integer id);
}
