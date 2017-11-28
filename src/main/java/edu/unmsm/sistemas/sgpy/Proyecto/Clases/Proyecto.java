/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Proyecto.Clases;

/** * @author oches_000

 *
 */
public class Proyecto {
    String codigo_proyecto;
    String Nombre_proyecto;

    public Proyecto(String codigo_proyecto, String Nombre_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
        this.Nombre_proyecto = Nombre_proyecto;
    }

    public String getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(String codigo_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
    }

    public String getNombre_proyecto() {
        return Nombre_proyecto;
    }

    public void setNombre_proyecto(String Nombre_proyecto) {
        this.Nombre_proyecto = Nombre_proyecto;
    }

    
    
    
}
