package edu.unmsm.sistemas.sgpy.repository;

import java.util.List;

/**
 * 
 * @author lucho
 * @param <T> Entidad que manejará la clase
 * @param <K> Objeto que contendra la representación de la Entidad
 */

public interface ModeloIDAO <T,K> {

    public List<K> listar();

    public String insertar(T nuevo);

    public String actualizar(T modificacion);

    public String eliminar(String codigo);
    
}
