/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.views;

import edu.unmsm.sistemas.sgpy.controller.PytoDocsController;
import edu.unmsm.sistemas.sgpy.entities.Entregables;
import edu.unmsm.sistemas.sgpy.entities.Estado;
import edu.unmsm.sistemas.sgpy.entities.Fase;
import edu.unmsm.sistemas.sgpy.entities.Nivel;
import edu.unmsm.sistemas.sgpy.entities.PytoDocs;
import edu.unmsm.sistemas.sgpy.entities.PytoDocsView;
import edu.unmsm.sistemas.sgpy.entities.TipoDoc;
import edu.unmsm.sistemas.sgpy.entities.TipoEntreg;
import edu.unmsm.sistemas.sgpy.repository.PytoDocsDAO;
import edu.unmsm.sistemas.sgpy.repository.drive.DriveConnection;
import edu.unmsm.sistemas.sgpy.repository.drive.DriveConstants;
import edu.unmsm.sistemas.sgpy.repository.imple.EntregablesDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.EstadoDAOImple;
import edu.unmsm.sistemas.sgpy.repository.imple.FaseDAOImple;
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
import java.text.SimpleDateFormat;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author lucho
 */
public class FrmPytoDocs extends javax.swing.JFrame {

    private File rutaDocumento;
    private File rutaDocumentoMod;
    private TipoEntreg objTipoEntreg;
    private TipoDoc objTipoDoc;
    private Nivel objNivel;
    private Fase objFase;
    private Estado objEstado;
    private Entregables objEntregables;
    private PytoDocs pytoDocsMod;
    private PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();

    public FrmPytoDocs() {
        initComponents();

        llenarTabla(PytoDocsDAOImple.getInstance().listar());
        configurarSpinners(spnFInicio, "dd/MM/yy");
        configurarSpinners(spnFFin, "dd/MM/yy");
        configurarSpinners(spnFFinMod, "dd/MM/yy");
        llenarCombos();
        icon();
    }

