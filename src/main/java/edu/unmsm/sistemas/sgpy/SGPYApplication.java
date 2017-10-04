package edu.unmsm.sistemas.sgpy;

import edu.unmsm.sistemas.sgpy.repository.DAOConnection;

public class SGPYApplication {
    public static void main(String[] args) {
        DAOConnection conexion = DAOConnection.getInstance();
        System.out.println(conexion.getConexion("basedatos1","sgpy","Prueba$1"));
    }
}
