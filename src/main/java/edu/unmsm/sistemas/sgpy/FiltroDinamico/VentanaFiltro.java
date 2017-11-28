/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.FiltroDinamico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn; 


/**
 *
 * @author Yshara
 */
public class VentanaFiltro extends javax.swing.JFrame {
    Connection cone;
    public ArrayList<Tabla> tablas=new ArrayList<>();
    public int indice_tabla=0;
    public ArrayList<PanelFiltro> paneles;
    public String nombre_tabla_seleccionada="";
    
    private ArrayList<String> consultas = new ArrayList<String>();
    private ArrayList<String> columnas = new ArrayList<String>();
    
    DefaultTableModel modelo= new DefaultTableModel();
    
    
    //variable de apoyo
    boolean aux=false;
    public DefaultTableModel tabla;
    public int ancho;
    
    //estado de la conexion
    boolean conexion;
    String EsquemaBD="";
    String contraseña="";
    public VentanaFiltro() {
        initComponents();
        setTitle("FILTRO DINÁMICO");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //INICIAR TABLA
        iniciar_tabla();
        ancho=930;
        //LLENAR FILTROS
        llenar_filtro();
        llenar_combobox();
        
//        llenar_columnas();
//        llenar_datos();
//        crear_filtro();
        
        aux=true;
        
        
//        consultaBD("select *from "+nombre_tabla_seleccionada);
        
        
        this.setExtendedState(MAXIMIZED_BOTH);
        //JOptionPane.showMessageDialog(null, "configure la conexion en: menu configuracion ", "importante", JOptionPane.WARNING_MESSAGE);
        opciones_graficas();
        

    }
    public void opciones_graficas(){
        VconfigBD.getContentPane().setBackground(new Color(204,204,255));
    }
    public void ventanaConexion(){
        VconfigBD.setVisible(true);
        VconfigBD.setSize(500, 300);
        VconfigBD.setLocationRelativeTo(null);
    }
    
    public void iniciar_tabla(){
        tabla=(DefaultTableModel) tabla_resultados.getModel();
    }
    
    public void llenar_filtro(){
        
        tablas.add(new Tabla("PROYECTO", "PROYECTO"));
        tablas.add(new Tabla("CLIENTE","CLIENTE"));
        tablas.add(new Tabla("DEPARTAMENTO","DEPARTAMENTO"));
        tablas.add(new Tabla("PROVINCIA","PROVINCIA"));
        tablas.add(new Tabla("DISTRITO","DISTRITO"));
        tablas.add(new Tabla("V_PROYECTO", "VISTA PROYECTO"));
        tablas.add(new Tabla("V_DISTRITO","VISTA DISTRITO"));
        tablas.add(new Tabla("V_PROVINCIA","VISTA PROVINCIA"));
        tablas.add(new Tabla("V_DEPARTAMENTO","VISTA DEPARTAMENTO"));
        
    }
    
    public void llenar_combobox(){
        tablas_a_filtrar.removeAllItems();
        for (int i = 0; i < tablas.size(); i++) {

              tablas_a_filtrar.addItem(tablas.get(i).getAlias());
        }
        nombre_tabla_seleccionada=tablas.get(0).nom_tabla;
    }
    
    public void llenar_columnas(){
        consultaColumnas();
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        
          for(int i=0;i<columnas.size();i++){
              tabla.addColumn(columnas.get(i));
          }
          
          int j=0;
        TableColumn columna;
        int acum=0;
        for(;j<columnas.size();j++){
            columna=tabla_resultados.getColumnModel().getColumn(j);
            if(columnas.get(j).substring(0,2).equals("CO")||columnas.get(j).substring(0,3).equals("VIG")
                    ||columnas.get(j).substring(0,3).equals("EST")||columnas.get(j).substring(0,1).equals("D")||
                    columnas.get(j).substring(0,2).equals("NR")||columnas.get(j).substring(0,1).equals("G")){
                columna.setPreferredWidth(80);
                acum+=80;
            }
            else if(columnas.get(j).substring(0,2).equals("FE")){
                columna.setPreferredWidth(150);
                acum+=150;
            }else
            {
                columna.setPreferredWidth(400);
                acum+=400;
            }
                
            columna.setMaxWidth(500);
            columna.setMinWidth(90); 
          }
                System.out.println(acum);
        System.out.println(ancho);
        if(acum<ancho)
            tabla_resultados.setAutoResizeMode(2);
        else
            tabla_resultados.setAutoResizeMode(0);
    }
    
