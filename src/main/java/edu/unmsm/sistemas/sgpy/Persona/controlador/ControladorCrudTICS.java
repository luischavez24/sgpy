
package edu.unmsm.sistemas.sgpy.Persona.controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import edu.unmsm.sistemas.sgpy.Persona.vista.*;
import edu.unmsm.sistemas.sgpy.Persona.modelo.*;
/**
 *
 * @author Branco
 */
public class ControladorCrudTICS implements ActionListener{
    TicsDAO modeloCRUD = new TicsDAO();
    JFAgregarTics vistaTic1 = new JFAgregarTics();
    JFModificarTics vistaTic2 = new JFModificarTics();
    JFEliminarTics vistaTic3 = new JFEliminarTics();
    JFVisualizarTics vistaTic4 = new JFVisualizarTics();
    
    public ControladorCrudTICS(JFAgregarTics vistaTic1,TicsDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaTic1 = vistaTic1;
        this.vistaTic1.btnRegistrarTics.addActionListener(this);
    }
    
    public ControladorCrudTICS(JFModificarTics vistaTic2,TicsDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaTic2 = vistaTic2;
        this.vistaTic2.btnMostrarTics.addActionListener(this);
        this.vistaTic2.btnBusquedaTics.addActionListener(this);
        this.vistaTic2.btnGuardarTics.addActionListener(this);
    }
    
    public ControladorCrudTICS(JFEliminarTics vistaTic3,TicsDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaTic3 = vistaTic3;
        this.vistaTic3.btnMostrarTics.addActionListener(this);
        this.vistaTic3.btnBusquedaTics.addActionListener(this);
        this.vistaTic3.btnEliminarTics.addActionListener(this);
    }
    
