/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.entities.TipoEntreg;
import java.util.List;

/**
 *
 * @author lucho
 */
public interface TipoEntregDAO {
    
    public List<TipoEntreg> listarEntity();

    public String insertar(TipoEntreg nuevo);

    public String actualizar(TipoEntreg modificacion);

    public String eliminar(int tipoEntreg);
}
