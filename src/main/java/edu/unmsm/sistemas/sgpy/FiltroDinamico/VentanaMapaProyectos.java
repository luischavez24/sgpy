/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.FiltroDinamico;


import edu.unmsm.sistemas.sgpy.FiltroDinamico.Conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F20LAB303-XXE
 */
public class VentanaMapaProyectos extends javax.swing.JFrame {
    
    //PARA EL FILTRO
    public ArrayList<Filtro> filtro=new ArrayList<>();
    //
    
    URL url=getClass().getResource("/FiltroDinamico/mapa.png");
    Image imagen=new ImageIcon(url).getImage();
    
    private final Mapa contenedor = new Mapa(this);
    Connection cone;
    //Proyectos
    private Proyecto[] proyectos={new Proyecto(138,"MODULO DE AULAS COLEGIO INTEGRADO N° 0588",0),
                                   new Proyecto(425,"CONSTRUCCIÓN AULAS COLEGIO ESTATAL FRANCISCO IZQUIERDO RÍOS",1),
                                   new Proyecto(427,"CONSTRUCCIÓN AULAS COLEGIO ESTATAL INTEGRADO N° 0771",0),
                                   new Proyecto(132,"CONSTRUCCIÓN PUENTE PEATONAL AGUAS TERMALES",3),
                                   new Proyecto(162,"SISTEMA DE AGUA POTABLE PARA EL SECTOR ALTO LEGUIA",0),
                                   new Proyecto(205,"RENOVACIÓN RED SECUNDARIA PISAGUA - URUBAMBA",2),
                                   new Proyecto(95,"MEJORAMIENTO DEL TRAMO CARRETERO CCACHO CRUZ- CCAPI",3),
                                   new Proyecto(265,"MEJORAMIENTO Y AMPLIACIÓN DEL SISTEMA DE AGUA POTABLE YURACYACU",2),
                                   new Proyecto(184,"PROYECTO. MEJORAMIENTO DE INFRAESTRUCTURA DE RIEGO ",1),
                                   new Proyecto(126,"CONSTRUCCION CARRETERA SAN FERNANDO - INCAHUASI - SAN MARTIN",1),
                                   new Proyecto(127,"ASFALTADO CARRETERA CEBADAPATA-ACOMAYO",4),
                                   new Proyecto(182,"CONSTRUCCIÓN CARRETERA HUAROCOYOC - TAHUAY",4)
                                };
    
    //variables auxiliares para las consultas en SQL
    G_filtro control = new G_filtro();
    String departamento="", provincia="", distrito="", vigencia="";
    
    
    
    public void act_departamento(ArrayList<String> lista){
        for(int i=0;i<lista.size();i++){
            comboDep.addItem(lista.get(i));
        }
        control.reiniciar_lista();
    }
    public void act_provincia(ArrayList<String> lista){
        for(int i=0;i<lista.size();i++){
//            comboProv.addItem(lista.get(i));
        }
        control.reiniciar_lista();
    }
    public void act_distrito(ArrayList<String> lista){
        
        for(int i=0;i<lista.size();i++){
//            comboDis.addItem(lista.get(i));
        }
        control.reiniciar_lista();
    }
           
  
    public VentanaMapaProyectos(Connection cone) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("MAPA DE PROYECTOS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        this.cone=cone;
        contenedor.setBounds(0, 0, 500, getContentPane().getHeight()+10);
        add(contenedor);
//        seleccionarDepartamento("Cualquiera","Cualquiera");
        opciones_graficas(); //opciones graficas de la ventana
        
        //Bases de datos
        act_departamento(control.cargar_departamento()); //cargar todos los departamentos
//        control.reiniciar_lista(); // reiniciar lista de la clase G_filtro
        
        opciones_graficas(); //opciones graficas de la ventana
        

    }
    public void opciones_graficas(){
        
        comboDep.addItem("Cualquiera");

    }
    public void paint(Graphics g){
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }
    
