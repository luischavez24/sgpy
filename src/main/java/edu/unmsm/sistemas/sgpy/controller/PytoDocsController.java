package edu.unmsm.sistemas.sgpy.controller;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.repository.PytoDocsDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.PytoDocsDAOImple;
public class PytoDocsController {
   
    private static PytoDocsController INSTANCE = new PytoDocsController();

    private PytoDocsController() { }
    
    public static PytoDocsController getInstace() {
        return INSTANCE;
    }
    
    public String actualizarPytoDocs(PytoDocs pytoDocs) {
        
        PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();
        
        String message = pytoDocsDAO.actualizar(pytoDocs);
        
        return message;
        
    }
}
