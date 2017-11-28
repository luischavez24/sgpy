package edu.unmsm.sistemas.sgpy.documents.controller;
import edu.unmsm.sistemas.sgpy.documents.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.documents.repository.PytoDocsDAO;
import edu.unmsm.sistemas.sgpy.documents.repository.imple.PytoDocsDAOImple;
public class PytoDocsController {
   
    private static PytoDocsController INSTANCE = new PytoDocsController();

    private PytoDocsController() { }
    
    public static PytoDocsController getInstance() {
        return INSTANCE;
    }
    
   
    public String actualizarPytoDocs(PytoDocs pytoDocs) {
        
        PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();
        
        String message = pytoDocsDAO.actualizar(pytoDocs);
        
        return message;
        
    }
}
