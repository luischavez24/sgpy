/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.views;

import edu.unmsm.sistemas.sgpy.entities.Entregables;
import edu.unmsm.sistemas.sgpy.entities.Estado;
import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;
import edu.unmsm.sistemas.sgpy.entities.TipoDoc;
import edu.unmsm.sistemas.sgpy.entities.TipoEntreg;
import edu.unmsm.sistemas.sgpy.repository.TipoEntregDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.EntregablesDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.EstadoDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.FaseDAO;
import edu.unmsm.sistemas.sgpy.repository.imple.NivelDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.PytoDocsDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.TipoDocDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.TipoEntregDAOImple;
import edu.unmsm.sistemas.sgpy.views.util.TableModelCreator;
import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lucho
 */
public class FrmPytoDocs extends javax.swing.JFrame {

    private String rutaDocumento;
    private TipoEntreg objTipoEntreg;
    private TipoDoc objTipoDoc;
    private Nivel objNivel;
    private Fase objFase;
    private Estado objEstado;
    private Entregables objEntregables;
    
    public FrmPytoDocs() {
        initComponents();

        llenarTabla(PytoDocsDAOImple.getInstance().listar());
        configurarSpinners(spnFInicio, "dd/MM/yy");
        configurarSpinners(spnFFin, "dd/MM/yy");
        llenarCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOps = new javax.swing.JPopupMenu();
        btnDetalles = new javax.swing.JMenuItem();
        btnActualizarDocs = new javax.swing.JMenuItem();
        btnEliminarDocs = new javax.swing.JMenuItem();
        background = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        btnInsertarDoc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarDocs = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnMantenimiento = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mainPane = new javax.swing.JLayeredPane();
        panelBuscar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocs = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        caja_busqueda = new javax.swing.JTextField();
        btnQuery = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        panelInsertar = new javax.swing.JPanel();
        panelSubida = new javax.swing.JPanel();
        btnSubDoc = new javax.swing.JButton();
        lbObservaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        lbVersion = new javax.swing.JLabel();
        txtVersion = new javax.swing.JTextField();
        lbRuta = new javax.swing.JLabel();
        panelDatosPyto = new javax.swing.JPanel();
        cmbProyecto = new javax.swing.JComboBox<>();
        lbProyecto = new javax.swing.JLabel();
        lbFase = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lbFInicio = new javax.swing.JLabel();
        lbFFin = new javax.swing.JLabel();
        lbCostoEstimado = new javax.swing.JLabel();
        txtCostoEstimado = new javax.swing.JTextField();
        lbTEntregable = new javax.swing.JLabel();
        cmbTEntregable = new javax.swing.JComboBox<>();
        lbEspecialista = new javax.swing.JLabel();
        cmbEspecialista = new javax.swing.JComboBox<>();
        cmbResponsable = new javax.swing.JComboBox<>();
        lbResponsable = new javax.swing.JLabel();
        chkVigencia = new javax.swing.JCheckBox();
        spnFInicio = new javax.swing.JSpinner();
        spnFFin = new javax.swing.JSpinner();
        lbCostoEstimado1 = new javax.swing.JLabel();
        cmbTDoc = new javax.swing.JComboBox<>();
        header1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelMantenimiento = new javax.swing.JPanel();
        header2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelSeleccion = new javax.swing.JPanel();
        btnTipoEntreg = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnTipoDoc = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnNivel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnFase = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnEstado = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnEntregables = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        panelSoporte = new javax.swing.JPanel();
        TPaneTipoEntreg = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        TPaneTipoDoc = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        TPaneNivel = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jTextField9 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        TPaneFase = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        TPaneEntregables = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jTextField18 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jLabel70 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton29 = new javax.swing.JButton();
        TPaneEstado = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jTextField16 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel58 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();

        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        menuOps.add(btnDetalles);

        btnActualizarDocs.setText("Actualizar");
        menuOps.add(btnActualizarDocs);

        btnEliminarDocs.setText("Eliminar");
        menuOps.add(btnEliminarDocs);

        menuOps.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Documentos del Proyecto");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBar.setBackground(new java.awt.Color(57, 73, 171));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertarDoc.setBackground(new java.awt.Color(57, 73, 171));
        btnInsertarDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInsertarDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertarDocMouseExited(evt);
            }
        });
        btnInsertarDoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnInsertarDoc.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar Documento");
        btnInsertarDoc.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        sideBar.add(btnInsertarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 260, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SGPY");
        sideBar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 48));
        sideBar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 180, 10));

        btnBuscarDocs.setBackground(new java.awt.Color(57, 73, 171));
        btnBuscarDocs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarDocsMouseExited(evt);
            }
        });
        btnBuscarDocs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar Documento");
        btnBuscarDocs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscarDocs.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        sideBar.add(btnBuscarDocs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 260, -1));

        btnMantenimiento.setBackground(new java.awt.Color(57, 73, 171));
        btnMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseExited(evt);
            }
        });
        btnMantenimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/conf.png"))); // NOI18N
        btnMantenimiento.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mantenimiento");
        btnMantenimiento.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 140, 48));

        sideBar.add(btnMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 260, -1));

        background.add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 600));

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setLayout(new java.awt.CardLayout());

        panelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        panelBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tablaDocs.setAutoCreateRowSorter(true);
        tablaDocs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaDocs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDocs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaDocs.setColumnSelectionAllowed(true);
        tablaDocs.setComponentPopupMenu(menuOps);
        tablaDocs.setGridColor(new java.awt.Color(255, 255, 255));
        tablaDocs.setRowHeight(25);
        tablaDocs.setSelectionBackground(new java.awt.Color(92, 107, 192));
        tablaDocs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaDocs.setSurrendersFocusOnKeystroke(true);
        tablaDocs.getTableHeader().setResizingAllowed(false);
        tablaDocs.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDocs);
        tablaDocs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablaDocs.getColumnModel().getColumnCount() > 0) {
            tablaDocs.getColumnModel().getColumn(3).setResizable(false);
        }

        panelBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 920, 390));

        header.setBackground(new java.awt.Color(159, 168, 218));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Documentos");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        caja_busqueda.setBackground(new java.awt.Color(159, 168, 218));
        caja_busqueda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        caja_busqueda.setForeground(new java.awt.Color(255, 255, 255));
        caja_busqueda.setBorder(null);
        header.add(caja_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 620, 29));

        btnQuery.setBackground(new java.awt.Color(255, 255, 255));
        btnQuery.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnQuery.setText("Buscar");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });
        header.add(btnQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 180, 40));
        header.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 620, 10));

        panelBuscar.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelBuscar, "card3");

        panelInsertar.setBackground(new java.awt.Color(255, 255, 255));
        panelInsertar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSubida.setBackground(new java.awt.Color(255, 255, 255));
        panelSubida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de subida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSubida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubDoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSubDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Open_25px.png"))); // NOI18N
        btnSubDoc.setText("Seleccione el documento para subirlo");
        btnSubDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubDocActionPerformed(evt);
            }
        });
        panelSubida.add(btnSubDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, 411, 34));

        lbObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbObservaciones.setText("Observaciones");
        panelSubida.add(lbObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 143, 411, 28));

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtObs.setRows(5);
        jScrollPane2.setViewportView(txtObs);

        panelSubida.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, 411, 188));

        lbVersion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbVersion.setText("Version");
        panelSubida.add(lbVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 112, 118, 30));

        txtVersion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVersionActionPerformed(evt);
            }
        });
        panelSubida.add(txtVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 112, 289, 30));

        lbRuta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelSubida.add(lbRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 71, 411, 30));

        panelInsertar.add(panelSubida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 450, 390));

        panelDatosPyto.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosPyto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelDatosPyto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbProyecto.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));
        panelDatosPyto.add(cmbProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 31, 312, 30));

        lbProyecto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbProyecto.setText("Proyecto");
        panelDatosPyto.add(lbProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, 118, 30));

        lbFase.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFase.setText("Estado Proyecto");
        panelDatosPyto.add(lbFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 67, 118, 30));

        cmbEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 67, 312, 30));

        lbFInicio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFInicio.setText("Fecha de Inicio");
        panelDatosPyto.add(lbFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 108, 118, 30));

        lbFFin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFFin.setText("Fecha de Fin");
        panelDatosPyto.add(lbFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 149, 118, 30));

        lbCostoEstimado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado.setText("Costo Estimado");
        panelDatosPyto.add(lbCostoEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, 118, 30));

        txtCostoEstimado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCostoEstimado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoEstimadoActionPerformed(evt);
            }
        });
        panelDatosPyto.add(txtCostoEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 193, 132, -1));

        lbTEntregable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTEntregable.setText("Entregable");
        panelDatosPyto.add(lbTEntregable, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 234, 118, 30));

        cmbTEntregable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto.add(cmbTEntregable, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 234, 312, 30));

        lbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbEspecialista.setText("Especialista");
        panelDatosPyto.add(lbEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 276, 118, 30));

        cmbEspecialista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbEspecialista.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));
        panelDatosPyto.add(cmbEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 276, 312, 30));

        cmbResponsable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbResponsable.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));
        panelDatosPyto.add(cmbResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 312, 312, 30));

        lbResponsable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbResponsable.setText("Responsable");
        panelDatosPyto.add(lbResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 312, 118, 30));

        chkVigencia.setBackground(new java.awt.Color(255, 255, 255));
        chkVigencia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkVigencia.setText("¿Esta vigente?");
        chkVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVigenciaActionPerformed(evt);
            }
        });
        panelDatosPyto.add(chkVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 349, 312, -1));

        spnFInicio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto.add(spnFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 108, 312, 30));

        spnFFin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto.add(spnFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 149, 312, 30));

        lbCostoEstimado1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado1.setText("Tipo");
        panelDatosPyto.add(lbCostoEstimado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 196, -1, -1));

        cmbTDoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto.add(cmbTDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 190, 132, 30));

        panelInsertar.add(panelDatosPyto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 470, 390));

        header1.setBackground(new java.awt.Color(159, 168, 218));
        header1.setForeground(new java.awt.Color(255, 255, 255));
        header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresar Documentos");
        header1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        btnIngresar.setBackground(new java.awt.Color(57, 73, 171));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_25px.png"))); // NOI18N
        btnIngresar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ingresar");
        btnIngresar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 110, 48));

        header1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 200, -1));

        panelInsertar.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelInsertar, "card2");

        panelMantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        panelMantenimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header2.setBackground(new java.awt.Color(159, 168, 218));
        header2.setForeground(new java.awt.Color(255, 255, 255));
        header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mantenimiento");
        header2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        panelMantenimiento.add(header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        panelSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        panelSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione una Tabla de Soporte:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSeleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));
        btnTipoEntreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoEntregMouseClicked(evt);
            }
        });
        btnTipoEntreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tipo de Entregable");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        btnTipoEntreg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnTipoEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 250, 30));

        btnTipoDoc.setBackground(new java.awt.Color(255, 255, 255));
        btnTipoDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoDocMouseClicked(evt);
            }
        });
        btnTipoDoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tipo de Documento");
        btnTipoDoc.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 30));

        btnNivel.setBackground(new java.awt.Color(255, 255, 255));
        btnNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNivelMouseClicked(evt);
            }
        });
        btnNivel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nivel");
        btnNivel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 250, 30));

        btnFase.setBackground(new java.awt.Color(255, 255, 255));
        btnFase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFaseMouseClicked(evt);
            }
        });
        btnFase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Fase");
        btnFase.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, 30));

        btnEstado.setBackground(new java.awt.Color(255, 255, 255));
        btnEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadoMouseClicked(evt);
            }
        });
        btnEstado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Estado");
        btnEstado.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, 30));

        btnEntregables.setBackground(new java.awt.Color(255, 255, 255));
        btnEntregables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregablesMouseClicked(evt);
            }
        });
        btnEntregables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Entregables");
        btnEntregables.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        panelSeleccion.add(btnEntregables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 250, 30));

        panelMantenimiento.add(panelSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 310, 390));
        panelSeleccion.getAccessibleContext().setAccessibleName("Seleccione una Tabla de Soporte");

        panelSoporte.setBackground(new java.awt.Color(255, 255, 255));
        panelSoporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla de Soporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSoporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TPaneTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Tipo de Entregable:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel20.setText("Descripción del Entregable:");

        jLabel21.setText("Vigencia:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        TPaneTipoEntreg.addTab("Registrar", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo Entregable", "Descripcion", "Vigencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable1);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneTipoEntreg.addTab("Gestionar", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setText("Tipo de Entregable:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        jLabel23.setText("Descripción del Entregable:");

        jLabel24.setText("Vigencia:");

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addGap(72, 72, 72)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4)
                    .addComponent(jTextField3)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneTipoEntreg.addTab("Edición", jPanel4);

        panelSoporte.add(TPaneTipoEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 350));

        TPaneTipoDoc.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("Codigo de Documento:");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jLabel27.setText("Descripción del Tipo de Documento:");

        jLabel28.setText("Vigente:");

        jButton5.setText("Registrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4)
                            .addComponent(jScrollPane6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(27, 27, 27)
                .addComponent(jButton5)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        TPaneTipoDoc.addTab("Registrar", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable1= new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo de Documento", "Descripcion Tipo de Documento", "Vigente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable2);

        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneTipoDoc.addTab("Gestionar", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Codigo de Documento:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane8.setViewportView(jTextArea4);

        jLabel30.setText("Descripción del Tipo de Documento:");

        jLabel31.setText("Vigente:");

        jButton8.setText("Editar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jScrollPane8)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(31, 31, 31)
                .addComponent(jButton8)
                .addContainerGap())
        );

        TPaneTipoDoc.addTab("Edición", jPanel6);

        panelSoporte.add(TPaneTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 350));

        TPaneNivel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setText("Codigo de Nivel:");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jLabel34.setText("Descripción del Nivel:");

        jLabel35.setText("Vigente:");

        jButton9.setText("Registrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane9.setViewportView(jTextArea5);

        jLabel36.setText("Fase:");

        jLabel37.setText("Codigo de Fase:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9)
                            .addComponent(jTextField7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Registrar", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTable1= new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de Fase", "Codigo de Nivel", "Descripcion de Nivel", "Fase", "Vigente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(jTable3);

        jButton10.setText("Editar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Eliminar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Gestionar", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setText("Codigo de Fase:");

        jLabel39.setText("Codigo de Nivel:");

        jLabel40.setText("Descripción del Nivel:");

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane11.setViewportView(jTextArea6);

        jLabel41.setText("Fase:");

        jLabel42.setText("Vigente:");

        jButton12.setText("Editar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Edición", jPanel9);

        panelSoporte.add(TPaneNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 350));

        TPaneFase.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setText("Codigo de Fase:");

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });

        jLabel45.setText("Descripción de la Fase:");

        jLabel46.setText("Vigencia:");

        jButton13.setText("Registrar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane12.setViewportView(jTextArea7);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46))
                .addGap(72, 72, 72)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Registrar", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo de Fase", "Descripcion de la fase", "Vigencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(jTable4);

        jButton14.setText("Editar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Eliminar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Gestionar", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("Codigo de Fase:");

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane14.setViewportView(jTextArea8);

        jLabel48.setText("Descripción de la Fase:");

        jLabel49.setText("Vigencia:");

        jButton16.setText("Editar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49))
                .addGap(72, 72, 72)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16)
                    .addComponent(jTextField14)
                    .addComponent(jScrollPane14)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(31, 31, 31)
                .addComponent(jButton16)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Edición", jPanel12);

        panelSoporte.add(TPaneFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 350));

        TPaneEntregables.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel65.setText("Descripción del Entregable:");

        jButton26.setText("Registrar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane18.setViewportView(jTextArea11);

        jLabel66.setText("Descripción Corta del Entregable:");

        jLabel67.setText("Tipo de Entregable:");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton26)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel67))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane18)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Registrar", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jTable1= new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo de Entregable", "Corr Entregable", "Descripcion del Entregable", "Descripcion Corta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(jTable6);

        jButton27.setText("Editar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Eliminar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton27)
                        .addGap(18, 18, 18)
                        .addComponent(jButton28)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28)
                    .addComponent(jButton27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Gestionar", jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setText("Tipo de Entregable:");

        jLabel69.setText("Descripción del Entregablel:");

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jScrollPane20.setViewportView(jTextArea12);

        jLabel70.setText("Descripción corta del Entregable:");

        jButton29.setText("Editar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton29)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane20)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addGap(18, 18, 18)
                .addComponent(jButton29)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Edición", jPanel23);

        TPaneEstado.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setText("Estado del Proyecto:");

        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
        });

        jLabel52.setText("Descripción del Estado:");

        jButton17.setText("Registrar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane15.setViewportView(jTextArea9);

        jLabel53.setText("Vigente:");

        jLabel54.setText("Codigo de Nivel:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton17)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel54))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15)
                            .addComponent(jTextField15)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addGap(33, 33, 33))
        );

        TPaneEstado.addTab("Registrar", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jTable1= new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de Fase", "Codigo de Nivel", "Estado del Proyecto", "Descripcion Estado", "Vigentel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(jTable5);

        jButton18.setText("Editar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Eliminar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton18)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneEstado.addTab("Gestionar", jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setText("Codigo de Nivel:");

        jLabel56.setText("Estado del Proyecto:");

        jLabel57.setText("Descripción del Estado:");

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jScrollPane17.setViewportView(jTextArea10);

        jLabel58.setText("Vigente:");

        jButton20.setText("Editar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton20)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel55)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane17)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addGap(36, 36, 36))
        );

        TPaneEstado.addTab("Edición", jPanel15);

        TPaneEntregables.addTab("tab4", TPaneEstado);

        panelSoporte.add(TPaneEntregables, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 460, 350));

        panelMantenimiento.add(panelSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 480, 390));

        mainPane.add(panelMantenimiento, "card4");

        background.add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 0, 980, 600));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCostoEstimadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoEstimadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoEstimadoActionPerformed

    private void chkVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVigenciaActionPerformed

    private void btnSubDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubDocActionPerformed
        // TODO add your handling code here:
        JFileChooser exploradorArchivos = new JFileChooser(System.getProperty("user.desktop"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        exploradorArchivos.setFileFilter(filtro);
        exploradorArchivos.setMultiSelectionEnabled(false);
        exploradorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        exploradorArchivos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        int opcion = exploradorArchivos.showOpenDialog(this);
        File archivoSeleccionado = exploradorArchivos.getSelectedFile();
        if (archivoSeleccionado != null && opcion == JFileChooser.APPROVE_OPTION) {
            rutaDocumento = archivoSeleccionado.getAbsolutePath();
            lbRuta.setText(rutaDocumento);
        }
    }//GEN-LAST:event_btnSubDocActionPerformed

    private void txtVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVersionActionPerformed

    private void btnInsertarDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseClicked
        // TODO add your handling code here:
        resetCombos();
        llenarCombos();
        panelInsertar.setVisible(true);
        panelBuscar.setVisible(false);
    }//GEN-LAST:event_btnInsertarDocMouseClicked

    private void btnBuscarDocsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseClicked
        // TODO add your handling code here:
        llenarTabla(PytoDocsDAOImple.getInstance().listar());
        panelInsertar.setVisible(false);
        panelBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarDocsMouseClicked

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueryActionPerformed
    //new java.awt.Color(26, 35, 126)
    //new java.awt.Color(57, 73, 171)
    private void btnBuscarDocsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseEntered
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnBuscarDocsMouseEntered

    private void btnBuscarDocsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseExited
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnBuscarDocsMouseExited

    private void btnInsertarDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseEntered
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnInsertarDocMouseEntered

    private void btnInsertarDocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarDocMouseExited
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnInsertarDocMouseExited

    private void btnMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseClicked
        // TODO add your handling code here:
        panelMantenimiento.setVisible(true);
        panelInsertar.setVisible(false);
        panelBuscar.setVisible(false);
    }//GEN-LAST:event_btnMantenimientoMouseClicked

    private void btnMantenimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseEntered
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnMantenimientoMouseEntered

    private void btnMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseExited
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnMantenimientoMouseExited

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        if (rutaDocumento != null) {
            PytoDocs pytoDocs = new PytoDocs();
            pytoDocs.setCodPyto((int) cmbProyecto.getSelectedItem());
            Estado estado = (Estado) cmbEstado.getSelectedItem();
            pytoDocs.setCodFase(estado.getCodFase());
            pytoDocs.setCodNivel(estado.getCodNivel());
            pytoDocs.setEstPyto(estado.getEstPyto());
            pytoDocs.setFecIni((Date) spnFInicio.getModel().getValue());
            pytoDocs.setFecFin((Date) spnFFin.getModel().getValue());
            pytoDocs.setCostoEst(Double.parseDouble(txtCostoEstimado.getText()));
            pytoDocs.setCodDoc(((TipoDoc) cmbTDoc.getSelectedItem()).getCodDoc());
            pytoDocs.setRutaDoc(rutaDocumento);
            pytoDocs.setVerDoc(txtVersion.getText());
            pytoDocs.setObservac(txtObs.getText());
            Entregables entregable = (Entregables) cmbTEntregable.getSelectedItem();
            pytoDocs.setTipoEntreg(entregable.getTipoEntreg());
            pytoDocs.setCorrEntreg(entregable.getCorrEntreg());
            pytoDocs.setCodEsp(1);
            pytoDocs.setCodResp(1);
            pytoDocs.setVigente((chkVigencia.isSelected()) ? "1" : "0");
            String mensaje = PytoDocsDAOImple.getInstance().insertar(pytoDocs);
            JOptionPane.showMessageDialog(rootPane, mensaje);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe elegir un archivo para subir", "No hay archivo de carga", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarMouseClicked

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnTipoEntregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoEntregMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(true);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());
    }//GEN-LAST:event_btnTipoEntregMouseClicked

    private void btnTipoDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoDocMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(true);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());
    }//GEN-LAST:event_btnTipoDocMouseClicked

    private void btnNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(true);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaNivel(NivelDAOImple.getInstance().listar());
        llenarComboNivel();
    }//GEN-LAST:event_btnNivelMouseClicked

    private void btnFaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaseMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(true);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaFase(FaseDAO.getInstance().listar());
    }//GEN-LAST:event_btnFaseMouseClicked

    private void btnEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(true);
        TPaneEntregables.setVisible(false);
        llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());
        llenarComboEstado();
    }//GEN-LAST:event_btnEstadoMouseClicked

    private void btnEntregablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregablesMouseClicked
        // TODO add your handling code here:
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(true);
        llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());
        llenarComboEntregables();
    }//GEN-LAST:event_btnEntregablesMouseClicked

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (!Character.isDigit(jTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Tipo de Entregable debe ser un digito";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Entregable no puede ser vacía";
        } else if (jTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = Integer.parseInt(jTextField1.getText());
            String desEntreg = jTextArea1.getText();
            String vigencia = jTextField2.getText();

            objTipoEntreg = new TipoEntreg(tipoEntreg, desEntreg, vigencia);

            TipoEntregDAOImple.getInstance().insertar(objTipoEntreg);

            jTextField1.setText("");
            jTextArea1.setText("");
            jTextField2.setText("");

            llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) jTable1.getValueAt(fila, 1);
            String desEntreg = String.valueOf(jTable1.getValueAt(fila, 0));
            String vigencia = String.valueOf(jTable1.getValueAt(fila, 2));

            jLabel8.setText(String.valueOf(tipoEntreg));
            jTextArea2.setText(desEntreg);
            jTextField3.setText(vigencia);

            jTextArea2.setEditable(true);
            jTextField3.setEditable(true);

            TPaneTipoEntreg.setEnabledAt(2, true);
            TPaneTipoEntreg.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) jTable1.getValueAt(fila, 1);

            TipoEntregDAOImple.getInstance().eliminar(tipoEntreg);

            llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Entregable no puede ser vacía";
        } else if (jTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = Integer.parseInt(jLabel8.getText());
            String desEntreg = jTextArea2.getText();
            String vigencia = jTextField3.getText();

            objTipoEntreg = new TipoEntreg(tipoEntreg, desEntreg, vigencia);

            TipoEntregDAOImple.getInstance().actualizar(objTipoEntreg);

            llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());

            jLabel8.setText("");
            jTextArea2.setText("");
            jTextField3.setText("");
            jTextArea2.setEditable(false);
            jTextField3.setEditable(false);
            TPaneTipoEntreg.setEnabledAt(2, false);
            TPaneTipoEntreg.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Documento no puede ser vacío";
        } else if (!Character.isDigit(jTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Documento debe ser dos digitos";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Documento no puede ser vacía";
        } else if (jTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoDoc = Integer.parseInt(jTextField1.getText());
            String desTDoc = jTextArea1.getText();
            String vigente = jTextField2.getText();

            objTipoDoc = new TipoDoc(tipoDoc, desTDoc, vigente);

            TipoDocDAOImple.getInstance().insertar(objTipoDoc);

            jTextField1.setText("");
            jTextArea1.setText("");
            jTextField2.setText("");

            llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoDoc = (Integer) jTable1.getValueAt(fila, 0);
            String desTDoc = String.valueOf(jTable1.getValueAt(fila, 1));
            String vigente = String.valueOf(jTable1.getValueAt(fila, 2));

            jLabel8.setText(String.valueOf(tipoDoc));
            jTextArea2.setText(desTDoc);
            jTextField3.setText(vigente);

            jTextArea2.setEditable(true);
            jTextField3.setEditable(true);

            TPaneTipoDoc.setEnabledAt(2, true);
            TPaneTipoDoc.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoDoc = (Integer) jTable1.getValueAt(fila, 0);

            TipoDocDAOImple.getInstance().eliminar(tipoDoc);

            llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Documento no puede ser vacía";
        } else if (jTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoDoc = Integer.parseInt(jLabel8.getText());
            String desTDoc = jTextArea2.getText();
            String vigente = jTextField3.getText();

            objTipoDoc = new TipoDoc(tipoDoc, desTDoc, vigente);

            TipoDocDAOImple.getInstance().actualizar(objTipoDoc);

            llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());

            jLabel8.setText("");
            jTextArea2.setText("");
            jTextField3.setText("");
            jTextArea2.setEditable(false);
            jTextField3.setEditable(false);
            TPaneTipoDoc.setEnabledAt(2, false);
            TPaneTipoDoc.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (jTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (!Character.isDigit(jTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Nivel debe ser dos digitos";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Nivel no puede ser vacía";
        } else if (jTextField4.getText().equals("")) {
            valido = false;
            mensaje = "La fase no puede ser vacía";
        } else if (jTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Fase) jComboBox1.getSelectedItem()).getCodFase();
            int codNivel = Integer.parseInt(jTextField1.getText());
            String desNivel = jTextArea1.getText();
            String fase = jTextField4.getText();
            String vigente = jTextField2.getText();

            objNivel = new Nivel(codFase, codNivel, desNivel, fase, vigente);

            NivelDAOImple.getInstance().insertar(objNivel);

            jComboBox1.setSelectedIndex(-1);
            jTextField1.setText("");
            jTextArea1.setText("");
            jTextField2.setText("");
            jTextField4.setText("");

            llenarTablaNivel(NivelDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);
            int codNivel = (Integer) jTable1.getValueAt(fila, 1);
            String desNivel = String.valueOf(jTable1.getValueAt(fila, 2));
            String fase = String.valueOf(jTable1.getValueAt(fila, 3));
            String vigente = String.valueOf(jTable1.getValueAt(fila, 4));

            jComboBox2.setSelectedItem(-1);
            jLabel16.setText(String.valueOf(codNivel));
            jTextArea3.setText(desNivel);
            jTextField5.setText(fase);
            jTextField6.setText(vigente);

            jComboBox2.setEnabled(true);
            jTextArea3.setEditable(true);
            jTextField5.setEditable(true);
            jTextField6.setEditable(true);

            TPaneNivel.setEnabledAt(2, true);
            TPaneNivel.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);
            int codNivel = (Integer) jTable1.getValueAt(fila, 1);

            //eliminar obj
            NivelDAOImple.getInstance().eliminar(codFase,codNivel);

            llenarTablaNivel(NivelDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (jComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (jTextArea3.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Nivel no puede ser vacía";
        } else if (jTextField5.getText().equals("")) {
            valido = false;
            mensaje = "La fase no puede ser vacía";
        } else if (jTextField6.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Fase) jComboBox2.getSelectedItem()).getCodFase();
            int codNivel = Integer.parseInt(jLabel16.getText());
            String desNivel = jTextArea3.getText();
            String fase = jTextField5.getText();
            String vigente = jTextField6.getText();

            objNivel = new Nivel(codFase, codNivel, desNivel, fase, vigente);

            NivelDAOImple.getInstance().actualizar(objNivel);

            llenarTablaNivel(NivelDAOImple.getInstance().listar());

            jComboBox2.setSelectedIndex(-1);
            jLabel16.setText("");
            jTextArea3.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jComboBox2.setEnabled(false);
            jTextArea3.setEditable(false);
            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
            TPaneNivel.setEnabledAt(2, false);
            TPaneNivel.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (!Character.isDigit(jTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Documento debe ser 1 digito";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion de la Fase no puede ser vacía";
        } else if (jTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = Integer.parseInt(jTextField1.getText());
            String desFase = jTextArea1.getText();
            String vigencia = jTextField2.getText();

            objFase = new Fase(codFase, desFase, vigencia);

            FaseDAO.getInstance().insertar(objFase);

            jTextField1.setText("");
            jTextArea1.setText("");
            jTextField2.setText("");

            llenarTablaFase(FaseDAO.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);
            String desFase = String.valueOf(jTable1.getValueAt(fila, 1));
            String vigencia = String.valueOf(jTable1.getValueAt(fila, 2));

            jLabel8.setText(String.valueOf(codFase));
            jTextArea2.setText(desFase);
            jTextField3.setText(vigencia);

            jTextArea2.setEditable(true);
            jTextField3.setEditable(true);

            TPaneFase.setEnabledAt(2, true);
            TPaneFase.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);

            FaseDAO.getInstance().eliminar(codFase);

            llenarTablaFase(FaseDAO.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (jTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion de la Fase no puede ser vacía";
        } else if (jTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = Integer.parseInt(jLabel8.getText());
            String desFase = jTextArea2.getText();
            String vigencia = jTextField3.getText();

            objFase = new Fase(codFase, desFase, vigencia);

            FaseDAO.getInstance().actualizar(objFase);

            llenarTablaFase(FaseDAO.getInstance().listar());

            jLabel8.setText("");
            jTextArea2.setText("");
            jTextField3.setText("");
            jTextArea2.setEditable(false);
            jTextField3.setEditable(false);
            TPaneFase.setEnabledAt(2, false);
            TPaneFase.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyPressed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (jComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (jTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Estado del Proyecto no puede ser vacío";
        } else if (!Character.isDigit(jTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Estado del Proyecto debe ser dos digitos";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Estado no puede ser vacía";
        } else if (jTextField4.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Nivel) jComboBox1.getSelectedItem()).getCodFase();
            int codNivel = ((Nivel) jComboBox1.getSelectedItem()).getCodNivel();
            int estPyto = Integer.parseInt(jTextField1.getText());
            String desEstado = jTextArea1.getText();
            String vigente = jTextField4.getText();

            objEstado = new Estado(codFase, codNivel, estPyto, desEstado, vigente);

            EstadoDAOImple.getInstance().insertar(objEstado);

            jComboBox1.setSelectedIndex(-1);
            jTextField1.setText("");
            jTextArea1.setText("");
            jTextField4.setText("");

            llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);
            int codNivel = (Integer) jTable1.getValueAt(fila, 1);
            int estPyto = (Integer) jTable1.getValueAt(fila, 3);
            String desEstado = String.valueOf(jTable1.getValueAt(fila, 2));
            String vigente = String.valueOf(jTable1.getValueAt(fila, 4));

            jComboBox2.setSelectedItem(-1);
            jLabel16.setText(String.valueOf(estPyto));
            jTextArea3.setText(desEstado);
            jTextField5.setText(vigente);

            jComboBox2.setEnabled(true);
            jTextArea3.setEditable(true);
            jTextField5.setEditable(true);

            TPaneEstado.setEnabledAt(2, true);
            TPaneEstado.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) jTable1.getValueAt(fila, 0);
            int codNivel = (Integer) jTable1.getValueAt(fila, 1);
            int estPyto = (Integer) jTable1.getValueAt(fila, 3);

            EstadoDAOImple.getInstance().eliminar(codFase, codNivel, estPyto);

            llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (jComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (jTextArea3.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Estado no puede ser vacía";
        } else if (jTextField5.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Nivel) jComboBox2.getSelectedItem()).getCodFase();
            int codNivel = ((Nivel) jComboBox2.getSelectedItem()).getCodNivel();
            int estPyto = Integer.parseInt(jLabel16.getText());
            String desEstado = jTextArea3.getText();
            String vigente = jTextField5.getText();

            objEstado = new Estado(codFase, codNivel, estPyto, desEstado, vigente);

            EstadoDAOImple.getInstance().actualizar(objEstado);

            llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());

            jComboBox2.setSelectedIndex(-1);
            jLabel16.setText("");
            jTextArea3.setText("");
            jTextField5.setText("");
            jComboBox2.setEnabled(false);
            jTextArea3.setEditable(false);
            jTextField5.setEditable(false);
            TPaneEstado.setEnabledAt(2, false);
            TPaneEstado.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (jComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (jTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Entregable no puede ser vacía";
        } else if (jTextField4.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion corta del Entregable no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = ((Nivel) jComboBox1.getSelectedItem()).getCodFase();
            String desEntreg = jTextArea1.getText();
            String desCortaEntreg = jTextField4.getText();

            objEntregables = new Entregables(tipoEntreg, 0, desEntreg, desCortaEntreg);

            EntregablesDAOImple.getInstance().insertar(objEntregables);

            jComboBox1.setSelectedIndex(-1);
            jTextArea1.setText("");
            jTextField4.setText("");

            llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) jTable1.getValueAt(fila, 3);
            int corrEntreg = (Integer) jTable1.getValueAt(fila, 0);
            String desEntreg = String.valueOf(jTable1.getValueAt(fila, 2));
            String desCortaEntreg = String.valueOf(jTable1.getValueAt(fila, 1));

            jComboBox2.setSelectedItem(-1);
            jTextArea3.setText(desEntreg);
            jTextField5.setText(desCortaEntreg);

            jComboBox2.setEnabled(true);
            jTextArea3.setEditable(true);
            jTextField5.setEditable(true);

            TPaneEntregables.setEnabledAt(2, true);
            TPaneEntregables.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) jTable1.getValueAt(fila, 3);
            int corrEntreg = (Integer) jTable1.getValueAt(fila, 0);

            EntregablesDAOImple.getInstance().eliminar(tipoEntreg,corrEntreg);

            llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (jComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (jTextArea3.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Entregable no puede ser vacía";
        } else if (jTextField5.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion corta del Entregable no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = ((Nivel) jComboBox2.getSelectedItem()).getCodFase();
            String desEntreg = jTextArea3.getText();
            String desCortaEntreg = jTextField5.getText();

            objEntregables = new Entregables(tipoEntreg, 0, desEntreg, desCortaEntreg);

            EntregablesDAOImple.getInstance().actualizar(objEntregables);

            llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());

            jComboBox2.setSelectedIndex(-1);
            jTextArea3.setText("");
            jTextField5.setText("");
            jComboBox2.setEnabled(false);
            jTextArea3.setEditable(false);
            jTextField5.setEditable(false);
            TPaneEntregables.setEnabledAt(2, false);
            TPaneEntregables.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

    }//GEN-LAST:event_jLabel13MouseClicked

    private void hoverOn(JPanel boton, Color color) {
        boton.setBackground(color);
    }

    private void hoverOff(JPanel boton, Color color) {

        boton.setBackground(color);
    }

    private void configurarSpinners(JSpinner timeSpinner, String dateFormat) {
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, dateFormat);
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // will only show the current time
    }

    private void llenarTabla(List<PytoDocsView> listaDocs) {
        TableModel modeloTabla = TableModelCreator.createTableModel(PytoDocsView.class, listaDocs);
        tablaDocs.setModel(modeloTabla);
    }
    
    public void llenarTablaTipoEntreg(List<TipoEntreg> lista) {
        jTable1.setModel(TableModelCreator.createTableModel(TipoEntreg.class, lista));
    }
    
    public void llenarTablaTipoDoc(List<TipoDoc> lista) {
        jTable2.setModel(TableModelCreator.createTableModel(TipoDoc.class, lista));
    }
    
    public void llenarTablaNivel(List<Nivel> lista) {
        jTable3.setModel(TableModelCreator.createTableModel(Nivel.class, lista));
    }
    
    public void llenarTablaFase(List<Fase> lista) {
        jTable4.setModel(TableModelCreator.createTableModel(Fase.class, lista));
    }
    
    public void llenarTablaEstado(List<Estado> lista) {
        jTable5.setModel(TableModelCreator.createTableModel(Estado.class, lista));
    }
    
    public void llenarTablaEntregables (List<Entregables > lista) {
        jTable6.setModel(TableModelCreator.createTableModel(Entregables .class, lista));
    }

    private void llenarCombos() {
        EstadoDAOImple.getInstance().listarEntity().forEach((item) -> cmbEstado.addItem(item));
        EntregablesDAOImple.getInstance().listar().forEach((Entregables item) -> cmbTEntregable.addItem(item));
        TipoDocDAOImple.getInstance().listar().forEach((item) -> cmbTDoc.addItem(item));
    }
    
    private void llenarComboNivel() {
        FaseDAO.getInstance().listar().forEach((item) -> jComboBox1.addItem(item));
        FaseDAO.getInstance().listar().forEach((item) -> jComboBox2.addItem(item));
    }
    
    private void llenarComboEstado() {
        NivelDAOImple.getInstance().listar().forEach((item) -> jComboBox3.addItem(item));
        NivelDAOImple.getInstance().listar().forEach((item) -> jComboBox4.addItem(item));
    }
    
    public void llenarComboEntregables() {
        TipoEntregDAOImple.getInstance().listarEntity().forEach((item) -> jComboBox5.addItem(item));
        TipoEntregDAOImple.getInstance().listarEntity().forEach((item) -> jComboBox6.addItem(item));
    }


    private void resetCombos() {
        cmbEstado.removeAllItems();
        cmbTEntregable.removeAllItems();
        cmbTDoc.removeAllItems();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TPaneEntregables;
    private javax.swing.JTabbedPane TPaneEstado;
    private javax.swing.JTabbedPane TPaneFase;
    private javax.swing.JTabbedPane TPaneNivel;
    private javax.swing.JTabbedPane TPaneTipoDoc;
    private javax.swing.JTabbedPane TPaneTipoEntreg;
    private javax.swing.JPanel background;
    private javax.swing.JMenuItem btnActualizarDocs;
    private javax.swing.JPanel btnBuscarDocs;
    private javax.swing.JMenuItem btnDetalles;
    private javax.swing.JMenuItem btnEliminarDocs;
    private javax.swing.JPanel btnEntregables;
    private javax.swing.JPanel btnEstado;
    private javax.swing.JPanel btnFase;
    private javax.swing.JPanel btnIngresar;
    private javax.swing.JPanel btnInsertarDoc;
    private javax.swing.JPanel btnMantenimiento;
    private javax.swing.JPanel btnNivel;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSubDoc;
    private javax.swing.JPanel btnTipoDoc;
    private javax.swing.JPanel btnTipoEntreg;
    private javax.swing.JTextField caja_busqueda;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JComboBox<Integer> cmbEspecialista;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.JComboBox<Integer> cmbProyecto;
    private javax.swing.JComboBox<Integer> cmbResponsable;
    private javax.swing.JComboBox<TipoDoc> cmbTDoc;
    private javax.swing.JComboBox<Entregables> cmbTEntregable;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<Fase> jComboBox1;
    private javax.swing.JComboBox<Fase> jComboBox2;
    private javax.swing.JComboBox<Nivel> jComboBox3;
    private javax.swing.JComboBox<Nivel> jComboBox4;
    private javax.swing.JComboBox<TipoEntreg> jComboBox5;
    private javax.swing.JComboBox<TipoEntreg> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbCostoEstimado;
    private javax.swing.JLabel lbCostoEstimado1;
    private javax.swing.JLabel lbEspecialista;
    private javax.swing.JLabel lbFFin;
    private javax.swing.JLabel lbFInicio;
    private javax.swing.JLabel lbFase;
    private javax.swing.JLabel lbObservaciones;
    private javax.swing.JLabel lbProyecto;
    private javax.swing.JLabel lbResponsable;
    private javax.swing.JLabel lbRuta;
    private javax.swing.JLabel lbTEntregable;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JLayeredPane mainPane;
    private javax.swing.JPopupMenu menuOps;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatosPyto;
    private javax.swing.JPanel panelInsertar;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JPanel panelSoporte;
    private javax.swing.JPanel panelSubida;
    private javax.swing.JPanel sideBar;
    private javax.swing.JSpinner spnFFin;
    private javax.swing.JSpinner spnFInicio;
    private javax.swing.JTable tablaDocs;
    private javax.swing.JTextField txtCostoEstimado;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
