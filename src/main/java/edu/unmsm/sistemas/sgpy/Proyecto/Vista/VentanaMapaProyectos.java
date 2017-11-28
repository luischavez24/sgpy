/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Proyecto.Vista;

import edu.unmsm.sistemas.sgpy.Proyecto.Logica.BackEnd;
import edu.unmsm.sistemas.sgpy.Proyecto.Clases.Proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import javax.swing.table.*;

/**
 *
 * @author F20LAB303-XXE
 */
public class VentanaMapaProyectos extends javax.swing.JFrame {

    BackEnd Logica = new BackEnd();
    URL url = getClass().getResource("/Proyecto/Imagenes/mapa.png");
    Image imagen = new ImageIcon(url).getImage();
    private final Mapa contenedor = new Mapa(this);
    DefaultTableModel modelo = new DefaultTableModel();
    private String nombDep,codDep,codProv,codDist;
    int busqueda=0; //0 = Busca en todo lugar; 1 = Buscar por Departamento; 2 = Buscar por Provincia; 3 = Buscar por Distrito 
    public VentanaMapaProyectos() {
        initComponents();
        setLocationRelativeTo(null);
        createPopupMenu();
        Object columnas[]={"Codigo","Nombre"};
        modelo.setColumnIdentifiers(columnas);
        tablaProyecto.setModel(modelo);
        tablaProyecto.getColumnModel().getColumn(0).setMaxWidth(80);
        //tablaProyecto.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        nomDep.setEditable(false);
        setLocationRelativeTo(null);
        setTitle("MAPA DE PROYECTOS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        contenedor.setBounds(0, 0, 500, getContentPane().getHeight() + 10);
        add(contenedor);

    }
    
    public void setBusqueda(int valor){
        this.busqueda=valor;
    }
    public void limpiarComboBox(JComboBox caja){
        int tam=caja.getItemCount();
        if(tam>=1){
            for(int i=tam-1;i>=0;i--){
                caja.removeItemAt(i);
            }
        }
    }
    public void cargarComboBox(String nombreDpto) throws SQLException {

        String[] Provincia = Logica.leerProvincias(nombreDpto).split("#"); //Deben existir al menos 1 provincia
        int tam = Provincia.length;
        limpiarComboBox(jCBProvincia);
        for (int i = 0; i < tam; i++) {
            jCBProvincia.addItem(Provincia[i]);
        }

    }
    
    public void cargarComboBoxDistritos() throws SQLException{
        String[] Distrito=Logica.leerDistritos(String.valueOf(jCBProvincia.getSelectedItem()),nomDep.getText()).split("#"); //Deben existir al menos 1 distrito
        int tam=Distrito.length;

        limpiarComboBox(jCBDistrito);

        for(int i=0;i<tam;i++)
            jCBDistrito.addItem(Distrito[i]);

    }

    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }

    public Icon icono(String ruta) {
        URL url = getClass().getResource(ruta);
        ImageIcon image = new ImageIcon(url);
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
        return icono;
    }

    public void desactivarCampoBuscar(){
        campoBuscar.setEnabled(false);
    }
    public int cantidadFilas() {
        return tablaProyecto.getRowCount();
    }

    public void limpiarTabla() {
        //modelo.setRowCount(0);
        int tam=cantidadFilas();
        for (int i = tam-1; i >=0; i--) {
            modelo.removeRow(i);
        }
        //System.out.println("Tabla Limpia");
    }