    public void llenar_datos(){
        tabla.setRowCount(0);
        String[] fila={tablas.get(indice_tabla).nom_tabla};
        tabla.addRow(fila);
    }
    
    public void crear_filtro(){
        int tamaño=columnas.size();
        JPanel panel=new JPanel();
        if(tamaño>15){
            panel.setLayout(new GridLayout(columnas.size(),1));
        }else{
            panel.setLayout(null);
        }
        paneles=new ArrayList<>();
        int contador=0;
        int altura=40;
        
        for (int i = 0; i < tamaño; i++) {
            PanelFiltro p=new PanelFiltro(columnas.get(i),false,"");
            p.setBounds(0, contador,jScrollPane2.getWidth()-5,altura);
            p.setVisible(true);
            paneles.add(p);
            panel.add(p);
            contador+=altura;
        }
        jScrollPane2.setViewportView(panel);
//        JPanel panel=new JPanel();
//        panel.setLayout(new GridLayout(columnas.size(),1));
//        paneles=new ArrayList<>();
//        
//        for (int i = 0; i < columnas.size(); i++) {
//            PanelFiltro p=new PanelFiltro(columnas.get(i),false,"");
//            p.setVisible(true);
//            paneles.add(p);       
//            panel.add(p);
//        }
//        jScrollPane2.setViewportView(panel);
    }
    public void consultaBD(String consulta){
        try { 
            
            PreparedStatement pst = cone.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            limpiar_tabla();//limpiar la tabla antes de mostrar nuevos resultados
            //todas las filas de la consulta se almacenan en rs, y se hace un while para recorrer todas las filas
            while(rs.next()){
                  //guarda datos de una fila en un arreglo auxiliar
                  
                  String[] fila = new String[columnas.size()];
                  for(int i=0;i<columnas.size();i++){
                      fila[i]=rs.getString(columnas.get(i));
                  }
                  modelo.addRow(fila);
                  
            }
        } catch(Exception err){
            err.printStackTrace();
            JOptionPane.showMessageDialog(null, err);
        }
        
    }
    public void consultaColumnas(){
        columnas.clear();
        try { 
            
            PreparedStatement pst = cone.prepareStatement("select column_name from all_tab_columns where table_name = '"+nombre_tabla_seleccionada+"' and owner='"+EsquemaBD.toUpperCase()+"'");
            System.out.println("select column_name from all_tab_columns where table_name = '"+nombre_tabla_seleccionada+"' and owner='"+EsquemaBD.toUpperCase()+"'");
            ResultSet rs = pst.executeQuery();
            
            //todas las filas de la consulta se almacenan en rs, y se hace un while para recorrer todas las filas
            while(rs.next()){
                 columnas.add(rs.getString("column_name"));
            }
        } catch(Exception err){err.printStackTrace();}
        
        
    }
    public void limpiar_tabla(){
        modelo=(DefaultTableModel) tabla_resultados.getModel();
        modelo.setRowCount(0);
        tabla_resultados.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VconfigBD = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoEsquema = new javax.swing.JPasswordField();
        campoContraseña = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        labelBD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_resultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tablas_a_filtrar = new javax.swing.JComboBox<>();
        casilla_filtro_total = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jProvincia = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        configBD = new javax.swing.JMenuItem();

        VconfigBD.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        VconfigBD.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setText("ESQUEMA:");

        jLabel3.setText("CONTRASEÑA:");

        jButton2.setText("Conectar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FiltroDinamico/bd.png"))); // NOI18N

        jLabel4.setText("Configure la conexion antes de empezar ...");

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VconfigBDLayout = new javax.swing.GroupLayout(VconfigBD.getContentPane());
        VconfigBD.getContentPane().setLayout(VconfigBDLayout);
        VconfigBDLayout.setHorizontalGroup(
            VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VconfigBDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VconfigBDLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoEsquema, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(campoContraseña)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VconfigBDLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(labelBD))
        );
        VconfigBDLayout.setVerticalGroup(
            VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VconfigBDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoEsquema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(VconfigBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
            .addComponent(labelBD)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        tabla_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_resultados);

        jLabel1.setText("Buscar en:");

        tablas_a_filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proyecto", "Persona" }));
        tablas_a_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablas_a_filtrarActionPerformed(evt);
            }
        });

        casilla_filtro_total.setBackground(new java.awt.Color(204, 204, 255));
        casilla_filtro_total.setText("coincidir todos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FiltroDinamico/buscar_opt.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tablas_a_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(casilla_filtro_total)
                        .addGap(127, 127, 127)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2))
                .addGap(46, 46, 46))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(casilla_filtro_total)
                    .addComponent(tablas_a_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(27, 27, 27))
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 255));

        jMenu7.setText("Aplicacion");
        jMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu7ActionPerformed(evt);
            }
        });

        jMenuItem1.setBackground(new java.awt.Color(204, 0, 0));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Ver Mapa");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Mapa de Proyectos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Proyecto");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Cliente");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Departamento");
        jMenuBar1.add(jMenu3);

        jProvincia.setText("Provincia");
        jMenuBar1.add(jProvincia);

        jMenu4.setText("Distrito");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Configuración");

        configBD.setText("Base de Datos");
        configBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBDActionPerformed(evt);
            }
        });
        jMenu5.add(configBD);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("=================================================");
        System.out.println("FILTRANDO "+nombre_tabla_seleccionada/*tablas.get(indice_tabla).nom_tabla*/+" POR:");
        ArrayList nomb_tabla=new ArrayList();
        ArrayList filtro_nom = new ArrayList();
        
        ArrayList filas=new ArrayList();
        for (int i = 0; i < paneles.size(); i++) {
            PanelFiltro p=paneles.get(i);
            p.guardar_datos();
            if(p.estado){
                System.out.println(p.nombre+": "+p.valor);
                filtro_nom.add(p.nombre);
                filas.add(p.valor);
            }
            nomb_tabla.add(p.nombre);
        }
        

        //aqui se obtiene la consulta
        
        String consulta="Select "+nomb_columnas(nomb_tabla)+" from "+nombre_tabla_seleccionada+where_like(filas,filtro_nom);
        
        
        System.out.println(consulta);
        consultaBD(consulta);
        
        
        //consultar("select * from Departamento where coddpto='001' or coddpto='002'");
        System.out.println("=================================================");
    }//GEN-LAST:event_jButton1ActionPerformed
    public String where_like(ArrayList lista,ArrayList lista2){
        String columnas=" where ";
        
        if(casilla_filtro_total.isSelected()){
           for(int i=0;i<lista.size(); i++){
                columnas+=lista2.get(i)+" like '%"+lista.get(i)+"%' and ";        
            } 
            columnas=columnas.substring(0, columnas.length()-4);
        }else{
            for(int i=0;i<lista.size(); i++){
                columnas+=lista2.get(i)+" like '%"+lista.get(i)+"%' or ";        
            }
            columnas=columnas.substring(0, columnas.length()-3);
        }
        
        
        
        return columnas;
    }
    public String nomb_columnas(ArrayList lista){
        String columnas="";
        for(int i=0;i<lista.size(); i++){
            columnas+=lista.get(i)+",";        
        }
        columnas=columnas.substring(0, columnas.length()-1);
        return columnas;
    }
    private void tablas_a_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablas_a_filtrarActionPerformed
            
        
        if(aux){
            indice_tabla=tablas_a_filtrar.getSelectedIndex();
            nombre_tabla_seleccionada=tablas.get(indice_tabla).nom_tabla;
            System.out.println(nombre_tabla_seleccionada);
            llenar_columnas();
            llenar_datos();
            crear_filtro();
            consultaBD("select *from "+nombre_tabla_seleccionada);
       }
        
    }//GEN-LAST:event_tablas_a_filtrarActionPerformed

    private void configBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBDActionPerformed
        System.out.println("config BD");
        VconfigBD.setVisible(true);
        VconfigBD.pack();
        VconfigBD.setTitle("CONFIGURAR BASE DE DATOS");
        VconfigBD.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_configBDActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
       
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        cone = Conexion.conectarbd2(campoEsquema.getText(), campoContraseña.getText());
        EsquemaBD=campoEsquema.getText();
        contraseña=campoContraseña.getText();
        VconfigBD.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu7ActionPerformed
        System.out.println("se cerro");
    }//GEN-LAST:event_jMenu7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VentanaMapaProyectos ventMapa = new VentanaMapaProyectos(cone);
        ventMapa.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        VconfigBD.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaFiltro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaFiltro().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog VconfigBD;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JPasswordField campoEsquema;
    private javax.swing.JCheckBox casilla_filtro_total;
    private javax.swing.JMenuItem configBD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jProvincia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBD;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabla_resultados;
    private javax.swing.JComboBox<String> tablas_a_filtrar;
    // End of variables declaration//GEN-END:variables
}