    public ControladorCrudTICS(JFVisualizarTics vistaTic4,TicsDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaTic4 = vistaTic4;
        this.vistaTic4.btnMostrarTics.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaTic1.btnRegistrarTics){
            String desTics = vistaTic1.textDescripcionTics.getText();
            String vigente = String.valueOf(vistaTic1.comboVigenciaTics.getSelectedIndex());
            FileInputStream archivo = vistaTic1.archivo;
            int longitudBytes = vistaTic1.longitudBytes;
            String rptaRegistro = modeloCRUD.insertarTics(desTics, vigente, archivo, longitudBytes);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo. ");
            }
        }
        if(e.getSource() == vistaTic2.btnMostrarTics){
            vistaTic2.Tics = modeloCRUD.listTics();
            vistaTic2.modelo = new DefaultListModel();
            for (int i = 0; i < vistaTic2.Tics.size(); i++) {
                vistaTic2.modelo.addElement(vistaTic2.Tics.get(i).getDesTics());              
            }
            vistaTic2.listaTics.setModel(vistaTic2.modelo);
        }
        if(e.getSource() == vistaTic2.btnBusquedaTics){
            vistaTic2.Tics = modeloCRUD.listTics();
            for (int i = 0; i < vistaTic2.Tics.size(); i++) {
                if(vistaTic2.radioPorNombre.isSelected()){
                    if (vistaTic2.Tics.get(i).getDesTics().toUpperCase().equals(vistaTic2.textCodigoTics.getText().toUpperCase())) {
                        vistaTic2.textDescripcionTics.setText(vistaTic2.Tics.get(i).getDesTics());
                        vistaTic2.textVigenciaTics.setEditable(true);
                        if(vistaTic2.Tics.get(i).getVigencia().equals("1")){
                            vistaTic2.textVigenciaTics.setText("Vigente");
                        }
                        else{
                            vistaTic2.textVigenciaTics.setText("No vigente");
                        }
                        vistaTic2.textVigenciaTics.setEditable(false);
                        ImageIcon promo = new ImageIcon(vistaTic2.Tics.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaTic2.labelIconoTics.getWidth(), vistaTic2.labelIconoTics.getHeight(), Image.SCALE_DEFAULT));
                        vistaTic2.labelIconoTics.setIcon(icono);
                        vistaTic2.posicion = i; 
                        break;
                    }
                }
                if(vistaTic2.radioPorCodigo.isSelected()){
                    if (vistaTic2.Tics.get(i).getCodTics() == Integer.parseInt(vistaTic2.textCodigoTics.getText())) {
                        vistaTic2.textDescripcionTics.setText(vistaTic2.Tics.get(i).getDesTics());
                        vistaTic2.textVigenciaTics.setEditable(true);
                        if(vistaTic2.Tics.get(i).getVigencia().equals("1")){
                            vistaTic2.textVigenciaTics.setText("Vigente");
                        }
                        else{
                            vistaTic2.textVigenciaTics.setText("No vigente");
                        }
                        vistaTic2.textVigenciaTics.setEditable(false);
                        ImageIcon promo = new ImageIcon(vistaTic2.Tics.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaTic2.labelIconoTics.getWidth(), vistaTic2.labelIconoTics.getHeight(), Image.SCALE_DEFAULT));
                        vistaTic2.labelIconoTics.setIcon(icono);
                        vistaTic2.posicion = i;
                        break;
                    }
                }
            }
        }
        if(e.getSource() == vistaTic2.btnGuardarTics){
            try{
                if(!vistaTic2.textCodigoTics.getText().isEmpty() && !vistaTic2.textDescripcionTics.getText().isEmpty() && !vistaTic2.textVigenciaTics.getText().isEmpty()){
                    int cod = vistaTic2.Tics.get(vistaTic2.posicion).getCodTics();
                    String des = vistaTic2.textDescripcionTics.getText();
                    String vigencia = String.valueOf(vistaTic2.comboVigenciaTics.getSelectedIndex());
                    String rptaModificar = modeloCRUD.modificarTics(cod, des, vigencia);
                    if (rptaModificar != null) {
                        JOptionPane.showMessageDialog(null, rptaModificar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Modificación erronea. ");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Falta llenar algún campo. ");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Datos mal ingresados.");
            }
        }
        if(e.getSource() == vistaTic3.btnMostrarTics){
            vistaTic3.Tics = modeloCRUD.listTics();
            vistaTic3.modelo = new DefaultListModel();
            for (int i = 0; i < vistaTic3.Tics.size(); i++) {
                vistaTic3.modelo.addElement(vistaTic3.Tics.get(i).getDesTics());              
            }
            vistaTic3.listaTics.setModel(vistaTic3.modelo);
        }
        if(e.getSource() == vistaTic3.btnBusquedaTics){
            vistaTic3.Tics = modeloCRUD.listTics();
            for (int i = 0; i < vistaTic3.Tics.size(); i++) {
                if(vistaTic3.radioPorNombre.isSelected()){
                    if (vistaTic3.Tics.get(i).getDesTics().toUpperCase().equals(vistaTic3.textCodigoTics.getText().toUpperCase())) {
                        vistaTic3.textDescripcionTics.setEditable(true);
                        vistaTic3.textVigenciaTics.setEditable(true);
                        vistaTic3.textDescripcionTics.setText(vistaTic3.Tics.get(i).getDesTics());
                        vistaTic3.textVigenciaTics.setEditable(true);
                        if(vistaTic3.Tics.get(i).getVigencia().equals("1")){
                            vistaTic3.textVigenciaTics.setText("Vigente");
                        }
                        else{
                            vistaTic3.textVigenciaTics.setText("No vigente");
                        }
                        vistaTic3.textDescripcionTics.setEditable(false);
                        vistaTic3.textVigenciaTics.setEditable(false);
                        ImageIcon promo = new ImageIcon(vistaTic3.Tics.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaTic3.labelIconoTics.getWidth(), vistaTic3.labelIconoTics.getHeight(), Image.SCALE_DEFAULT));
                        vistaTic3.labelIconoTics.setIcon(icono);
                        vistaTic3.posicion = i;
                        break;
                    }
                }
                if(vistaTic3.radioPorCodigo.isSelected()){
                    if (vistaTic3.Tics.get(i).getCodTics() == Integer.parseInt(vistaTic3.textCodigoTics.getText())) {
                        vistaTic3.textDescripcionTics.setEditable(true);
                        vistaTic3.textVigenciaTics.setEditable(true);
                        vistaTic3.textDescripcionTics.setText(vistaTic3.Tics.get(i).getDesTics());
                        vistaTic3.textVigenciaTics.setEditable(true);
                        if(vistaTic3.Tics.get(i).getVigencia().equals("1")){
                            vistaTic3.textVigenciaTics.setText("Vigente");
                        }
                        else{
                            vistaTic3.textVigenciaTics.setText("No vigente");
                        }
                        vistaTic3.textDescripcionTics.setEditable(false);
                        vistaTic3.textVigenciaTics.setEditable(false);
                        ImageIcon promo = new ImageIcon(vistaTic3.Tics.get(i).getBytesLeidos());
                        ImageIcon icono = new ImageIcon(promo.getImage().getScaledInstance(vistaTic3.labelIconoTics.getWidth(), vistaTic3.labelIconoTics.getHeight(), Image.SCALE_DEFAULT));
                        vistaTic3.labelIconoTics.setIcon(icono);
                        vistaTic3.posicion = i;
                        break;
                    }
                }
            }
        }
        if(e.getSource() == vistaTic3.btnEliminarTics){
            if(!vistaTic3.textCodigoTics.getText().isEmpty()){
                int cod = vistaTic3.Tics.get(vistaTic3.posicion).getCodTics();
                String rptaEliminar = modeloCRUD.eliminarTics(cod);
                if (rptaEliminar != null) {
                    JOptionPane.showMessageDialog(null, rptaEliminar);
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación erronea. ");
                }
            }
        }
        if(e.getSource() == vistaTic4.btnMostrarTics){
            vistaTic4.Tics = modeloCRUD.listTics();
            vistaTic4.modelo = new DefaultListModel();
            for (int i = 0; i < vistaTic4.Tics.size(); i++) {
                vistaTic4.modelo.addElement(vistaTic4.Tics.get(i).getDesTics());              
            }
            vistaTic4.listaTics.setModel(vistaTic4.modelo);
        }

    }
}