    public void llenarTablaConFiltrosCompletos(String proy){
        limpiarTabla();
        if(!proy.equals("")){
            String[] primero;

            primero = proy.split("#");

            for (int i = 0; i < primero.length; i++) {
                String[] segundo = new String[2];
                segundo = primero[i].split("-");
                //System.out.println(segundo[0]+"-->"+segundo[1]);
                llenarTabla(segundo);
            }
        }
    }
    public void llenarTabla(String[] primero) {
        Object[] fila = new Object[2];
        fila[0] = primero[0];
        fila[1] = primero[1];
        modelo.addRow(fila);
        
    }
    public void mostrarDep(String nombreDep) { 
        nomDep.setText(nombreDep);
        this.nombDep=nombreDep;
        try{
        codDep=Logica.obtenerCodigoDepartamento(nombreDep);
        }
        catch(Exception ex){
            Logger.getLogger(AgregarFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void mostrarProyectosTabla(String codProyecto) {
        Object[] Proyecto = new Object[13];
        try {
            Proyecto = Logica.recuperarProyecto(codProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMapaProyectos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[2];
        fila[0] = Proyecto[0];
        fila[1] = Proyecto[1];
        modelo.addRow(fila);
    }
    
      private void createPopupMenu() {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem Visualizar = new JMenuItem("Visualizar");
        JMenuItem Modificar = new JMenuItem("Modificar");
        JMenuItem Cancelar = new JMenuItem("Cancelar");
        Visualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              
                System.out.println(tablaProyecto.getSelectedRow());
                
                String codigoProyecto = String.valueOf(tablaProyecto.getValueAt(tablaProyecto.getSelectedRow(),0));
                System.out.println(codigoProyecto);
                 VisualizarFrm visualizar = new VisualizarFrm(codigoProyecto);
                visualizar.setVisible(true);
            }
            
        });
        Modificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigoProyecto = String.valueOf(tablaProyecto.getValueAt(tablaProyecto.getSelectedRow(),0));
                 ModificarFrm modificar = new ModificarFrm(codigoProyecto);
                modificar.setVisible(true);
            }
            
        });
        Cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigoProyecto = String.valueOf(tablaProyecto.getValueAt(tablaProyecto.getSelectedRow(),0));
                 BorrarFrm eliminar = new BorrarFrm(codigoProyecto);
                eliminar.setVisible(true);
            }
            
        });
        popup.add(Visualizar);
        popup.add(Modificar);
        popup.add(Cancelar);
        MouseListener popupListener = new PopupListener(popup);
        tablaProyecto.addMouseListener(popupListener);
    }

    private class PopupListener extends MouseAdapter {
        private JPopupMenu popup;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }
        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if (tablaProyecto.getSelectedRow() != -1) {
                maybeShowPopup(e);
            }
        }
        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProyecto = new javax.swing.JTable();
        nomDep = new javax.swing.JTextField();
        jCBProvincia = new javax.swing.JComboBox<>();
        jCBDistrito = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setText("DEPARTAMENTO:");

        campoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarActionPerformed(evt);
            }
        });
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jButton1.setText("Nuevo Proyecto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        tablaProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tablaProyecto);

        nomDep.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        nomDep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomDep.setText("MAPA DEL PERU");

        jCBProvincia.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jCBProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecionar--" }));
        jCBProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBProvinciaItemStateChanged(evt);
            }
        });

        jCBDistrito.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jCBDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--" }));
        jCBDistrito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBDistritoItemStateChanged(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCBProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jCBDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 467, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased

        try {
            ArrayList<Proyecto> VP;

            switch(busqueda){
                case 0:
                VP=Logica.Buscar_por_nombre_proyecto(campoBuscar.getText());
                break;
                case 1:
                VP=Logica.Buscar_por_nombre_proyecto_Departamento(campoBuscar.getText(),codDep);
                break;
                case 2:
                VP=Logica.Buscar_por_nombre_proyecto_Provincia(campoBuscar.getText(),codDep,codProv);
                break;
                case 3:
                VP=Logica.Buscar_por_nombre_proyecto_Distrito(campoBuscar.getText(),codDep,codProv,codDist);
                break;
                default:
                VP=null;//Nunca debería pasar
                break;
            }

            int i=0;
            String P[]=new String[2];
            limpiarTabla();
            while (i<VP.size()) {
                //p[0]=new Proyecto(rs.getString(0),rs.getString(1));
                //p=new Proyecto(rs.getString(1),rs.getString(2));
                P[0]=VP.get(i).getCodigo_proyecto();
                P[1]=VP.get(i).getNombre_proyecto();

                llenarTabla(P);
                i++;
            }
        } catch (Exception ex) {
            Logger.getLogger(VentanaMapaProyectos.class.getName()).log(Level.SEVERE, null, ex);
            String P[]=new String[2];
            P[0]="no existe";
            P[1]="no existe";
        }

    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void jCBDistritoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBDistritoItemStateChanged
        if(evt.getStateChange()==ItemEvent.DESELECTED){
            try {
                codProv=ObtenerEntero3Cifras(jCBProvincia.getSelectedIndex()+1);
                codDist=ObtenerEntero3Cifras(jCBDistrito.getSelectedIndex()+1);
                String proyecto=Logica.mostrarProyectosPorDistrito(codDep,codProv,codDist);

                llenarTablaConFiltrosCompletos(proyecto);
                setBusqueda(3);
            }
            catch (SQLException ex) {Logger.getLogger(AgregarFrm.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_jCBDistritoItemStateChanged

    private void jCBProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBProvinciaItemStateChanged
        if(evt.getStateChange()==ItemEvent.DESELECTED){
            try {
                codProv=ObtenerEntero3Cifras(jCBProvincia.getSelectedIndex()+1);
                String proyecto=Logica.mostrarProyectosPorPrivincia(codDep,codProv);
                cargarComboBoxDistritos();
                //jCBDistrito.setSelectedIndex(-1);
                setBusqueda(2);
                llenarTablaConFiltrosCompletos(proyecto);
            }
            catch (SQLException ex) {Logger.getLogger(AgregarFrm.class.getName()).log(Level.SEVERE, null, ex);}

        }
    }//GEN-LAST:event_jCBProvinciaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AgregarFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new OpcionesFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private String ObtenerEntero3Cifras(int numero){
        int tam= Integer.toString(numero).length();
        switch (tam){
            case 1: return "00"+Integer.toString(numero);
            case 2: return "0"+Integer.toString(numero);
            case 3: return Integer.toString(numero);
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBDistrito;
    private javax.swing.JComboBox<String> jCBProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomDep;
    private javax.swing.JTable tablaProyecto;
    // End of variables declaration//GEN-END:variables

}
