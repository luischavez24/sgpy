/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.repository;

import edu.unmsm.sistemas.sgpy.documents.entities.Nivel;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface NivelDAO {
    
    public List<Nivel> listar();

    public String insertar(Nivel nuevo);

    public String actualizar(Nivel modificacion);

    public String eliminar(int CodFase, int CodNivel);
    
}
