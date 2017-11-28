package edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Profesional;

import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesional;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.PersonaDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionalDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Principal.I_MenuProfesional;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class I_EliminarProfesional extends javax.swing.JFrame {

    Profesional pr = null;
    ProfesionalDAO prf = new ProfesionalDAO();
    ResultSet rs;
    ProfesionDAO prof = new ProfesionDAO();
    PersonaDAO per = new PersonaDAO();

    public I_EliminarProfesional() {
        initComponents();
        this.setSize(486, 520);
        this.setTitle("Eliminar Profesional");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnEliminar.setEnabled(false);
    }

    public Profesional BuscarProfesional(String codigo) {
        boolean bandera = false;
        Profesional pf = new Profesional();
        try {

            rs = prf.BuscarProfesional(codigo);
            while (rs.next()) {
                pf.setNomPers(rs.getString(1));
                pf.setNomEmpresa(rs.getString(2));
                pf.setDesProf(rs.getString(3));
                pf.setNroCIP(rs.getString(4));
                pf.setUniversidad(rs.getString(5));
                pf.setVigente(rs.getString(6));
                bandera = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (!bandera) {
            return null;
        } else {
            return pf;
        }

    }

    /*public Profesional BuscarProfesional(String codigo) throws Exception{
          boolean bandera=false;
          Profesional pf=new Profesional();
          rs=prf.BuscarProfesional(codigo);
          while(rs.next()){
                    pf.setNomPers(rs.getString(1));
                    pf.setNomEmpresa(rs.getString(2));
                    pf.setDesProf(rs.getString(3));
                    pf.setNroCIP(rs.getString(4));
                    pf.setUniversidad(rs.getString(5));
                    bandera=true;                
           }
           
           if(!bandera){
               return null;
           }
           else{
               
               return pf;
           }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo_BotonesE = new javax.swing.ButtonGroup();
        ListaDespelgable = new javax.swing.JPopupMenu();
        RegistrarProfesional = new javax.swing.JMenuItem();
        ModificarProfesional = new javax.swing.JMenuItem();
        BuscarProfesional = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCIP = new javax.swing.JTextField();
        btnCancelarM = new javax.swing.JButton();
        btnSalirM = new javax.swing.JButton();
        txtUniversidad = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtNombreProfesion = new javax.swing.JTextField();

        RegistrarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoAgregarProfesional.png"))); // NOI18N
        RegistrarProfesional.setText("Registrar Profesional");
        RegistrarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarProfesionalActionPerformed(evt);
            }
        });
        ListaDespelgable.add(RegistrarProfesional);

        ModificarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoModificarProfesional.png"))); // NOI18N
        ModificarProfesional.setText("Modificar Profesional");
        ModificarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarProfesionalActionPerformed(evt);
            }
        });
        ListaDespelgable.add(ModificarProfesional);

        BuscarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoBuscar.png"))); // NOI18N
        BuscarProfesional.setText("Buscar Profesional");
        BuscarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProfesionalActionPerformed(evt);
            }
        });
        ListaDespelgable.add(BuscarProfesional);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Profesional", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setComponentPopupMenu(ListaDespelgable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Ingrese código:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoBuscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Nombre:");

        txtNombrePersona.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Nombre Empresa:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Nombre de Profesion");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("NRO CIP:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Universidad:");

        txtCIP.setEditable(false);

        btnCancelarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoCancelar.png"))); // NOI18N
        btnCancelarM.setText("CANCELAR");
        btnCancelarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMActionPerformed(evt);
            }
        });

        btnSalirM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoSalir.png"))); // NOI18N
        btnSalirM.setText("SALIR");
        btnSalirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMActionPerformed(evt);
            }
        });

        txtUniversidad.setEditable(false);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoEliminarProfesional.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNombreEmpresa.setEditable(false);

        txtNombreProfesion.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCIP, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtUniversidad, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtNombreEmpresa)
                    .addComponent(txtNombreProfesion))
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalirM)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtNombreProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtCIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelarM)
                    .addComponent(btnSalirM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        prf.Eliminar(pr);
        txtNombrePersona.setText("");
        txtNombreEmpresa.setText("");
        txtNombreProfesion.setText("");
        txtCIP.setText("");
        txtUniversidad.setText("");
        JOptionPane.showMessageDialog(rootPane, "Se eliminó con éxito", "MENSAJE DE CONFIRMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void RegistrarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarProfesionalActionPerformed
        I_RegistrarProfesional a;
        try {
            a = new I_RegistrarProfesional();
            a.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(I_EliminarProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_RegistrarProfesionalActionPerformed

    private void ModificarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarProfesionalActionPerformed
        I_ModificarProfesional a;
        try {
            a = new I_ModificarProfesional();
            a.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(I_EliminarProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_ModificarProfesionalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene el codigo a Buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pr = BuscarProfesional(txtBuscar.getText());
            } catch (Exception ex) {
                Logger.getLogger(I_ModificarProfesional.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtBuscar.setText("");
            if (pr != null) {
                if (pr.getVigente().equals("1")) {
                    btnEliminar.setEnabled(true);
                    txtNombrePersona.setText(pr.getNomPers());
                    txtNombreEmpresa.setText(pr.getNomEmpresa());
                    txtNombreProfesion.setText(pr.getDesProf());
                    txtCIP.setText(pr.getNroCIP());
                    txtUniversidad.setText(pr.getUniversidad());
                } else {
                    JOptionPane.showMessageDialog(null, "Persona No Habilitada", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "PERSONA NO ENCONTRADA", "NOTIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMActionPerformed
        int resultado = JOptionPane.showConfirmDialog(rootPane, "Está seguro de cancelar esta operación?", "MENSAJE DE CONFIRMACIÓN", JOptionPane.CANCEL_OPTION);
        if (resultado == 0) {
        }
    }//GEN-LAST:event_btnCancelarMActionPerformed

    private void btnSalirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMActionPerformed
        new I_MenuProfesional().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMActionPerformed

    private void BuscarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProfesionalActionPerformed
        I_BusquedaProfesion bp = new I_BusquedaProfesion();
        bp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BuscarProfesionalActionPerformed

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
            java.util.logging.Logger.getLogger(I_EliminarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(I_EliminarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(I_EliminarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(I_EliminarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new I_EliminarProfesional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BuscarProfesional;
    private javax.swing.ButtonGroup Grupo_BotonesE;
    private javax.swing.JPopupMenu ListaDespelgable;
    private javax.swing.JMenuItem ModificarProfesional;
    private javax.swing.JMenuItem RegistrarProfesional;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarM;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalirM;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCIP;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNombreProfesion;
    private javax.swing.JTextField txtUniversidad;
    // End of variables declaration//GEN-END:variables
}
