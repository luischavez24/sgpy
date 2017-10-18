/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.repository.imple;

import edu.unmsm.sistemas.sgpy.constants.BDConstants;
import edu.unmsm.sistemas.sgpy.entities.Entregables;
import edu.unmsm.sistemas.sgpy.repository.DAOConnection;
import edu.unmsm.sistemas.sgpy.repository.ModeloIDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class EntregablesDAO implements ModeloIDAO<Entregables, Entregables> {

    private static final EntregablesDAO ENTREGABLESDAO = new EntregablesDAO();

    public static EntregablesDAO getInstance() {
        return ENTREGABLESDAO;
    }

    @Override
    public List<Entregables> listar() {
        List<Entregables> miLista = new ArrayList<>();
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "SELECT * FROM Entregables", DesEntreg, DesCortaEntreg;
        Integer TipoEntreg, CorrEntreg;
        try {
            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                TipoEntreg = resultado.getInt(1);
                CorrEntreg = resultado.getInt(2);
                DesEntreg = resultado.getString(3);
                DesCortaEntreg = resultado.getString(4);
                miLista.add(new Entregables(TipoEntreg, CorrEntreg, DesEntreg, DesCortaEntreg));
            }
        } catch (SQLException ex) {
        } finally {
            acceso.close();
        }
        return miLista;
    }

    @Override
    public String insertar(Entregables nuevo) {
        String rpta = "Insercion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "INSERT INTO Entregables VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);

            comando.setString(1, String.valueOf(nuevo.getTipoEntreg()));
            comando.setString(2, String.valueOf(nuevo.getCorrEntreg()));
            comando.setString(3, nuevo.getDesEntreg());
            comando.setString(4, nuevo.getDesCortaEntreg());

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

    @Override
    public String actualizar(Entregables actualizacion) {
        String rpta = "Actualizacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "UPDATE Entregables SET TipoEntreg=?,CorrEntreg=?,DesEntreg=?,DesCortaEntreg=?  WHERE TipoEntreg = '"
                + actualizacion.getTipoEntreg() + "'";//Lucho revisa ese where si esta bien pq no entiendo la BD del profe :v
        try {

            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            comando.setString(1, String.valueOf(actualizacion.getTipoEntreg()));
            comando.setString(2, String.valueOf(actualizacion.getCorrEntreg()));
            comando.setString(3, actualizacion.getDesEntreg());
            comando.setString(4, actualizacion.getDesCortaEntreg());
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
    public String eliminar(int TipoEntreg) {
        String rpta = "Eliminacion Completada";
        DAOConnection acceso = DAOConnection.getInstance();
        String sql = "DELETE FROM Entregables WHERE TipoEntreg = ?";//Lucho revisa este where si esta bien pq no entiendo la BD del profe :v

        try {

            PreparedStatement comando = acceso.getConexion().prepareStatement(sql);
            comando.setInt(1, TipoEntreg);
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
