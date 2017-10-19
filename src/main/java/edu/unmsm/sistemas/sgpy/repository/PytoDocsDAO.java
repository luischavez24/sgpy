
package edu.unmsm.sistemas.sgpy.repository;

import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import java.util.List;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;

/**
 *
 * @author Lupita
 */

public interface PytoDocsDAO {
    
    public List<PytoDocsView> listar();
    public String insertar(PytoDocs nuevo);
    public String actualizar(PytoDocs modificacion);
    public String eliminar(int cod_pyto, int cod_doc);
    
}