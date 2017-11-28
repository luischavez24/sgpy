package edu.unmsm.sistemas.sgpy.documents.repository.drive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiarArchivos {
    
    private static final String SERVIDOR_SGPY = "\\\\HOST1\\sgpy\\";
    private static final CopiarArchivos INSTANCIA = new CopiarArchivos();
    
    public static CopiarArchivos getInstance() {
        return INSTANCIA;
    }
    
    private CopiarArchivos () { }
    
    public int copiarArchivos(File archivo) {
        
        File destino = new File(SERVIDOR_SGPY + archivo.getName());
        try (InputStream in = new FileInputStream(archivo); 
                OutputStream out = new FileOutputStream(destino)) {
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (IOException e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }
}
