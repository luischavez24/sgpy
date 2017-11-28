package edu.unmsm.sistemas.sgpy.FiltroDinamico;

import edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    public static Connection conectarbd(){
        Connection cn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","CONSTRUCTORA","CONSTRUCTORA");
            System.out.println("Conexion OK");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return cn;
    }
    public static Connection conectarbd2(String esquema, String contraseña ){
        Connection cn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:"+DatosConexionPrincipal.SID,esquema,contraseña);
            
            JOptionPane.showMessageDialog(null, "Conexion correcta");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cn;
    }
}
