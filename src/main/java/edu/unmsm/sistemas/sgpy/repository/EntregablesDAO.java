/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.entities.Entregables;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface EntregablesDAO {
    
    public List<Entregables> listar();

    public String insertar(Entregables nuevo);

    public String actualizar(Entregables modificacion);

    public String eliminar(int TipoEntreg, int CorrEntreg);
    
}
