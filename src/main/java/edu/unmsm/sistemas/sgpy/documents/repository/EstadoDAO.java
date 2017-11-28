
package edu.unmsm.sistemas.sgpy.documents.repository;

import edu.unmsm.sistemas.sgpy.documents.entities.Estado;
import edu.unmsm.sistemas.sgpy.documents.entities.EstadoView;
import java.util.List;

/**
 *
 * @author Lupita
 */
public interface EstadoDAO {

    public List<EstadoView> listar();

    public List<Estado> listarEntity();

    public String insertar(Estado nuevo);
    
    public String actualizar(Estado modificacion);

    public String eliminar(int cod_fase, int cod_nivel, int est_pyto);

}