    private void icon() {
        ImageIcon image = new ImageIcon(getClass().getResource("/images/icons8_Document_48px.png"));
        setIconImage(image.getImage());
        setLocationRelativeTo(null);
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        TPaneTipoEntreg = new javax.swing.JTabbedPane();
        RegistrarTipoEntreg = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TipoEntregTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TipoEntregTextArea1 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        TipoEntregTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        GestionarTipoEntreg = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tTipoEntreg = new javax.swing.JTable();
        EdicionTipoEntreg = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        TipoEntregLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TipoEntregTextArea2 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        TipoEntregTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        TPaneTipoDoc = new javax.swing.JTabbedPane();
        RegistrarTipoDoc = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        TipoDocTextField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TipoDocTextArea1 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        TipoDocTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        GestionarTipoDoc = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TipoDocTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        EdicionTipoDoc = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        TipoDocLabel = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TipoDocTextArea2 = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        TipoDocTextField3 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        TPaneNivel = new javax.swing.JTabbedPane();
        RegistrarNivel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        NivelComboBox1 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        NivelTextField1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        NivelTextArea1 = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        NivelTextField2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        NivelTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        GestionarNivel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        NivelTable = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        EdicionNivel = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        NivelComboBox2 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        NivelLabel = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        NivelTextArea2 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        NivelTextField4 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        NivelTextField5 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        TPaneFase = new javax.swing.JTabbedPane();
        RegistrarFase = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        FaseTextField1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        FaseTextArea1 = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        FaseTextField2 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        GestionarFase = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        FaseTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        EdicionFase = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        FaseLabel = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        FaseTextArea2 = new javax.swing.JTextArea();
        jLabel49 = new javax.swing.JLabel();
        FaseTextField3 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        TPaneEstado = new javax.swing.JTabbedPane();
        RegistrarEstado = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        EstadoComboBox1 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        EstadoTextField1 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        EstadoTextArea1 = new javax.swing.JTextArea();
        jLabel53 = new javax.swing.JLabel();
        EstadoTextField2 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        GestionarEstado = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        EstadoTable = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        EdicionEstado = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        EstadoComboBox2 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        EstadoLabel = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        EstadoTextArea2 = new javax.swing.JTextArea();
        jLabel58 = new javax.swing.JLabel();
        EstadoTextField3 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        TPaneEntregables = new javax.swing.JTabbedPane();
        RegistrarEntregables = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        EntregablesComboBox1 = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        EntregablesTextArea1 = new javax.swing.JTextArea();
        jLabel66 = new javax.swing.JLabel();
        EntregablesTextField1 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        GestionarEntregables = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        EntregablesTable = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        EdicionEntregables = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        EntregablesComboBox2 = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        EntregablesTextArea2 = new javax.swing.JTextArea();
        jLabel70 = new javax.swing.JLabel();
        EntregablesTextField2 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        header5 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        panelModificar = new javax.swing.JPanel();
        panelSubida1 = new javax.swing.JPanel();
        btnSubDocMod = new javax.swing.JButton();
        lbObservaciones1 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        txtObsMod = new javax.swing.JTextArea();
        lbVersion1 = new javax.swing.JLabel();
        txtVersionMod = new javax.swing.JTextField();
        lbRuta1 = new javax.swing.JLabel();
        panelDatosPyto1 = new javax.swing.JPanel();
        lbFFin1 = new javax.swing.JLabel();
        lbCostoEstimado2 = new javax.swing.JLabel();
        txtCostoEstimadoMod = new javax.swing.JTextField();
        lbEspecialista1 = new javax.swing.JLabel();
        cmbEspecialistaMod = new javax.swing.JComboBox<>();
        cmbResponsableMod = new javax.swing.JComboBox<>();
        lbResponsable1 = new javax.swing.JLabel();
        chkVigencia1 = new javax.swing.JCheckBox();
        spnFFinMod = new javax.swing.JSpinner();
        lbCostoEstimado3 = new javax.swing.JLabel();
        cmbTDocMod = new javax.swing.JComboBox<>();
        header3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnIngresar1 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        panelDetalles = new javax.swing.JPanel();
        header4 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        txt_obsDocPyto = new javax.swing.JTextArea();
        btn_abrirdoc = new javax.swing.JButton();
        txt_codDocPyto = new javax.swing.JTextField();
        txt_nombDocPyto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txt_nombPyto = new javax.swing.JTextField();
        txt_fasePyto = new javax.swing.JTextField();
        txt_nivelPyto = new javax.swing.JTextField();
        txt_fechaInicPyto = new javax.swing.JTextField();
        txt_fechaFinPyto = new javax.swing.JTextField();
        txt_costoPyto = new javax.swing.JTextField();
        header2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_View_Details_10px.png"))); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        menuOps.add(btnDetalles);

        btnActualizarDocs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Edit_10px.png"))); // NOI18N
        btnActualizarDocs.setText("Actualizar");
        btnActualizarDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDocsActionPerformed(evt);
            }
        });
        menuOps.add(btnActualizarDocs);

        btnEliminarDocs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Trash_10px.png"))); // NOI18N
        btnEliminarDocs.setText("Eliminar");
        btnEliminarDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDocsActionPerformed(evt);
            }
        });
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

        panelSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        panelSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione una Tabla de Soporte:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSeleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTipoEntreg.setBackground(new java.awt.Color(153, 153, 255));
        btnTipoEntreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoEntregMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTipoEntregMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTipoEntregMouseExited(evt);
            }
        });
        btnTipoEntreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo de Entregable");
        btnTipoEntreg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnTipoEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 250, 40));

        btnTipoDoc.setBackground(new java.awt.Color(153, 153, 255));
        btnTipoDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoDocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTipoDocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTipoDocMouseExited(evt);
            }
        });
        btnTipoDoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tipo de Documento");
        btnTipoDoc.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 250, 40));

        btnNivel.setBackground(new java.awt.Color(153, 153, 255));
        btnNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNivelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNivelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNivelMouseExited(evt);
            }
        });
        btnNivel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nivel");
        btnNivel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));

        btnFase.setBackground(new java.awt.Color(153, 153, 255));
        btnFase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFaseMouseExited(evt);
            }
        });
        btnFase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fase");
        btnFase.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 40));

        btnEstado.setBackground(new java.awt.Color(153, 153, 255));
        btnEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstadoMouseExited(evt);
            }
        });
        btnEstado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Estado");
        btnEstado.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 250, 40));

        btnEntregables.setBackground(new java.awt.Color(153, 153, 255));
        btnEntregables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregablesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntregablesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntregablesMouseExited(evt);
            }
        });
        btnEntregables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Entregables");
        btnEntregables.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        panelSeleccion.add(btnEntregables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, 40));

        panelMantenimiento.add(panelSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 310, 370));
        panelSeleccion.getAccessibleContext().setAccessibleName("Seleccione una Tabla de Soporte");

        panelSoporte.setBackground(new java.awt.Color(255, 255, 255));
        panelSoporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla de Soporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSoporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        TPaneTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));
        TPaneTipoEntreg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        RegistrarTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de Entregable:");

        TipoEntregTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoEntregTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TipoEntregTextField1KeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Descripción del Entregable:");

        TipoEntregTextArea1.setColumns(20);
        TipoEntregTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoEntregTextArea1.setRows(5);
        jScrollPane3.setViewportView(TipoEntregTextArea1);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Vigencia:");

        TipoEntregTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarTipoEntregLayout = new javax.swing.GroupLayout(RegistrarTipoEntreg);
        RegistrarTipoEntreg.setLayout(RegistrarTipoEntregLayout);
        RegistrarTipoEntregLayout.setHorizontalGroup(
            RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTipoEntregLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(RegistrarTipoEntregLayout.createSequentialGroup()
                        .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel4)
                            .addComponent(jLabel21))
                        .addGap(29, 29, 29)
                        .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TipoEntregTextField1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(TipoEntregTextField2))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        RegistrarTipoEntregLayout.setVerticalGroup(
            RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTipoEntregLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TipoEntregTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrarTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(TipoEntregTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        TPaneTipoEntreg.addTab("Registrar", RegistrarTipoEntreg);

        GestionarTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));
        GestionarTipoEntreg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        GestionarTipoEntreg.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        GestionarTipoEntreg.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        tTipoEntreg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tTipoEntreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tTipoEntreg);

        GestionarTipoEntreg.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 210));

        TPaneTipoEntreg.addTab("Gestionar", GestionarTipoEntreg);

        EdicionTipoEntreg.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tipo de Entregable:");

        TipoEntregLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Descripción del Entregable:");

        TipoEntregTextArea2.setColumns(20);
        TipoEntregTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoEntregTextArea2.setRows(5);
        jScrollPane5.setViewportView(TipoEntregTextArea2);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Vigencia:");

        TipoEntregTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionTipoEntregLayout = new javax.swing.GroupLayout(EdicionTipoEntreg);
        EdicionTipoEntreg.setLayout(EdicionTipoEntregLayout);
        EdicionTipoEntregLayout.setHorizontalGroup(
            EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionTipoEntregLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addGap(22, 22, 22)
                .addGroup(EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TipoEntregLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(TipoEntregTextField3)
                    .addComponent(jButton4))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        EdicionTipoEntregLayout.setVerticalGroup(
            EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionTipoEntregLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TipoEntregLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EdicionTipoEntregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoEntregTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        TPaneTipoEntreg.addTab("Edición", EdicionTipoEntreg);

        jLayeredPane1.add(TPaneTipoEntreg, "card2");

        TPaneTipoDoc.setBackground(new java.awt.Color(255, 255, 255));
        TPaneTipoDoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        RegistrarTipoDoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Codigo de Documento:");

        TipoDocTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoDocTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TipoDocTextField1KeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Descripción del Tipo de Documento:");

        TipoDocTextArea1.setColumns(20);
        TipoDocTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoDocTextArea1.setRows(5);
        jScrollPane6.setViewportView(TipoDocTextArea1);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Vigente:");

        TipoDocTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Registrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarTipoDocLayout = new javax.swing.GroupLayout(RegistrarTipoDoc);
        RegistrarTipoDoc.setLayout(RegistrarTipoDocLayout);
        RegistrarTipoDocLayout.setHorizontalGroup(
            RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTipoDocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(RegistrarTipoDocLayout.createSequentialGroup()
                        .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(TipoDocTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(TipoDocTextField1))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        RegistrarTipoDocLayout.setVerticalGroup(
            RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarTipoDocLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(TipoDocTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoDocTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneTipoDoc.addTab("Registrar", RegistrarTipoDoc);

        GestionarTipoDoc.setBackground(new java.awt.Color(255, 255, 255));
        TipoDocTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoDocTable.setModel(new javax.swing.table.DefaultTableModel(
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
        TipoDocTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(TipoDocTable);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GestionarTipoDocLayout = new javax.swing.GroupLayout(GestionarTipoDoc);
        GestionarTipoDoc.setLayout(GestionarTipoDocLayout);
        GestionarTipoDocLayout.setHorizontalGroup(
            GestionarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarTipoDocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GestionarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(GestionarTipoDocLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        GestionarTipoDocLayout.setVerticalGroup(
            GestionarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarTipoDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(GestionarTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        TPaneTipoDoc.addTab("Gestionar", GestionarTipoDoc);

        EdicionTipoDoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Codigo de Documento:");

        TipoDocLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Descripción del Tipo de Documento:");

        TipoDocTextArea2.setColumns(20);
        TipoDocTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipoDocTextArea2.setRows(5);
        jScrollPane8.setViewportView(TipoDocTextArea2);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Vigente:");

        TipoDocTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setText("Editar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionTipoDocLayout = new javax.swing.GroupLayout(EdicionTipoDoc);
        EdicionTipoDoc.setLayout(EdicionTipoDocLayout);
        EdicionTipoDocLayout.setHorizontalGroup(
            EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionTipoDocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EdicionTipoDocLayout.createSequentialGroup()
                        .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(TipoDocLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(TipoDocTextField3))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        EdicionTipoDocLayout.setVerticalGroup(
            EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionTipoDocLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoDocLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EdicionTipoDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoDocTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneTipoDoc.addTab("Edición", EdicionTipoDoc);

        jLayeredPane1.add(TPaneTipoDoc, "card3");

        TPaneNivel.setBackground(new java.awt.Color(255, 255, 255));

        RegistrarNivel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setText("Codigo de Fase:");

        jLabel33.setText("Codigo de Nivel:");

        NivelTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NivelTextField1KeyPressed(evt);
            }
        });

        jLabel34.setText("Descripción del Nivel:");

        NivelTextArea1.setColumns(20);
        NivelTextArea1.setRows(5);
        jScrollPane9.setViewportView(NivelTextArea1);

        jLabel36.setText("Fase:");

        jLabel35.setText("Vigente:");

        jButton9.setText("Registrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarNivelLayout = new javax.swing.GroupLayout(RegistrarNivel);
        RegistrarNivel.setLayout(RegistrarNivelLayout);
        RegistrarNivelLayout.setHorizontalGroup(
            RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarNivelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistrarNivelLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NivelTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrarNivelLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NivelTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9)
                    .addGroup(RegistrarNivelLayout.createSequentialGroup()
                        .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9)
                            .addComponent(NivelTextField1)
                            .addComponent(NivelComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        RegistrarNivelLayout.setVerticalGroup(
            RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarNivelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(NivelComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(NivelTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NivelTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(RegistrarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NivelTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Registrar", RegistrarNivel);

        GestionarNivel.setBackground(new java.awt.Color(255, 255, 255));

        NivelTable.setModel(new javax.swing.table.DefaultTableModel(
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
        NivelTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(NivelTable);

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

        javax.swing.GroupLayout GestionarNivelLayout = new javax.swing.GroupLayout(GestionarNivel);
        GestionarNivel.setLayout(GestionarNivelLayout);
        GestionarNivelLayout.setHorizontalGroup(
            GestionarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarNivelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GestionarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(GestionarNivelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)))
                .addContainerGap())
        );
        GestionarNivelLayout.setVerticalGroup(
            GestionarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarNivelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GestionarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Gestionar", GestionarNivel);

        EdicionNivel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setText("Codigo de Fase:");

        jLabel39.setText("Codigo de Nivel:");

        jLabel40.setText("Descripción del Nivel:");

        NivelTextArea2.setColumns(20);
        NivelTextArea2.setRows(5);
        jScrollPane11.setViewportView(NivelTextArea2);

        jLabel41.setText("Fase:");

        jLabel42.setText("Vigente:");

        jButton12.setText("Editar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionNivelLayout = new javax.swing.GroupLayout(EdicionNivel);
        EdicionNivel.setLayout(EdicionNivelLayout);
        EdicionNivelLayout.setHorizontalGroup(
            EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionNivelLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12)
                    .addGroup(EdicionNivelLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NivelTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EdicionNivelLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NivelTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EdicionNivelLayout.createSequentialGroup()
                        .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11)
                            .addComponent(NivelComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NivelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        EdicionNivelLayout.setVerticalGroup(
            EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionNivelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(NivelComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(NivelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NivelTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(EdicionNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NivelTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        TPaneNivel.addTab("Edición", EdicionNivel);

        jLayeredPane1.add(TPaneNivel, "card4");

        TPaneFase.setBackground(new java.awt.Color(255, 255, 255));

        RegistrarFase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setText("Codigo de Fase:");

        FaseTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FaseTextField1KeyPressed(evt);
            }
        });

        jLabel45.setText("Descripción de la Fase:");

        FaseTextArea1.setColumns(20);
        FaseTextArea1.setRows(5);
        jScrollPane12.setViewportView(FaseTextArea1);

        jLabel46.setText("Vigencia:");

        jButton13.setText("Registrar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarFaseLayout = new javax.swing.GroupLayout(RegistrarFase);
        RegistrarFase.setLayout(RegistrarFaseLayout);
        RegistrarFaseLayout.setHorizontalGroup(
            RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarFaseLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46))
                .addGap(29, 29, 29)
                .addGroup(RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FaseTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FaseTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        RegistrarFaseLayout.setVerticalGroup(
            RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarFaseLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(FaseTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addGroup(RegistrarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FaseTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Registrar", RegistrarFase);

        GestionarFase.setBackground(new java.awt.Color(255, 255, 255));

        FaseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        FaseTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(FaseTable);

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

        javax.swing.GroupLayout GestionarFaseLayout = new javax.swing.GroupLayout(GestionarFase);
        GestionarFase.setLayout(GestionarFaseLayout);
        GestionarFaseLayout.setHorizontalGroup(
            GestionarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarFaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GestionarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(GestionarFaseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)))
                .addContainerGap())
        );
        GestionarFaseLayout.setVerticalGroup(
            GestionarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarFaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GestionarFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Gestionar", GestionarFase);

        EdicionFase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("Codigo de Fase:");

        jLabel48.setText("Descripción de la Fase:");

        FaseTextArea2.setColumns(20);
        FaseTextArea2.setRows(5);
        jScrollPane14.setViewportView(FaseTextArea2);

        jLabel49.setText("Vigencia:");

        jButton16.setText("Editar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionFaseLayout = new javax.swing.GroupLayout(EdicionFase);
        EdicionFase.setLayout(EdicionFaseLayout);
        EdicionFaseLayout.setHorizontalGroup(
            EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EdicionFaseLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49))
                .addGap(72, 72, 72)
                .addGroup(EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16)
                    .addComponent(FaseTextField3)
                    .addComponent(jScrollPane14)
                    .addComponent(FaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        EdicionFaseLayout.setVerticalGroup(
            EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionFaseLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(FaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EdicionFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FaseTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(31, 31, 31)
                .addComponent(jButton16)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        TPaneFase.addTab("Edición", EdicionFase);

        jLayeredPane1.add(TPaneFase, "card5");

        TPaneEstado.setBackground(new java.awt.Color(255, 255, 255));

        RegistrarEstado.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setText("Codigo de Nivel:");

        jLabel51.setText("Estado del Proyecto:");

        EstadoTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EstadoTextField1KeyPressed(evt);
            }
        });

        jLabel52.setText("Descripción del Estado:");

        EstadoTextArea1.setColumns(20);
        EstadoTextArea1.setRows(5);
        jScrollPane15.setViewportView(EstadoTextArea1);

        jLabel53.setText("Vigente:");

        jButton17.setText("Registrar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarEstadoLayout = new javax.swing.GroupLayout(RegistrarEstado);
        RegistrarEstado.setLayout(RegistrarEstadoLayout);
        RegistrarEstadoLayout.setHorizontalGroup(
            RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarEstadoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistrarEstadoLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EstadoTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton17)
                    .addGroup(RegistrarEstadoLayout.createSequentialGroup()
                        .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel54))
                        .addGap(10, 10, 10)
                        .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15)
                            .addComponent(EstadoTextField1)
                            .addComponent(EstadoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        RegistrarEstadoLayout.setVerticalGroup(
            RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrarEstadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(EstadoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(EstadoTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(RegistrarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addGap(33, 33, 33))
        );

        TPaneEstado.addTab("Registrar", RegistrarEstado);

        GestionarEstado.setBackground(new java.awt.Color(255, 255, 255));

        EstadoTable.setModel(new javax.swing.table.DefaultTableModel(
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
        EstadoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(EstadoTable);

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

        javax.swing.GroupLayout GestionarEstadoLayout = new javax.swing.GroupLayout(GestionarEstado);
        GestionarEstado.setLayout(GestionarEstadoLayout);
        GestionarEstadoLayout.setHorizontalGroup(
            GestionarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GestionarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(GestionarEstadoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton18)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)))
                .addContainerGap())
        );
        GestionarEstadoLayout.setVerticalGroup(
            GestionarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionarEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TPaneEstado.addTab("Gestionar", GestionarEstado);

        EdicionEstado.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setText("Codigo de Nivel:");

        jLabel56.setText("Estado del Proyecto:");

        jLabel57.setText("Descripción del Estado:");

        EstadoTextArea2.setColumns(20);
        EstadoTextArea2.setRows(5);
        jScrollPane17.setViewportView(EstadoTextArea2);

        jLabel58.setText("Vigente:");

        jButton20.setText("Editar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionEstadoLayout = new javax.swing.GroupLayout(EdicionEstado);
        EdicionEstado.setLayout(EdicionEstadoLayout);
        EdicionEstadoLayout.setHorizontalGroup(
            EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionEstadoLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EdicionEstadoLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EstadoTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton20)
                    .addGroup(EdicionEstadoLayout.createSequentialGroup()
                        .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel55)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane17)
                            .addComponent(EstadoComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EstadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        EdicionEstadoLayout.setVerticalGroup(
            EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EdicionEstadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(EstadoComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(EstadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(18, 18, 18)
                .addGroup(EdicionEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addGap(36, 36, 36))
        );

        TPaneEstado.addTab("Edición", EdicionEstado);

        jLayeredPane1.add(TPaneEstado, "card6");

        TPaneEntregables.setBackground(new java.awt.Color(255, 255, 255));

        RegistrarEntregables.setBackground(new java.awt.Color(255, 255, 255));

        jLabel67.setText("Tipo de Entregable:");

        jLabel65.setText("Descripción del Entregable:");

        EntregablesTextArea1.setColumns(20);
        EntregablesTextArea1.setRows(5);
        jScrollPane18.setViewportView(EntregablesTextArea1);

        jLabel66.setText("Descripción Corta del Entregable:");

        jButton26.setText("Registrar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarEntregablesLayout = new javax.swing.GroupLayout(RegistrarEntregables);
        RegistrarEntregables.setLayout(RegistrarEntregablesLayout);
        RegistrarEntregablesLayout.setHorizontalGroup(
            RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarEntregablesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistrarEntregablesLayout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EntregablesTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton26)
                    .addGroup(RegistrarEntregablesLayout.createSequentialGroup()
                        .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel67))
                        .addGap(10, 10, 10)
                        .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane18)
                            .addComponent(EntregablesComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        RegistrarEntregablesLayout.setVerticalGroup(
            RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarEntregablesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(EntregablesComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addGroup(RegistrarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EntregablesTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Registrar", RegistrarEntregables);

        GestionarEntregables.setBackground(new java.awt.Color(255, 255, 255));

        EntregablesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        EntregablesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(EntregablesTable);

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

        javax.swing.GroupLayout GestionarEntregablesLayout = new javax.swing.GroupLayout(GestionarEntregables);
        GestionarEntregables.setLayout(GestionarEntregablesLayout);
        GestionarEntregablesLayout.setHorizontalGroup(
            GestionarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEntregablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GestionarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(GestionarEntregablesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton27)
                        .addGap(18, 18, 18)
                        .addComponent(jButton28)))
                .addContainerGap())
        );
        GestionarEntregablesLayout.setVerticalGroup(
            GestionarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEntregablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(GestionarEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28)
                    .addComponent(jButton27))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Gestionar", GestionarEntregables);

        EdicionEntregables.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setText("Tipo de Entregable:");

        jLabel69.setText("Descripción del Entregablel:");

        EntregablesTextArea2.setColumns(20);
        EntregablesTextArea2.setRows(5);
        jScrollPane20.setViewportView(EntregablesTextArea2);

        jLabel70.setText("Descripción corta del Entregable:");

        jButton29.setText("Editar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EdicionEntregablesLayout = new javax.swing.GroupLayout(EdicionEntregables);
        EdicionEntregables.setLayout(EdicionEntregablesLayout);
        EdicionEntregablesLayout.setHorizontalGroup(
            EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionEntregablesLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EdicionEntregablesLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EntregablesTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton29)
                    .addGroup(EdicionEntregablesLayout.createSequentialGroup()
                        .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69))
                        .addGap(18, 18, 18)
                        .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane20)
                            .addComponent(EntregablesComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        EdicionEntregablesLayout.setVerticalGroup(
            EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdicionEntregablesLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(EntregablesComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(18, 18, 18)
                .addGroup(EdicionEntregablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EntregablesTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addGap(18, 18, 18)
                .addComponent(jButton29)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        TPaneEntregables.addTab("Edición", EdicionEntregables);

        jLayeredPane1.add(TPaneEntregables, "card7");

        panelSoporte.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 28, 430, 320));

        panelMantenimiento.add(panelSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 480, 370));

        header5.setBackground(new java.awt.Color(159, 168, 218));
        header5.setForeground(new java.awt.Color(255, 255, 255));
        header5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Mantenimiento");
        header5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        panelMantenimiento.add(header5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelMantenimiento, "card4");

        panelModificar.setBackground(new java.awt.Color(255, 255, 255));
        panelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSubida1.setBackground(new java.awt.Color(255, 255, 255));
        panelSubida1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de subida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelSubida1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubDocMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSubDocMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Open_25px.png"))); // NOI18N
        btnSubDocMod.setText("Seleccione el documento para subirlo");
        btnSubDocMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubDocModActionPerformed(evt);
            }
        });
        panelSubida1.add(btnSubDocMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, 411, 34));

        lbObservaciones1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbObservaciones1.setText("Observaciones");
        panelSubida1.add(lbObservaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 143, 411, 28));

        txtObsMod.setColumns(20);
        txtObsMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtObsMod.setRows(5);
        jScrollPane21.setViewportView(txtObsMod);

        panelSubida1.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, 411, 188));

        lbVersion1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbVersion1.setText("Version");
        panelSubida1.add(lbVersion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 112, 118, 30));

        txtVersionMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtVersionMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVersionModActionPerformed(evt);
            }
        });
        panelSubida1.add(txtVersionMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 112, 289, 30));

        lbRuta1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelSubida1.add(lbRuta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 71, 411, 30));

        panelModificar.add(panelSubida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 450, 390));

        panelDatosPyto1.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosPyto1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        panelDatosPyto1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFFin1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFFin1.setText("Fecha de Fin");
        panelDatosPyto1.add(lbFFin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 118, 30));

        lbCostoEstimado2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado2.setText("Costo Estimado");
        panelDatosPyto1.add(lbCostoEstimado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 118, 30));

        txtCostoEstimadoMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCostoEstimadoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoEstimadoModActionPerformed(evt);
            }
        });
        panelDatosPyto1.add(txtCostoEstimadoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 300, 30));

        lbEspecialista1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbEspecialista1.setText("Especialista");
        panelDatosPyto1.add(lbEspecialista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 118, 30));

        cmbEspecialistaMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbEspecialistaMod.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));
        panelDatosPyto1.add(cmbEspecialistaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 220, 300, 30));

        cmbResponsableMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbResponsableMod.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1}));
        panelDatosPyto1.add(cmbResponsableMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 280, 300, 30));

        lbResponsable1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbResponsable1.setText("Responsable");
        panelDatosPyto1.add(lbResponsable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 118, 30));

        chkVigencia1.setBackground(new java.awt.Color(255, 255, 255));
        chkVigencia1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkVigencia1.setText("¿Esta vigente?");
        chkVigencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVigencia1ActionPerformed(evt);
            }
        });
        panelDatosPyto1.add(chkVigencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 312, -1));

        spnFFinMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto1.add(spnFFinMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 300, 30));

        lbCostoEstimado3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbCostoEstimado3.setText("Tipo");
        panelDatosPyto1.add(lbCostoEstimado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 30));

        cmbTDocMod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        panelDatosPyto1.add(cmbTDocMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 300, 30));

        panelModificar.add(panelDatosPyto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 470, 390));

        header3.setBackground(new java.awt.Color(159, 168, 218));
        header3.setForeground(new java.awt.Color(255, 255, 255));
        header3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Modificar Documentos");
        header3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        btnIngresar1.setBackground(new java.awt.Color(57, 73, 171));
        btnIngresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresar1MouseExited(evt);
            }
        });
        btnIngresar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Edit_26px_1.png"))); // NOI18N
        btnIngresar1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Modificar");
        btnIngresar1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 110, 48));

        header3.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 200, -1));

        panelModificar.add(header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        mainPane.add(panelModificar, "card2");

        panelDetalles.setBackground(new java.awt.Color(255, 255, 255));
        panelDetalles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header4.setBackground(new java.awt.Color(159, 168, 218));
        header4.setForeground(new java.awt.Color(255, 255, 255));
        header4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Detalles del Documento");
        header4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        panelDetalles.add(header4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 170));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel60.setText("Código del documento");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel61.setText("Nombre del documento");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel79.setText("Observaciones");

        txt_obsDocPyto.setColumns(20);
        txt_obsDocPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_obsDocPyto.setRows(5);
        txt_obsDocPyto.setEnabled(false);
        jScrollPane22.setViewportView(txt_obsDocPyto);

        btn_abrirdoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_abrirdoc.setText("Abrir Documento");
        btn_abrirdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirdocActionPerformed(evt);
            }
        });

        txt_codDocPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_codDocPyto.setEnabled(false);

        txt_nombDocPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_nombDocPyto.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_codDocPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nombDocPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_abrirdoc)
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txt_codDocPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txt_nombDocPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btn_abrirdoc)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 370, 310));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel72.setText("Costo estimado del Proyecto");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel73.setText("Nombre del Proyecto");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel75.setText("Fase del Proyecto");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel76.setText("Nivel del Proyecto");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel77.setText("Fecha de Inicio del Proyecto");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel78.setText("Fecha de Fin del Proyecto");

        txt_nombPyto.setEnabled(false);

        txt_fasePyto.setEnabled(false);

        txt_nivelPyto.setEnabled(false);

        txt_fechaInicPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_fechaInicPyto.setEnabled(false);

        txt_fechaFinPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_fechaFinPyto.setEnabled(false);
        txt_fechaFinPyto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaFinPytoActionPerformed(evt);
            }
        });

        txt_costoPyto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_costoPyto.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_costoPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechaFinPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechaInicPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nivelPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fasePyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombPyto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txt_nombPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fasePyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nivelPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechaInicPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechaFinPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_costoPyto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 370, 310));

        panelDetalles.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 940, 390));

        mainPane.add(panelDetalles, "card2");

        header2.setBackground(new java.awt.Color(159, 168, 218));
        header2.setForeground(new java.awt.Color(255, 255, 255));
        header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mantenimiento");
        header2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 36));

        mainPane.add(header2, "card7");

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
        File archivoSeleccionado = displayFileChooser();
        if (archivoSeleccionado != null) {
            rutaDocumento = archivoSeleccionado;
            lbRuta.setText(rutaDocumento.getName());
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
        panelMantenimiento.setVisible(false);
        panelModificar.setVisible(false);
        panelDetalles.setVisible(false);
        resetFormIngresar();
    }//GEN-LAST:event_btnInsertarDocMouseClicked

    private void btnBuscarDocsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocsMouseClicked
        // TODO add your handling code here:
        llenarTabla(PytoDocsDAOImple.getInstance().listar());
        panelInsertar.setVisible(false);
        panelBuscar.setVisible(true);
        panelMantenimiento.setVisible(false);
        panelModificar.setVisible(false);
        panelDetalles.setVisible(false);
    }//GEN-LAST:event_btnBuscarDocsMouseClicked

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        // TODO add your handling code here:
        String query = caja_busqueda.getText();
        String array[] = query.split(",");

        switch (array.length) {
            case 0:
                break;
            case 1:
                if (query.isEmpty()) {
                    llenarTabla(pytoDocsDAO.listar());
                } else {
                    int busq = Integer.parseInt(query);
                    llenarTabla(pytoDocsDAO.buscarTodos(busq));
                }

                break;
            case 2:
                int codPyto = Integer.parseInt(array[0]);
                int corrPyto = Integer.parseInt(array[1]);
                llenarTabla(Collections.singletonList(pytoDocsDAO.buscar2(codPyto, corrPyto)));
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "No se puede realizar la busqueda");
        }
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
        jLayeredPane1.setVisible(false);
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
            DriveConnection myDrive = DriveConnection.getInstance();

            String idArchivo = myDrive.subirArchivo(
                    rutaDocumento,
                    DriveConstants.DRIVE_TYPES.get(((TipoDoc) cmbTDoc.getModel().getSelectedItem()).getDesTDoc())
            );

            if (idArchivo != null) {
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

                pytoDocs.setVerDoc(txtVersion.getText());
                pytoDocs.setObservac(txtObs.getText());
                Entregables entregable = (Entregables) cmbTEntregable.getSelectedItem();
                pytoDocs.setTipoEntreg(entregable.getTipoEntreg());
                pytoDocs.setCorrEntreg(entregable.getCorrEntreg());
                pytoDocs.setCodEsp(1);
                pytoDocs.setCodResp(1);

                pytoDocs.setRutaDoc(idArchivo);

                pytoDocs.setVigente((chkVigencia.isSelected()) ? "1" : "0");
                String mensaje = PytoDocsDAOImple.getInstance().insertar(pytoDocs);
                JOptionPane.showMessageDialog(rootPane, mensaje);
                resetFormIngresar();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al cargar el archivo", "Error de carga", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe elegir un archivo para subir", "No hay archivo de carga", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarMouseClicked

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(26, 35, 126));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(57, 73, 171));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnTipoEntregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoEntregMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(true);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());
        TPaneTipoEntreg.setEnabledAt(2, false);
    }//GEN-LAST:event_btnTipoEntregMouseClicked

    private void btnTipoDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoDocMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(true);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());
        TPaneTipoDoc.setEnabledAt(2, false);
    }//GEN-LAST:event_btnTipoDocMouseClicked

    private void btnNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(true);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaNivel(NivelDAOImple.getInstance().listar());
        llenarComboNivel();
        TPaneNivel.setEnabledAt(2, false);
    }//GEN-LAST:event_btnNivelMouseClicked

    private void btnFaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaseMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(true);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(false);
        llenarTablaFase(FaseDAOImple.getInstance().listar());
        TPaneFase.setEnabledAt(2, false);
    }//GEN-LAST:event_btnFaseMouseClicked

    private void btnEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(true);
        TPaneEntregables.setVisible(false);
        llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());
        llenarComboEstado();
        TPaneEstado.setEnabledAt(2, false);
    }//GEN-LAST:event_btnEstadoMouseClicked

    private void btnEntregablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregablesMouseClicked
        // TODO add your handling code here:
        jLayeredPane1.setVisible(true);
        TPaneTipoEntreg.setVisible(false);
        TPaneTipoDoc.setVisible(false);
        TPaneNivel.setVisible(false);
        TPaneFase.setVisible(false);
        TPaneEstado.setVisible(false);
        TPaneEntregables.setVisible(true);
        llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());
        llenarComboEntregables();
        TPaneEntregables.setEnabledAt(2, false);
    }//GEN-LAST:event_btnEntregablesMouseClicked

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablaDocs.getSelectedRow();
        if (selectedRow >= 0) {

            int codPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 0);
            int corrPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 1);

            PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            PytoDocsView pytoDocsView = pytoDocsDAO.buscar2(codPyto, corrPyto);

            panelInsertar.setVisible(false);
            panelBuscar.setVisible(false);
            panelMantenimiento.setVisible(false);
            panelModificar.setVisible(false);
            panelDetalles.setVisible(true);

            txt_codDocPyto.setText(pytoDocsView.getCodPyto() + "");
            txt_costoPyto.setText(pytoDocsView.getCostoEst() + "");
            txt_fasePyto.setText(pytoDocsView.getDesFase());
            txt_fechaFinPyto.setText(formato.format(pytoDocsView.getFecFin()));
            txt_fechaInicPyto.setText(formato.format(pytoDocsView.getFecIni()));
            txt_nivelPyto.setText(pytoDocsView.getDesNivel());
            txt_nombDocPyto.setText(" ");
            txt_nombPyto.setText(" ");
            txt_obsDocPyto.setText(" ");
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void TipoEntregTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TipoEntregTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoEntregTextField1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (TipoEntregTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (!Character.isDigit(TipoEntregTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Tipo de Entregable debe ser un digito";
        } else if (TipoEntregTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Entregable no puede ser vacía";
        } else if (TipoEntregTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = Integer.parseInt(TipoEntregTextField1.getText());
            String desEntreg = TipoEntregTextArea1.getText();
            String vigencia = TipoEntregTextField2.getText();

            objTipoEntreg = new TipoEntreg(tipoEntreg, desEntreg, vigencia);

            TipoEntregDAOImple.getInstance().insertar(objTipoEntreg);

            TipoEntregTextField1.setText("");
            TipoEntregTextArea1.setText("");
            TipoEntregTextField2.setText("");

            llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = tTipoEntreg.getSelectedRow();

        if (fila > -1) {
            int tipoEntreg = (Integer) tTipoEntreg.getValueAt(fila, 1);
            String desEntreg = String.valueOf(tTipoEntreg.getValueAt(fila, 0));
            String vigencia = String.valueOf(tTipoEntreg.getValueAt(fila, 2));

            TipoEntregLabel.setText(String.valueOf(tipoEntreg));
            TipoEntregTextArea2.setText(desEntreg);
            TipoEntregTextField3.setText(vigencia);

            TipoEntregTextArea2.setEditable(true);
            TipoEntregTextField3.setEditable(true);

            TPaneTipoEntreg.setEnabledAt(2, true);
            TPaneTipoEntreg.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = tTipoEntreg.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) tTipoEntreg.getValueAt(fila, 1);

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

        if (TipoEntregTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Entregable no puede ser vacía";
        } else if (TipoEntregTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = Integer.parseInt(TipoEntregLabel.getText());
            String desEntreg = TipoEntregTextArea2.getText();
            String vigencia = TipoEntregTextField3.getText();

            objTipoEntreg = new TipoEntreg(tipoEntreg, desEntreg, vigencia);

            TipoEntregDAOImple.getInstance().actualizar(objTipoEntreg);

            llenarTablaTipoEntreg(TipoEntregDAOImple.getInstance().listarEntity());

            TipoEntregLabel.setText("");
            TipoEntregTextArea2.setText("");
            TipoEntregTextField3.setText("");
            TipoEntregTextArea2.setEditable(false);
            TipoEntregTextField3.setEditable(false);
            TPaneTipoEntreg.setEnabledAt(2, false);
            TPaneTipoEntreg.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TipoDocTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TipoDocTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocTextField1KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (TipoDocTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Documento no puede ser vacío";
        } else if (!Character.isDigit(TipoDocTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Documento debe ser dos digitos";
        } else if (TipoDocTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Documento no puede ser vacía";
        } else if (TipoDocTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoDoc = Integer.parseInt(TipoDocTextField1.getText());
            String desTDoc = TipoDocTextArea1.getText();
            String vigente = TipoDocTextField2.getText();

            objTipoDoc = new TipoDoc(tipoDoc, desTDoc, vigente);

            TipoDocDAOImple.getInstance().insertar(objTipoDoc);

            TipoDocTextField1.setText("");
            TipoDocTextArea1.setText("");
            TipoDocTextField2.setText("");

            llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int fila = TipoDocTable.getSelectedRow();
        if (fila > -1) {
            int tipoDoc = (Integer) TipoDocTable.getValueAt(fila, 0);
            String desTDoc = String.valueOf(TipoDocTable.getValueAt(fila, 1));
            String vigente = String.valueOf(TipoDocTable.getValueAt(fila, 2));

            TipoDocLabel.setText(String.valueOf(tipoDoc));
            TipoDocTextArea2.setText(desTDoc);
            TipoDocTextField3.setText(vigente);

            TipoDocTextArea2.setEditable(true);
            TipoDocTextField3.setEditable(true);

            TPaneTipoDoc.setEnabledAt(2, true);
            TPaneTipoDoc.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int fila = TipoDocTable.getSelectedRow();
        if (fila > -1) {
            int tipoDoc = (Integer) TipoDocTable.getValueAt(fila, 0);

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

        if (TipoDocTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Tipo de Documento no puede ser vacía";
        } else if (TipoDocTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int tipoDoc = Integer.parseInt(TipoDocLabel.getText());
            String desTDoc = TipoDocTextArea2.getText();
            String vigente = TipoDocTextField3.getText();

            objTipoDoc = new TipoDoc(tipoDoc, desTDoc, vigente);

            TipoDocDAOImple.getInstance().actualizar(objTipoDoc);

            llenarTablaTipoDoc(TipoDocDAOImple.getInstance().listar());

            TipoDocLabel.setText("");
            TipoDocTextArea2.setText("");
            TipoDocTextField3.setText("");
            TipoDocTextArea2.setEditable(false);
            TipoDocTextField3.setEditable(false);
            TPaneTipoDoc.setEnabledAt(2, false);
            TPaneTipoDoc.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void NivelTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NivelTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NivelTextField1KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (NivelComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (NivelTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (!Character.isDigit(NivelTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Nivel debe ser dos digitos";
        } else if (NivelTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Nivel no puede ser vacía";
        } else if (NivelTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La fase no puede ser vacía";
        } else if (NivelTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Fase) NivelComboBox1.getSelectedItem()).getCodFase();
            int codNivel = Integer.parseInt(NivelTextField1.getText());
            String desNivel = NivelTextArea1.getText();
            String fase = NivelTextField2.getText();
            String vigente = NivelTextField3.getText();

            objNivel = new Nivel(codFase, codNivel, desNivel, fase, vigente);

            String respuesta = NivelDAOImple.getInstance().insertar(objNivel);

            NivelComboBox1.setSelectedIndex(-1);
            NivelTextField1.setText("");
            NivelTextArea1.setText("");
            NivelTextField2.setText("");
            NivelTextField3.setText("");

            llenarTablaNivel(NivelDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, respuesta, "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int fila = NivelTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) NivelTable.getValueAt(fila, 0);
            int codNivel = (Integer) NivelTable.getValueAt(fila, 1);
            String desNivel = String.valueOf(NivelTable.getValueAt(fila, 2));
            String fase = String.valueOf(NivelTable.getValueAt(fila, 3));
            String vigente = String.valueOf(NivelTable.getValueAt(fila, 4));

            NivelComboBox2.setSelectedItem(-1);
            NivelLabel.setText(String.valueOf(codNivel));
            NivelTextArea2.setText(desNivel);
            NivelTextField4.setText(fase);
            NivelTextField5.setText(vigente);

            NivelComboBox2.setEnabled(true);
            NivelTextArea2.setEditable(true);
            NivelTextField4.setEditable(true);
            NivelTextField5.setEditable(true);

            TPaneNivel.setEnabledAt(2, true);
            TPaneNivel.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int fila = NivelTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) NivelTable.getValueAt(fila, 0);
            int codNivel = (Integer) NivelTable.getValueAt(fila, 1);

            //eliminar obj
            NivelDAOImple.getInstance().eliminar(codFase, codNivel);

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

        if (NivelComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (NivelTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Nivel no puede ser vacía";
        } else if (NivelTextField4.getText().equals("")) {
            valido = false;
            mensaje = "La fase no puede ser vacía";
        } else if (NivelTextField5.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Fase) NivelComboBox2.getSelectedItem()).getCodFase();
            int codNivel = Integer.parseInt(NivelLabel.getText());
            String desNivel = NivelTextArea2.getText();
            String fase = NivelTextField4.getText();
            String vigente = NivelTextField5.getText();

            objNivel = new Nivel(codFase, codNivel, desNivel, fase, vigente);

            NivelDAOImple.getInstance().actualizar(objNivel);

            llenarTablaNivel(NivelDAOImple.getInstance().listar());

            NivelComboBox2.setSelectedIndex(-1);
            NivelLabel.setText("");
            NivelTextArea2.setText("");
            NivelTextField4.setText("");
            NivelTextField5.setText("");
            NivelComboBox2.setEnabled(false);
            NivelTextArea2.setEditable(false);
            NivelTextField4.setEditable(false);
            NivelTextField5.setEditable(false);
            TPaneNivel.setEnabledAt(2, false);
            TPaneNivel.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void FaseTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FaseTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FaseTextField1KeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (FaseTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Codigo de Fase no puede ser vacío";
        } else if (!Character.isDigit(FaseTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Codigo de Documento debe ser 1 digito";
        } else if (FaseTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion de la Fase no puede ser vacía";
        } else if (FaseTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = Integer.parseInt(FaseTextField1.getText());
            String desFase = FaseTextArea1.getText();
            String vigencia = FaseTextField2.getText();

            objFase = new Fase(codFase, desFase, vigencia);

            FaseDAOImple.getInstance().insertar(objFase);

            FaseTextField1.setText("");
            FaseTextArea1.setText("");
            FaseTextField2.setText("");

            llenarTablaFase(FaseDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int fila = FaseTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) FaseTable.getValueAt(fila, 0);
            String desFase = String.valueOf(FaseTable.getValueAt(fila, 1));
            String vigencia = String.valueOf(FaseTable.getValueAt(fila, 2));

            FaseLabel.setText(String.valueOf(codFase));
            FaseTextArea2.setText(desFase);
            FaseTextField3.setText(vigencia);

            FaseTextArea2.setEditable(true);
            FaseTextField3.setEditable(true);

            TPaneFase.setEnabledAt(2, true);
            TPaneFase.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int fila = FaseTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) FaseTable.getValueAt(fila, 0);

            FaseDAOImple.getInstance().eliminar(codFase);

            llenarTablaFase(FaseDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Borrado Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:

        boolean valido = true;
        String mensaje = "";

        if (FaseTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion de la Fase no puede ser vacía";
        } else if (FaseTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = Integer.parseInt(FaseLabel.getText());
            String desFase = FaseTextArea2.getText();
            String vigencia = FaseTextField3.getText();

            objFase = new Fase(codFase, desFase, vigencia);

            FaseDAOImple.getInstance().actualizar(objFase);

            llenarTablaFase(FaseDAOImple.getInstance().listar());

            FaseLabel.setText("");
            FaseTextArea2.setText("");
            FaseTextField3.setText("");
            FaseTextArea2.setEditable(false);
            FaseTextField3.setEditable(false);
            TPaneFase.setEnabledAt(2, false);
            TPaneFase.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void EstadoTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EstadoTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoTextField1KeyPressed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        boolean valido = true;
        String mensaje = "";

        if (EstadoComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (EstadoTextField1.getText().equals("")) {
            valido = false;
            mensaje = "El Estado del Proyecto no puede ser vacío";
        } else if (!Character.isDigit(EstadoTextField1.getText().charAt(0))) {
            valido = false;
            mensaje = "El Estado del Proyecto debe ser dos digitos";
        } else if (EstadoTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Estado no puede ser vacía";
        } else if (EstadoTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Nivel) EstadoComboBox1.getSelectedItem()).getCodFase();
            int codNivel = ((Nivel) EstadoComboBox1.getSelectedItem()).getCodNivel();
            int estPyto = Integer.parseInt(EstadoTextField1.getText());
            String desEstado = EstadoTextArea1.getText();
            String vigente = EstadoTextField2.getText();

            objEstado = new Estado(codFase, codNivel, estPyto, desEstado, vigente);

            EstadoDAOImple.getInstance().insertar(objEstado);

            EstadoComboBox1.setSelectedIndex(-1);
            EstadoTextField1.setText("");
            EstadoTextArea1.setText("");
            EstadoTextField2.setText("");

            llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        int fila = EstadoTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) EstadoTable.getValueAt(fila, 0);
            int codNivel = (Integer) EstadoTable.getValueAt(fila, 1);
            int estPyto = (Integer) EstadoTable.getValueAt(fila, 3);
            String desEstado = String.valueOf(EstadoTable.getValueAt(fila, 2));
            String vigente = String.valueOf(EstadoTable.getValueAt(fila, 4));

            EstadoComboBox2.setSelectedItem(-1);
            EstadoLabel.setText(String.valueOf(estPyto));
            EstadoTextArea2.setText(desEstado);
            EstadoTextField3.setText(vigente);

            EstadoComboBox2.setEnabled(true);
            EstadoTextArea2.setEditable(true);
            EstadoTextField3.setEditable(true);

            TPaneEstado.setEnabledAt(2, true);
            TPaneEstado.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int fila = EstadoTable.getSelectedRow();
        if (fila > -1) {
            int codFase = (Integer) EstadoTable.getValueAt(fila, 0);
            int codNivel = (Integer) EstadoTable.getValueAt(fila, 1);
            int estPyto = (Integer) EstadoTable.getValueAt(fila, 3);

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

        if (EstadoComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Codigo de Nivel no puede ser vacío";
        } else if (EstadoTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Estado no puede ser vacía";
        } else if (EstadoTextField3.getText().equals("")) {
            valido = false;
            mensaje = "La Vigencia no puede ser vacía";
        }

        if (valido) {
            int codFase = ((Nivel) EstadoComboBox2.getSelectedItem()).getCodFase();
            int codNivel = ((Nivel) EstadoComboBox2.getSelectedItem()).getCodNivel();
            int estPyto = Integer.parseInt(EstadoLabel.getText());
            String desEstado = EstadoTextArea2.getText();
            String vigente = EstadoTextField3.getText();

            objEstado = new Estado(codFase, codNivel, estPyto, desEstado, vigente);

            EstadoDAOImple.getInstance().actualizar(objEstado);

            llenarTablaEstado(EstadoDAOImple.getInstance().listarEntity());

            EstadoComboBox2.setSelectedIndex(-1);
            EstadoLabel.setText("");
            EstadoTextArea2.setText("");
            EstadoTextField3.setText("");
            EstadoComboBox2.setEnabled(false);
            EstadoTextArea2.setEditable(false);
            EstadoTextField3.setEditable(false);
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

        if (EntregablesComboBox1.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (EntregablesTextArea1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Entregable no puede ser vacía";
        } else if (EntregablesTextField1.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion corta del Entregable no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = ((TipoEntreg) EntregablesComboBox1.getSelectedItem()).getTipoEntreg();
            String desEntreg = EntregablesTextArea1.getText();
            String desCortaEntreg = EntregablesTextField1.getText();

            objEntregables = new Entregables(tipoEntreg, 0, desEntreg, desCortaEntreg);

            EntregablesDAOImple.getInstance().insertar(objEntregables);

            EntregablesComboBox1.setSelectedIndex(-1);
            EntregablesTextArea1.setText("");
            EntregablesTextField1.setText("");

            llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());

            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        int fila = EntregablesTable.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) EntregablesTable.getValueAt(fila, 3);
            int corrEntreg = (Integer) EntregablesTable.getValueAt(fila, 0);
            String desEntreg = String.valueOf(EntregablesTable.getValueAt(fila, 2));
            String desCortaEntreg = String.valueOf(EntregablesTable.getValueAt(fila, 1));

            EntregablesComboBox2.setSelectedItem(-1);
            EntregablesTextArea2.setText(desEntreg);
            EntregablesTextField2.setText(desCortaEntreg);

            EntregablesComboBox2.setEnabled(true);
            EntregablesTextArea2.setEditable(true);
            EntregablesTextField2.setEditable(true);

            TPaneEntregables.setEnabledAt(2, true);
            TPaneEntregables.setSelectedIndex(2);

        } else {
            JOptionPane.showMessageDialog(null, "Debe elegir un elemento de la tabla", "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        int fila = EntregablesTable.getSelectedRow();
        if (fila > -1) {
            int tipoEntreg = (Integer) EntregablesTable.getValueAt(fila, 3);
            int corrEntreg = (Integer) EntregablesTable.getValueAt(fila, 0);

            EntregablesDAOImple.getInstance().eliminar(tipoEntreg, corrEntreg);

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

        if (EntregablesComboBox2.getSelectedItem().toString().equals("")) {
            valido = false;
            mensaje = "El Tipo de Entregable no puede ser vacío";
        } else if (EntregablesTextArea2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion del Entregable no puede ser vacía";
        } else if (EntregablesTextField2.getText().equals("")) {
            valido = false;
            mensaje = "La descripcion corta del Entregable no puede ser vacía";
        }

        if (valido) {
            int tipoEntreg = ((TipoEntreg) EntregablesComboBox2.getSelectedItem()).getTipoEntreg();
            String desEntreg = EntregablesTextArea2.getText();
            String desCortaEntreg = EntregablesTextField2.getText();

            objEntregables = new Entregables(tipoEntreg, 0, desEntreg, desCortaEntreg);

            EntregablesDAOImple.getInstance().actualizar(objEntregables);

            llenarTablaEntregables(EntregablesDAOImple.getInstance().listar());

            EntregablesComboBox2.setSelectedIndex(-1);
            EntregablesTextArea2.setText("");
            EntregablesTextField2.setText("");
            EntregablesComboBox2.setEnabled(false);
            EntregablesTextArea2.setEditable(false);
            EntregablesTextField2.setEditable(false);
            TPaneEntregables.setEnabledAt(2, false);
            TPaneEntregables.setSelectedIndex(1);

            JOptionPane.showMessageDialog(null, "Modificación Exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btnTipoEntregMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoEntregMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnTipoEntregMouseEntered

    private void btnTipoEntregMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoEntregMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnTipoEntregMouseExited

    private void btnTipoDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoDocMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnTipoDocMouseEntered

    private void btnTipoDocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoDocMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnTipoDocMouseExited

    private void btnNivelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnNivelMouseEntered

    private void btnNivelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnNivelMouseExited

    private void btnFaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaseMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnFaseMouseEntered

    private void btnFaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaseMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnFaseMouseExited

    private void btnEstadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnEstadoMouseExited

    private void btnEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadoMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnEstadoMouseEntered

    private void btnEntregablesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregablesMouseEntered
        // TODO add your handling code here:
        hoverOn((JPanel) evt.getSource(), new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_btnEntregablesMouseEntered

    private void btnEntregablesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregablesMouseExited
        // TODO add your handling code here:
        hoverOff((JPanel) evt.getSource(), new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_btnEntregablesMouseExited

    private void btnActualizarDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDocsActionPerformed
        int selectedRow = tablaDocs.getSelectedRow();
        if (selectedRow >= 0) {

            int codPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 0);
            int corrPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 1);

            PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();

            pytoDocsMod = pytoDocsDAO.buscar(codPyto, corrPyto);

            resetCombos();
            llenarCombos();
            panelInsertar.setVisible(false);
            panelBuscar.setVisible(false);
            panelMantenimiento.setVisible(false);
            panelModificar.setVisible(true);
            panelDetalles.setVisible(false);

            // Llenando formulario
            spnFFinMod.getModel().setValue(pytoDocsMod.getFecFin());

            txtCostoEstimadoMod.setText("" + pytoDocsMod.getCostoEst());

            for (int i = 0; i < cmbTDocMod.getModel().getSize(); i++) {
                if (pytoDocsMod.getCodDoc()
                        == ((TipoDoc) cmbTDocMod.getModel().getElementAt(i)).getCodDoc()) {
                    cmbTDocMod.setSelectedItem(cmbTDocMod.getModel().getElementAt(i));
                }
            }

            chkVigencia1.setSelected((pytoDocsMod.getVigente().equals("1")));

            txtVersionMod.setText(pytoDocsMod.getVerDoc());

            txtObsMod.setText(pytoDocsMod.getObservac());

            rutaDocumento = new File(pytoDocsMod.getRutaDoc());

        }

    }//GEN-LAST:event_btnActualizarDocsActionPerformed

    private void btnSubDocModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubDocModActionPerformed
        // TODO add your handling code here:
        File archivoSeleccionado = displayFileChooser();
        if (archivoSeleccionado != null) {
            rutaDocumentoMod = archivoSeleccionado;
            lbRuta.setText(rutaDocumentoMod.getName());
        }
    }//GEN-LAST:event_btnSubDocModActionPerformed

    private File displayFileChooser() {
        JFileChooser exploradorArchivos = new JFileChooser(System.getProperty("user.desktop"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        exploradorArchivos.setFileFilter(filtro);
        exploradorArchivos.setMultiSelectionEnabled(false);
        exploradorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        exploradorArchivos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        int opcion = exploradorArchivos.showOpenDialog(this);

        return (opcion == JFileChooser.APPROVE_OPTION) ? exploradorArchivos.getSelectedFile() : null;
    }
    private void txtVersionModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVersionModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVersionModActionPerformed

    private void txtCostoEstimadoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoEstimadoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoEstimadoModActionPerformed

    private void chkVigencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVigencia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVigencia1ActionPerformed

    private void btnIngresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MouseClicked
        // TODO add your handling code here:
        if (pytoDocsMod != null && rutaDocumentoMod != null) {
            pytoDocsMod.setFecFin((Date) spnFFinMod.getModel().getValue());
            pytoDocsMod.setCostoEst(Double.parseDouble(txtCostoEstimadoMod.getText()));
            pytoDocsMod.setCodDoc(((TipoDoc) cmbTDocMod.getModel().getSelectedItem()).getCodDoc());
            pytoDocsMod.setVigente((chkVigencia1.isSelected()) ? "1" : "0");
            pytoDocsMod.setVerDoc(txtVersionMod.getText());
            pytoDocsMod.setObservac(txtObsMod.getText());

            String idArchivo = DriveConnection.getInstance().actualizarArchivo(
                    rutaDocumentoMod,
                    DriveConstants.DRIVE_TYPES.get(((TipoDoc) cmbTDocMod.getModel().getSelectedItem()).getDesTDoc()),
                    pytoDocsMod.getRutaDoc()
            );

            if (idArchivo != null) {

                String msj = PytoDocsController.getInstance().actualizarPytoDocs(pytoDocsMod);

                if (msj.equals("Documento actualizado correctamente")) {

                    JOptionPane.showMessageDialog(panelSoporte, msj);
                    panelInsertar.setVisible(false);
                    panelBuscar.setVisible(true);
                    panelMantenimiento.setVisible(false);
                    panelModificar.setVisible(false);
                    llenarTabla(PytoDocsDAOImple.getInstance().listar());
                    resetFormModificar();

                } else {
                    JOptionPane.showMessageDialog(panelSoporte, msj, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(panelSoporte, "No se pudo subir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIngresar1MouseClicked

    private void btnIngresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar1MouseEntered

    private void btnIngresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar1MouseExited

    private void btn_abrirdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirdocActionPerformed
        // TODO add your handling code here:

        //abrir documento
    }//GEN-LAST:event_btn_abrirdocActionPerformed

    private void txt_fechaFinPytoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaFinPytoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaFinPytoActionPerformed

    private void btnEliminarDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDocsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablaDocs.getSelectedRow();
        if (selectedRow >= 0) {

            int codPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 0);
            int corrPyto = (int) tablaDocs.getModel().getValueAt(selectedRow, 1);

            PytoDocsDAO pytoDocsDAO = PytoDocsDAOImple.getInstance();

            String msj = pytoDocsDAO.eliminar(codPyto, corrPyto);
            if (msj.equals("Eliminacion Correcta")) {
                JOptionPane.showMessageDialog(panelSoporte, msj);
                llenarTabla(PytoDocsDAOImple.getInstance().listar());
            } else {
                JOptionPane.showMessageDialog(panelSoporte, msj, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnEliminarDocsActionPerformed

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

        tTipoEntreg.setModel(TableModelCreator.createTableModel(TipoEntreg.class, lista));
    }

    public void llenarTablaTipoDoc(List<TipoDoc> lista) {
        TipoDocTable.setModel(TableModelCreator.createTableModel(TipoDoc.class, lista));
    }

    public void llenarTablaNivel(List<Nivel> lista) {
        NivelTable.setModel(TableModelCreator.createTableModel(Nivel.class, lista));
    }

    public void llenarTablaFase(List<Fase> lista) {
        FaseTable.setModel(TableModelCreator.createTableModel(Fase.class, lista));
    }

    public void llenarTablaEstado(List<Estado> lista) {
        EstadoTable.setModel(TableModelCreator.createTableModel(Estado.class, lista));
    }

    public void llenarTablaEntregables(List<Entregables> lista) {
        EntregablesTable.setModel(TableModelCreator.createTableModel(Entregables.class, lista));
    }

    private void llenarCombos() {
        EstadoDAOImple.getInstance().listarEntity().forEach((item) -> cmbEstado.addItem(item));
        EntregablesDAOImple.getInstance().listar().forEach((Entregables item) -> cmbTEntregable.addItem(item));
        TipoDocDAOImple.getInstance().listar().forEach((item) -> {
            cmbTDoc.addItem(item);
            cmbTDocMod.addItem(item);
        });
    }

    private void llenarComboNivel() {

        NivelComboBox1.removeAllItems();
        NivelComboBox2.removeAllItems();

        FaseDAOImple.getInstance().listar().forEach((item) -> NivelComboBox1.addItem(item));
        FaseDAOImple.getInstance().listar().forEach((item) -> NivelComboBox2.addItem(item));

    }

    private void llenarComboEstado() {

        EstadoComboBox1.removeAllItems();
        EstadoComboBox2.removeAllItems();

        NivelDAOImple.getInstance().listar().forEach((item) -> EstadoComboBox1.addItem(item));
        NivelDAOImple.getInstance().listar().forEach((item) -> EstadoComboBox2.addItem(item));
    }

    public void llenarComboEntregables() {

        EntregablesComboBox1.removeAllItems();
        EntregablesComboBox2.removeAllItems();

        TipoEntregDAOImple.getInstance().listarEntity().forEach((item) -> EntregablesComboBox1.addItem(item));
        TipoEntregDAOImple.getInstance().listarEntity().forEach((item) -> EntregablesComboBox2.addItem(item));
    }

    private void resetCombos() {
        cmbEstado.removeAllItems();
        cmbTEntregable.removeAllItems();
        cmbTDoc.removeAllItems();
        cmbTDocMod.removeAllItems();
    }

    private void resetFormIngresar() {
        cmbProyecto.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        spnFInicio.setValue(new Date());
        spnFFin.setValue(new Date());
        txtCostoEstimado.setText(null);
        cmbTDoc.setSelectedIndex(0);
        txtVersion.setText(null);
        txtObs.setText(null);
        cmbTEntregable.setSelectedIndex(0);
        rutaDocumento = null;
    }

    private void resetFormModificar() {

        spnFFinMod.setValue(new Date());
        txtCostoEstimadoMod.setText(null);
        cmbTDocMod.setSelectedIndex(0);
        txtVersionMod.setText(null);
        txtObsMod.setText(null);
        rutaDocumentoMod = null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EdicionEntregables;
    private javax.swing.JPanel EdicionEstado;
    private javax.swing.JPanel EdicionFase;
    private javax.swing.JPanel EdicionNivel;
    private javax.swing.JPanel EdicionTipoDoc;
    private javax.swing.JPanel EdicionTipoEntreg;
    private javax.swing.JComboBox<TipoEntreg> EntregablesComboBox1;
    private javax.swing.JComboBox<TipoEntreg> EntregablesComboBox2;
    private javax.swing.JTable EntregablesTable;
    private javax.swing.JTextArea EntregablesTextArea1;
    private javax.swing.JTextArea EntregablesTextArea2;
    private javax.swing.JTextField EntregablesTextField1;
    private javax.swing.JTextField EntregablesTextField2;
    private javax.swing.JComboBox<Nivel> EstadoComboBox1;
    private javax.swing.JComboBox<Nivel> EstadoComboBox2;
    private javax.swing.JLabel EstadoLabel;
    private javax.swing.JTable EstadoTable;
    private javax.swing.JTextArea EstadoTextArea1;
    private javax.swing.JTextArea EstadoTextArea2;
    private javax.swing.JTextField EstadoTextField1;
    private javax.swing.JTextField EstadoTextField2;
    private javax.swing.JTextField EstadoTextField3;
    private javax.swing.JLabel FaseLabel;
    private javax.swing.JTable FaseTable;
    private javax.swing.JTextArea FaseTextArea1;
    private javax.swing.JTextArea FaseTextArea2;
    private javax.swing.JTextField FaseTextField1;
    private javax.swing.JTextField FaseTextField2;
    private javax.swing.JTextField FaseTextField3;
    private javax.swing.JPanel GestionarEntregables;
    private javax.swing.JPanel GestionarEstado;
    private javax.swing.JPanel GestionarFase;
    private javax.swing.JPanel GestionarNivel;
    private javax.swing.JPanel GestionarTipoDoc;
    private javax.swing.JPanel GestionarTipoEntreg;
    private javax.swing.JComboBox<Fase> NivelComboBox1;
    private javax.swing.JComboBox<Fase> NivelComboBox2;
    private javax.swing.JLabel NivelLabel;
    private javax.swing.JTable NivelTable;
    private javax.swing.JTextArea NivelTextArea1;
    private javax.swing.JTextArea NivelTextArea2;
    private javax.swing.JTextField NivelTextField1;
    private javax.swing.JTextField NivelTextField2;
    private javax.swing.JTextField NivelTextField3;
    private javax.swing.JTextField NivelTextField4;
    private javax.swing.JTextField NivelTextField5;
    private javax.swing.JPanel RegistrarEntregables;
    private javax.swing.JPanel RegistrarEstado;
    private javax.swing.JPanel RegistrarFase;
    private javax.swing.JPanel RegistrarNivel;
    private javax.swing.JPanel RegistrarTipoDoc;
    private javax.swing.JPanel RegistrarTipoEntreg;
    private javax.swing.JTabbedPane TPaneEntregables;
    private javax.swing.JTabbedPane TPaneEstado;
    private javax.swing.JTabbedPane TPaneFase;
    private javax.swing.JTabbedPane TPaneNivel;
    private javax.swing.JTabbedPane TPaneTipoDoc;
    private javax.swing.JTabbedPane TPaneTipoEntreg;
    private javax.swing.JLabel TipoDocLabel;
    private javax.swing.JTable TipoDocTable;
    private javax.swing.JTextArea TipoDocTextArea1;
    private javax.swing.JTextArea TipoDocTextArea2;
    private javax.swing.JTextField TipoDocTextField1;
    private javax.swing.JTextField TipoDocTextField2;
    private javax.swing.JTextField TipoDocTextField3;
    private javax.swing.JLabel TipoEntregLabel;
    private javax.swing.JTextArea TipoEntregTextArea1;
    private javax.swing.JTextArea TipoEntregTextArea2;
    private javax.swing.JTextField TipoEntregTextField1;
    private javax.swing.JTextField TipoEntregTextField2;
    private javax.swing.JTextField TipoEntregTextField3;
    private javax.swing.JPanel background;
    private javax.swing.JMenuItem btnActualizarDocs;
    private javax.swing.JPanel btnBuscarDocs;
    private javax.swing.JMenuItem btnDetalles;
    private javax.swing.JMenuItem btnEliminarDocs;
    private javax.swing.JPanel btnEntregables;
    private javax.swing.JPanel btnEstado;
    private javax.swing.JPanel btnFase;
    private javax.swing.JPanel btnIngresar;
    private javax.swing.JPanel btnIngresar1;
    private javax.swing.JPanel btnInsertarDoc;
    private javax.swing.JPanel btnMantenimiento;
    private javax.swing.JPanel btnNivel;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSubDoc;
    private javax.swing.JButton btnSubDocMod;
    private javax.swing.JPanel btnTipoDoc;
    private javax.swing.JPanel btnTipoEntreg;
    private javax.swing.JButton btn_abrirdoc;
    private javax.swing.JTextField caja_busqueda;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JCheckBox chkVigencia1;
    private javax.swing.JComboBox<Integer> cmbEspecialista;
    private javax.swing.JComboBox<Integer> cmbEspecialistaMod;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.JComboBox<Integer> cmbProyecto;
    private javax.swing.JComboBox<Integer> cmbResponsable;
    private javax.swing.JComboBox<Integer> cmbResponsableMod;
    private javax.swing.JComboBox<TipoDoc> cmbTDoc;
    private javax.swing.JComboBox<TipoDoc> cmbTDocMod;
    private javax.swing.JComboBox<Entregables> cmbTEntregable;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
    private javax.swing.JPanel header3;
    private javax.swing.JPanel header4;
    private javax.swing.JPanel header5;
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
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCostoEstimado;
    private javax.swing.JLabel lbCostoEstimado1;
    private javax.swing.JLabel lbCostoEstimado2;
    private javax.swing.JLabel lbCostoEstimado3;
    private javax.swing.JLabel lbEspecialista;
    private javax.swing.JLabel lbEspecialista1;
    private javax.swing.JLabel lbFFin;
    private javax.swing.JLabel lbFFin1;
    private javax.swing.JLabel lbFInicio;
    private javax.swing.JLabel lbFase;
    private javax.swing.JLabel lbObservaciones;
    private javax.swing.JLabel lbObservaciones1;
    private javax.swing.JLabel lbProyecto;
    private javax.swing.JLabel lbResponsable;
    private javax.swing.JLabel lbResponsable1;
    private javax.swing.JLabel lbRuta;
    private javax.swing.JLabel lbRuta1;
    private javax.swing.JLabel lbTEntregable;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JLabel lbVersion1;
    private javax.swing.JLayeredPane mainPane;
    private javax.swing.JPopupMenu menuOps;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatosPyto;
    private javax.swing.JPanel panelDatosPyto1;
    private javax.swing.JPanel panelDetalles;
    private javax.swing.JPanel panelInsertar;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JPanel panelSoporte;
    private javax.swing.JPanel panelSubida;
    private javax.swing.JPanel panelSubida1;
    private javax.swing.JPanel sideBar;
    private javax.swing.JSpinner spnFFin;
    private javax.swing.JSpinner spnFFinMod;
    private javax.swing.JSpinner spnFInicio;
    private javax.swing.JTable tTipoEntreg;
    private javax.swing.JTable tablaDocs;
    private javax.swing.JTextField txtCostoEstimado;
    private javax.swing.JTextField txtCostoEstimadoMod;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextArea txtObsMod;
    private javax.swing.JTextField txtVersion;
    private javax.swing.JTextField txtVersionMod;
    private javax.swing.JTextField txt_codDocPyto;
    private javax.swing.JTextField txt_costoPyto;
    private javax.swing.JTextField txt_fasePyto;
    private javax.swing.JTextField txt_fechaFinPyto;
    private javax.swing.JTextField txt_fechaInicPyto;
    private javax.swing.JTextField txt_nivelPyto;
    private javax.swing.JTextField txt_nombDocPyto;
    private javax.swing.JTextField txt_nombPyto;
    private javax.swing.JTextArea txt_obsDocPyto;
    // End of variables declaration//GEN-END:variables
}
