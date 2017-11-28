
package edu.unmsm.sistemas.sgpy.ProfYExp.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private Conexion() {
    }

    public static Connection getConnection() throws SQLException {
      Connection cn = null;
      // Parámetros
      String SID=edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.SID;
      String driver = "oracle.jdbc.OracleDriver";
      String urlDB = "jdbc:oracle:thin:@localhost:1521:"+SID;
      String user = edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.usuario;
      String pass = edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.contra;
      try {
        // Conexión con la BD
        Class.forName(driver).newInstance();
        cn = DriverManager.getConnection(urlDB, user, pass);
          //System.out.println("Me conecte");
       //   System.out.println("Base de datos conectada");
      } catch (SQLException e) {
        throw e;
      } catch (ClassNotFoundException e) {
        throw new SQLException("No se encontro el driver de la BD.");
      } catch (Exception e) {
        throw new SQLException("No se puede establecer "
                + "conexión de la BD.");
      }
      return cn;
    }
  
    public static void main(String[] args) throws SQLException{
        Conexion.getConnection();
    }  
}
