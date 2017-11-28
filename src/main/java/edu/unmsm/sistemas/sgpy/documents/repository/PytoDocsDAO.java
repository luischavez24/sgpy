
package edu.unmsm.sistemas.sgpy.documents.repository;

import edu.unmsm.sistemas.sgpy.documents.entities.PytoDocs;
import java.util.List;
import edu.unmsm.sistemas.sgpy.documents.entities.PytoDocsView;

/**
 *
 * @author Lupita
 */

public interface PytoDocsDAO {
    
    public List<PytoDocsView> listar();
    
    public String insertar(PytoDocs nuevo);
    public String actualizar(PytoDocs modificacion);
    public String eliminar(int cod_pyto, int cod_doc);
    public PytoDocs buscar(int cod_pyto, int corr_docs);
    public PytoDocsView buscar2(int cod_pyto, int corr_docs);  
    public List<PytoDocsView> buscarTodos(int cod_pyto);
}
