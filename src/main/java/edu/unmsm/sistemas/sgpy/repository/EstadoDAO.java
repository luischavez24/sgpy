
package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.entities.Estado;
import edu.unmsm.sistemas.sgpy.entities.EstadoView;
import java.util.List;

/**
 *
 * @author Lupita
 */
public interface EstadoDAO {

    
    public List<EstadoView> listar();

    public String insertar(Estado nuevo);

    public String actualizar(Estado modificacion);

    public String eliminar(int cod_fase, int cod_nivel, int est_pyto);
    

}
