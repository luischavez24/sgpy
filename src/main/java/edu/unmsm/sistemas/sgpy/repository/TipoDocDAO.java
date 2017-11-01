/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.entities.TipoDoc;
import java.util.List;

/**
 *
 * @author Lupita
 */
public interface TipoDocDAO {
    
    public List<TipoDoc> listar();
    
    public String insertar(TipoDoc nuevo);
    
    public String actualizar(TipoDoc modificacion);
    
    public String eliminar(int cod_doc);
    
}
