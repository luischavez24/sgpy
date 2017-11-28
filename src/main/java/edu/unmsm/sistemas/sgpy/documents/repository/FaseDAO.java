/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.repository;
import java.util.List;
import edu.unmsm.sistemas.sgpy.documents.entities.Fase;

/**
 *
 * @author Lupita
 */
public interface FaseDAO {
    
    public List<Fase> listar();

    public String insertar(Fase nuevo);
    
    public String actualizar(Fase modificacion);

    public String eliminar(int cod_fase);
}
