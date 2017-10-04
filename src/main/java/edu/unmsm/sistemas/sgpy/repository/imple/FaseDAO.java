/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class FaseDAO implements ModeloIDAO<Fase> {

    public List<Fase> listar() {
        List<Fase> miLista = new List<>();
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "SELECT * FROM Fase", DesFase, Vigencia;
        Integer CodFase;//me guie del proyecto de estructura
        try {
            PreparedStatement comando = acceso.getConexion("basedatos1", "sgpy", "Prueba$1").prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                CodFase = resultado.getInt(1);
                DesFase = resultado.getString(2);
                Vigencia = resultado.getString(3);
                miLista.add(new Fase(CodFase, DesFase, Vigencia));
            }
        } catch (SQLException ex) {
        } finally {
            acceso.close();
        }
        return miLista;
    }

    public String insertar(Fase nuevo) {
        String rpta = "Insercion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "INSERT INTO Fase VALUES (?,?,?)";
        try {
            PreparedStatement comando = acceso.getConexion("basedatos1", "sgpy", "Prueba$1").prepareStatement(sql);

            comando.setString(1, String.valueOf(nuevo.getCodFase()));
            comando.setString(2, nuevo.getDesFase());
            comando.setString(3, nuevo.getVigencia());

            int insertado = comando.executeUpdate();

            if (insertado == 0) {
                rpta = "Error al Insertar";
            }

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }

    public String actualizar(Fase actualizacion) {
        String rpta = "Actualizacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "UPDATE Fase SET CodFase=?,DesFase=?,Vigencia=?  WHERE CodFase = '"
                + actualizacion.getCodFase()+ "'";//Lucho revisa ese where si esta bien pq no entiendo la BD del profe :v
        try {

            PreparedStatement comando = acceso.getConexion("basedatos1", "sgpy", "Prueba$1").prepareStatement(sql);
            comando.setString(1, String.valueOf(actualizacion.getCodFase()));
            comando.setString(3, actualizacion.getDesFase());
            comando.setString(4, actualizacion.getVigencia());
            int actualizar = comando.executeUpdate();
            if (actualizar == 0) {
                rpta = "Error al actualizar";
            }

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }

    @Override
    public String eliminar(String codFase) {
        String rpta = "Eliminacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "DELETE FROM Fase WHERE CodFase = '" + codFase +"'";//Lucho revisa este where si esta bien pq no entiendo la BD del profe :v

        try {

            PreparedStatement comando = acceso.getConexion("basedatos1", "sgpy", "Prueba$1").prepareStatement(sql);
            int eliminar = comando.executeUpdate();
            if (eliminar == 0) {
                rpta = "Error Eliminar";
            }

        } catch (SQLException ex) {
            rpta = ex.getMessage();
        } finally {
            acceso.close();
        }
        return rpta;
    }
}
