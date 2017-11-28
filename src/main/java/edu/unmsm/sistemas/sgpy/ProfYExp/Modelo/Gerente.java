/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Modelo;

import java.sql.Blob;

/**
 *
 * @author Casa
 */
public class Gerente {
    private String nombre;
    private String empresa;
    private String direccion;
    private  Blob fotos;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Blob getFotos() {
        return fotos;
    }

    public void setFotos(Blob fotos) {
        this.fotos = fotos;
    } 
}
