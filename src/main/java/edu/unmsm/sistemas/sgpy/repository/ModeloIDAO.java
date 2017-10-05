package edu.unmsm.sistemas.sgpy.repository;

import java.util.List;

public interface ModeloIDAO <T,K> {

    public List<K> listar();

    public String insertar(T nuevo);

    public String actualizar(T modificacion);

    public String eliminar(String codigo);
    
}
