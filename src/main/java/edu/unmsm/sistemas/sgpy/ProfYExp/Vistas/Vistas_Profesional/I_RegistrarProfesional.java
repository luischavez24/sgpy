
package edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Profesional;


import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Profesional.I_ModificarProfesional;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Vistas_Profesional.I_EliminarProfesional;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo.Profesional;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.PersonaDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Modelo_DAO.ProfesionalDAO;
import edu.unmsm.sistemas.sgpy.ProfYExp.Vistas.Principal.I_MenuProfesional;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class I_RegistrarProfesional extends javax.swing.JFrame {

    ResultSet rs;
    ProfesionDAO prof=new ProfesionDAO();
    Profesional pr = new Profesional();
    ProfesionalDAO prf = new ProfesionalDAO();
    PersonaDAO per = new PersonaDAO();
    
    public I_RegistrarProfesional() throws SQLException, Exception {
        initComponents();
        this.setTitle("Registrar Profesional");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(475, 450);
        llenarComboPersona();
        llenarComboProfesion();
        llenarComboEmpresa();
    }
    
    public void llenarComboPersona() throws SQLException{
        rs=per.listarPersonaProfesional();
        while(rs.next()){
           jComboBoxPersona.addItem(rs.getString(1));
        }
    }
    
    public void llenarComboProfesion() throws Exception{
        rs=prof.listarPorVigencia("1");
        String descripcion;
        while(rs.next()){
            descripcion=rs.getString(3);
            jComboBoxProfesion.addItem(descripcion);
        }
    }
    
    public void llenarComboEmpresa() throws SQLException{
        rs=per.listarPersonaCliente();
        while(rs.next()){
            jComboBoxEmpresa.addItem(rs.getString(1));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo_Botones = new javax.swing.ButtonGroup();
        ListaDespelgable = new javax.swing.JPopupMenu();
        ModificarProfesional = new javax.swing.JMenuItem();
        EliminarProfesional = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxProfesion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtCIP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUniversidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jComboBoxPersona = new javax.swing.JComboBox<>();
        jComboBoxEmpresa = new javax.swing.JComboBox<>();
        btnSalirM = new javax.swing.JButton();

        ModificarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoModificarProfesional.png"))); // NOI18N
        ModificarProfesional.setText("Modificar Profesional");
        ModificarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarProfesionalActionPerformed(evt);
            }
        });
        ListaDespelgable.add(ModificarProfesional);

        EliminarProfesional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoEliminarProfesional.png"))); // NOI18N
        EliminarProfesional.setText("Eliminar Profesional");
        EliminarProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProfesionalActionPerformed(evt);
            }
        });
        ListaDespelgable.add(EliminarProfesional);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoBuscar.png"))); // NOI18N
        jMenuItem1.setText("Buscar Profesional");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        ListaDespelgable.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Profesional", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel2.setComponentPopupMenu(ListaDespelgable);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nombre Persona:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Empresa:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Profesión:");

        jComboBoxProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Profesión" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("NRO CIP:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Universidad:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoAgregarProfesional.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoCancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jComboBoxPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Persona" }));

        jComboBoxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Empresa" }));

        btnSalirM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProfYExp/Imagenes/iconoSalir.png"))); // NOI18N
        btnSalirM.setText("SALIR");
        btnSalirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCIP, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalirM)
                                .addGap(15, 15, 15)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalirM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarProfesionalActionPerformed
        I_ModificarProfesional a;
        try {
            a = new I_ModificarProfesional();
            a.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(I_RegistrarProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_ModificarProfesionalActionPerformed

    private void EliminarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProfesionalActionPerformed
        I_EliminarProfesional a = new I_EliminarProfesional();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EliminarProfesionalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Limpiar campos

        int resultado = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de cancelar esta operación?", "MENSAJE DE CONFIRMACIÓN", JOptionPane.CANCEL_OPTION);
        if(resultado==0){
                txtCIP.setText("");
                txtUniversidad.setText("");
                jComboBoxPersona.setSelectedIndex(0);
                jComboBoxEmpresa.setSelectedIndex(0);
                jComboBoxProfesion.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtCIP.getText().equals("")){
            txtCIP.setBackground(Color.red);
        }else{
            txtCIP.setBackground(Color.WHITE);
        }

        if(txtUniversidad.getText().equals("")){
            txtUniversidad.setBackground(Color.red);
        }else{
            txtUniversidad.setBackground(Color.WHITE);
        }

        if((jComboBoxProfesion.getSelectedIndex()==0 || jComboBoxProfesion.getSelectedIndex()==-1)){
            jComboBoxProfesion.setBackground(Color.red);
        }else{
            jComboBoxProfesion.setBackground(Color.WHITE);
        }

        if((jComboBoxPersona.getSelectedIndex()==0 || jComboBoxPersona.getSelectedIndex()==-1)){
            jComboBoxPersona.setBackground(Color.red);
        }else{
            jComboBoxPersona.setBackground(Color.WHITE);
        }

        if((jComboBoxEmpresa.getSelectedIndex()==0 || jComboBoxEmpresa.getSelectedIndex()==-1)){
            jComboBoxEmpresa.setBackground(Color.red);
        }else{
            jComboBoxEmpresa.setBackground(Color.WHITE);
        }

        if(txtCIP.getText().equals("") || txtUniversidad.getText().equals("") ||
            (jComboBoxPersona.getSelectedIndex()==0 || jComboBoxPersona.getSelectedIndex()==-1) ||
            (jComboBoxEmpresa.getSelectedIndex()==0 || jComboBoxEmpresa.getSelectedIndex()==-1) ||
            (jComboBoxProfesion.getSelectedIndex()==0 || jComboBoxProfesion.getSelectedIndex()==-1)
        ){
            JOptionPane.showMessageDialog(null,"Complete campos señalados","Advertencia",JOptionPane.WARNING_MESSAGE);
        }else{

            txtCIP.setBackground(Color.WHITE);
            txtUniversidad.setBackground(Color.WHITE);
            jComboBoxPersona.setBackground(Color.WHITE);
            jComboBoxEmpresa.setBackground(Color.WHITE);
            jComboBoxProfesion.setBackground(Color.WHITE);
            pr.setNomPers(jComboBoxPersona.getSelectedItem().toString());
            pr.setNomEmpresa(jComboBoxEmpresa.getSelectedItem().toString());
            pr.setDesProf(jComboBoxProfesion.getSelectedItem().toString());
            pr.setNroCIP(txtCIP.getText());
            pr.setUniversidad(txtUniversidad.getText());
            pr.setVigente("1");
            prf.Insertar(pr);
            JOptionPane.showMessageDialog(null,"Profesional Registrado","Registrar",JOptionPane.INFORMATION_MESSAGE);
            txtCIP.setText("");
            txtUniversidad.setText("");
            jComboBoxPersona.setSelectedIndex(0);
            jComboBoxEmpresa.setSelectedIndex(0);
            jComboBoxProfesion.setSelectedIndex(0);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        I_BusquedaProfesion bp=new I_BusquedaProfesion();
        bp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnSalirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMActionPerformed
        new I_MenuProfesional().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMActionPerformed

    
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
            java.util.logging.Logger.getLogger(I_RegistrarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(I_RegistrarProfesional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new I_RegistrarProfesional().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(I_RegistrarProfesional.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EliminarProfesional;
    private javax.swing.ButtonGroup Grupo_Botones;
    private javax.swing.JPopupMenu ListaDespelgable;
    private javax.swing.JMenuItem ModificarProfesional;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalirM;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JComboBox<String> jComboBoxPersona;
    private javax.swing.JComboBox<String> jComboBoxProfesion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCIP;
    private javax.swing.JTextField txtUniversidad;
    // End of variables declaration//GEN-END:variables
}
