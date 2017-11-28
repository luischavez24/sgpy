/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Empresa;

import edu.unmsm.sistemas.sgpy.ProfYExp.Conexion.Conexion;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Principal.I_MenuPrincipal;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Profesional.I_BusquedaProfesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Joselyn CCanto
 */
public class FrameListarEmpresas extends javax.swing.JFrame {

    DefaultTableModel modeloTabla;
    int cont = 0;

    public FrameListarEmpresas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        comboEmpresa.addItem("Elija");
        agregarCombo();
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Codigo Persona");
        modeloTabla.addColumn("Des. Persona");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Des.Corta");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Hobby");
        modeloTabla.addColumn("Nro. CIP");
        modeloTabla.addColumn("fecha Venc. CIP");
        modeloTabla.addColumn("Cargo");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboEmpresa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelProf = new javax.swing.JLabel();
        btnSalirM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboEmpresa.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        comboEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEmpresaActionPerformed(evt);
            }
        });
        comboEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboEmpresaKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        labelProf.setBackground(new java.awt.Color(255, 255, 255));
        labelProf.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        labelProf.setText("Elija la empresa:");
        labelProf.setOpaque(true);

        btnSalirM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalirM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoSalir.png"))); // NOI18N
        btnSalirM.setText("SALIR");
        btnSalirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirM)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirM)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboEmpresaKeyPressed

    }//GEN-LAST:event_comboEmpresaKeyPressed

    private void comboEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEmpresaActionPerformed
        //System.out.println(comboEmpresa.getSelectedItem());
        String aux = "";
        if (!comboEmpresa.getSelectedItem().equals("Eliga")) {
            modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Persona");
            modeloTabla.addColumn("Des. Persona");
            modeloTabla.addColumn("DNI");
            modeloTabla.addColumn("Des.Corta");
            modeloTabla.addColumn("Dirección");
            modeloTabla.addColumn("Hobby");
            modeloTabla.addColumn("Nro. CIP");
            modeloTabla.addColumn("fecha Venc. CIP");
            modeloTabla.addColumn("Cargo");
            Object obj[] = new Object[9];
            JTable tabla_buscar = null;
            Connection connection;
            try {
                connection = Conexion.getConnection();
                try (CallableStatement consulta = connection.prepareCall("{CALL EMPRESA.empleados_empresa(?,?)}")) {
                    aux = comboEmpresa.getSelectedItem().toString();
                    consulta.setString(1, aux);
                    consulta.registerOutParameter(2, OracleTypes.CURSOR);
                    consulta.execute();

                    try (ResultSet rs = ((OracleCallableStatement) consulta).getCursor(2)) {
                        while (rs.next()) {
                            obj[0] = rs.getString(1);
                            //obj[1]=rs.getString(2);
                            obj[1] = rs.getString(3);
                            obj[2] = rs.getString(4);
                            obj[3] = rs.getString(5);
                            obj[4] = rs.getString(6);
                            obj[5] = rs.getString(7);
                            obj[6] = rs.getString(8);
                            obj[7] = rs.getString(9);
                            obj[8] = rs.getString(10);
                            modeloTabla.addRow(obj);
                        }
                        cont++;
                        if (cont > 2) {
                            jScrollPane1.getViewport().remove(tabla_buscar);
                        }
                        tabla_buscar = new JTable();
                        tabla_buscar.setModel(modeloTabla);
                        jScrollPane1.setViewportView(tabla_buscar);

                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(I_BusquedaProfesion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_comboEmpresaActionPerformed

    private void btnSalirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMActionPerformed
        new I_MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMActionPerformed
    public void agregarCombo() {
        Object obj[] = new Object[9];
        JTable tabla_buscar;
        Connection connection;
        try {
            connection = Conexion.getConnection();
            try (CallableStatement consulta = connection.prepareCall("{CALL EMPRESA.listar_empresas(?)}")) {
                consulta.registerOutParameter(1, OracleTypes.CURSOR);
                consulta.execute();

                try (ResultSet rs = ((OracleCallableStatement) consulta).getCursor(1)) {

                    while (rs.next()) {
                        comboEmpresa.addItem(rs.getString(1));

                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameListarEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameListarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameListarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameListarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameListarEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameListarEmpresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalirM;
    private javax.swing.JComboBox comboEmpresa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProf;
    // End of variables declaration//GEN-END:variables
}
