
package edu.unmsm.sistemas.sgpy.Persona.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.unmsm.sistemas.sgpy.Persona.vista.*;
import edu.unmsm.sistemas.sgpy.Persona.modelo.*;
/**
 *
 * @author Branco
 */
public class ControladorCrudPersonaTics implements ActionListener{
    JFModificarMedioCom vistaCRUD1 = new JFModificarMedioCom();
    JFAgregarMedioCom vistaCRUD2 = new JFAgregarMedioCom();
    PersonaTicsDAO modeloCRUD =new PersonaTicsDAO();
    PersonaDAO modeloCRUD1=new PersonaDAO();
    TicsDAO modeloCRUD2=new TicsDAO();
    
    public ControladorCrudPersonaTics(JFAgregarMedioCom vistaCRUD2,PersonaTicsDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD2 = vistaCRUD2;
        this.vistaCRUD2.botonRegistrar.addActionListener(this);
        this.vistaCRUD2.VisualizarPersona1.addActionListener(this);
        this.vistaCRUD2.VisualizarTic1.addActionListener(this);
    }
    
    public ControladorCrudPersonaTics(JFModificarMedioCom vistaCRUD1,PersonaTicsDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD1 = vistaCRUD1;
        this.vistaCRUD1.BotonModificar.addActionListener(this);
        this.vistaCRUD1.VisualizarPersona.addActionListener(this);
        this.vistaCRUD1.VisualizarTic.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vistaCRUD2.botonRegistrar){
            int CodPersona = Integer.parseInt(vistaCRUD2.jTextFieldCodPersona1.getText());
            int CodTic = Integer.parseInt(vistaCRUD2.jTextFieldCodTic1.getText());
            String DesMedio = vistaCRUD2.jTextFieldDescripcion1.getText().trim();
            String Vigente = String.valueOf(vistaCRUD2.ComboVigencia1.getSelectedIndex());
            String rptaRegistro = new String();
            rptaRegistro = modeloCRUD.insertarPersonaTics(CodPersona, CodTic, DesMedio, Vigente);
            
            if(rptaRegistro!=null){
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Registro erroneo. ");
                    }
        }
        
        if(e.getSource() == vistaCRUD1.BotonModificar){
            int CodPersona = Integer.parseInt(vistaCRUD1.jTextFieldCodPersona.getText());
            int CodTic = Integer.parseInt(vistaCRUD1.jTextFieldCodTic.getText());
            String DesMedio = vistaCRUD1.jTextFieldDescripcion.getText().trim();
            String Vigente = String.valueOf(vistaCRUD1.ComboVigencia.getSelectedIndex());
            String rptaRegistro = new String();
            rptaRegistro = modeloCRUD.modificarPersonaTics(CodPersona, CodTic, DesMedio, Vigente);
            
            if(rptaRegistro!=null){
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Registro erroneo. ");
                    }
        }
        
        if(e.getSource() == vistaCRUD1.VisualizarPersona){
            vistaCRUD1.aux=modeloCRUD1.listPersona();
            vistaCRUD1.modelo1= new DefaultTableModel();
            String[] cabecera={"Codigo","DNI","Cargo"};
            String[][] datos = new String[vistaCRUD1.aux.size()][3];
            for (int i = 0; i < vistaCRUD1.aux.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD1.aux.get(i).getCodPers());
                datos[i][1] = String.valueOf(vistaCRUD1.aux.get(i).getDNI());
                datos[i][2] = String.valueOf(vistaCRUD1.aux.get(i).getCargo());
            }
            vistaCRUD1.modelo1 = new DefaultTableModel(datos, cabecera);
            vistaCRUD1.jTablePersonaTics.setModel(vistaCRUD1.modelo1);
        }
        
        if(e.getSource() == vistaCRUD2.VisualizarPersona1){
            vistaCRUD2.aux=modeloCRUD1.listPersona();
            vistaCRUD2.modelo3= new DefaultTableModel();
            String[] cabecera={"Codigo","DNI","Cargo"};
            String[][] datos = new String[vistaCRUD2.aux.size()][3];
            for (int i = 0; i < vistaCRUD2.aux.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD2.aux.get(i).getCodPers());
                datos[i][1] = String.valueOf(vistaCRUD2.aux.get(i).getDNI());
                datos[i][2] = String.valueOf(vistaCRUD2.aux.get(i).getCargo());
            }
            vistaCRUD2.modelo3 = new DefaultTableModel(datos, cabecera);
            vistaCRUD2.jTablePersonaTics1.setModel(vistaCRUD2.modelo3);
        }
        
        if(e.getSource() == vistaCRUD1.VisualizarTic){
            vistaCRUD1.aux1=modeloCRUD2.listTics();
            vistaCRUD1.modelo2= new DefaultTableModel();
            String[] cabecera={"CodTic","Descripcion"};
            String[][] datos = new String[vistaCRUD1.aux1.size()][3];
            for (int i = 0; i < vistaCRUD1.aux1.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD1.aux1.get(i).getCodTics());
                datos[i][1] = String.valueOf(vistaCRUD1.aux1.get(i).getDesTics());
            }
            vistaCRUD1.modelo2 = new DefaultTableModel(datos, cabecera);
            vistaCRUD1.jTableTicPersona.setModel(vistaCRUD1.modelo2);
        }
        
        if(e.getSource() == vistaCRUD2.VisualizarTic1){
            vistaCRUD2.aux1=modeloCRUD2.listTics();
            vistaCRUD2.modelo4= new DefaultTableModel();
            String[] cabecera={"CodTic","Descripcion"};
            String[][] datos = new String[vistaCRUD2.aux1.size()][3];
            for (int i = 0; i < vistaCRUD2.aux1.size(); i++) {
                datos[i][0] = String.valueOf(vistaCRUD2.aux1.get(i).getCodTics());
                datos[i][1] = String.valueOf(vistaCRUD2.aux1.get(i).getDesTics());
            }
            vistaCRUD2.modelo4 = new DefaultTableModel(datos, cabecera);
            vistaCRUD2.jTableTicPersona1.setModel(vistaCRUD2.modelo4);
        }
    }
}
