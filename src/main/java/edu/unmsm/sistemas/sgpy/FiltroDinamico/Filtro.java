/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.FiltroDinamico;

/**
 *
 * @author Yshara
 */
public class Filtro {
    public String nombre;
    public boolean estado;
    public String valor;

    public Filtro(String nombre, boolean estado, String valor) {
        this.nombre = nombre;
        this.estado = estado;
        this.valor = valor;
    }
    
}
