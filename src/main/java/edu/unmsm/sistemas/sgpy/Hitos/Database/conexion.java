/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axel
 */
public class conexion {
    
    private static conexion conn;
    private Connection cnx;
    
    private conexion(){
        try {
            cnx=Conexion();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    
    private Connection Conexion() throws ClassNotFoundException{
        try {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.toString());
            }
            String myDB="jdbc:oracle:thin:@localhost:1521:"+edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.SID;
            String usuario=edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.usuario;
            String password=edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.contra;
            cnx= DriverManager.getConnection(myDB,usuario,password);
            return cnx;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
    public Connection getConnection(){
        return cnx;
    }
    
    public static conexion getInstance(){
        if(conn==null){
            conn=new conexion();
        }
        return conn;
    }
}