    public Icon icono(String ruta){
        URL url=getClass().getResource(ruta);
        ImageIcon image=new ImageIcon(url);
        Icon icono=new ImageIcon(image.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH));
        return icono;
    }
    
    public void seleccionarDepartamento(String dep,String filtro) throws SQLException{ 
        
        filtrarPorDepartamento(dep.toUpperCase());
    }
    private void filtrarPorDepartamento(String dpto)  {
        DefaultTableModel modelo=(DefaultTableModel) tablaPyto.getModel();
        modelo.setRowCount(0);
        tablaPyto.removeAll();
        
        try{
            String consulta ="select p.codpyto, p.nompyto from proyecto p, departamento d where d.coddpto=p.coddpto and d.desdpto like '%"+dpto+"%'";


            PreparedStatement pst = cone.prepareStatement(consulta);
//            pst.setString(1,"%"+dpto+"%");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                String fila[]={rs.getString("codpyto"),rs.getString("nompyto")};
                modelo.addRow(fila);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    private void filtroGeneral(){
        
    }
    private void filtrarTabla(int num,String filtro){
//        System.out.println("se ha selccionado: "+filtro+"NUMERO: "+String.valueOf(num));
        DefaultTableModel modelo=(DefaultTableModel) tablaPyto.getModel();
        modelo.setRowCount(0);
        tablaPyto.removeAll();
        
        if(num!=-1){
            for (int i = 0; i < proyectos.length; i++) {
                if(num!=100){
                    if(proyectos[i].departamento==num){
                        switch(filtro){
                            case "Cualquiera":
                                String[] fila={proyectos[i].codigo+"",proyectos[i].nombre};
                                modelo.addRow(fila);
                                break;
                            case "Código":
                                if(proyectos[i].codigo==Integer.parseInt(campoDep.getText())){
                                    String[] fila1={proyectos[i].codigo+"",proyectos[i].nombre};
                                    modelo.addRow(fila1);
                                }break;
                        }
                    }
                }else{
                    switch(filtro){
                        case "Cualquiera":
                            String[] fila={proyectos[i].codigo+"",proyectos[i].nombre};
                            modelo.addRow(fila);
                            break;
                        case "Código":
                            if(proyectos[i].codigo==Integer.parseInt(campoDep.getText())){
                                String[] fila1={proyectos[i].codigo+"",proyectos[i].nombre};
                                modelo.addRow(fila1);
                            }
                            break;
                    }
                }
            }
        }
    }
    
    public void llenarComboDepartamento(){
        
    }
    public void llenarComboProvincia(){
        
    }
    public void llenarComboDistrito(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPyto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboDep = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        campoDep = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaPyto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPyto);
        if (tablaPyto.getColumnModel().getColumnCount() > 0) {
            tablaPyto.getColumnModel().getColumn(0).setMinWidth(100);
            tablaPyto.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("DEPARTAMENTO:");

        comboDep.setToolTipText("");
        comboDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtrar por:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboDep, 0, 202, Short.MAX_VALUE)
                            .addComponent(campoDep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDep)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CERRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepActionPerformed

        if(comboDep.getSelectedIndex()!=0){
            String dep =(String)comboDep.getSelectedItem();
            
            filtrarPorDepartamento(dep.toUpperCase());
            
        }else{
            filtrarPorDepartamento("");
        }
        
        
        
    }//GEN-LAST:event_comboDepActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
        filtrarPorDepartamento(campoDep.getText().toUpperCase());
            
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void filtrar(){
        System.out.println("======================================================");
        System.out.println("FILTRANDO POR:");
        for (int i = 0; i < filtro.size(); i++) {
            System.out.println(filtro.get(i).nombre+" - "+filtro.get(i).valor+" - "+filtro.get(i).estado);
        }
        System.out.println("======================================================");
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField campoDep;
    private javax.swing.JComboBox<String> comboDep;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPyto;
    // End of variables declaration//GEN-END:variables

}
