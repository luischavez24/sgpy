/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.modelo;

import java.sql.*;

/**
 *
 * @author Halion
 */
public class Conexion {
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Conexion Conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@//localhost:1521/"+edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.SID;

            conexion = DriverManager.getConnection(BaseDeDatos, edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.usuario, edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.contra);
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}
