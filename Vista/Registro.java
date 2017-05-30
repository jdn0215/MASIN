package Vista;

import Control.Control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public final class Registro extends javax.swing.JFrame
{
  public vistaOpciones opciones;
  Control control;
  public boolean modo = false;
  public String detalle = "";
  Busqueda parent = null;
  public JTextField CL; public JTextField INSUB; public JTextField LPCL; public JTextField LPUT; public JTextField PAL; public JRadioButton SCA; public JTextField UT; private JButton add; private JRadioButton botonFemenino; public JRadioButton botonMasculino; private JRadioButton botonPrivado; public JRadioButton botonPublico; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2;
  public Registro(String id, Busqueda b) { initComponents();
    set();
    iniciarRevision();
    opciones = new vistaOpciones(this, true);
    control = new Control(this);
    setDefaultCloseOperation(3);
    java.awt.Image ico = Toolkit.getDefaultToolkit().getImage(getClass().getResource("registro.png"));
    setIconImage(ico);
    modo = true;
    parent = b;
    control.load(id);
    textId.setEnabled(false);
    clear.setText("ELIMINAR");
    save.setText("GUARDAR CAMBIOS"); }
  
  private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; public JRadioButton cca; private JButton clear; public JComboBox comboNivel; private JLabel jLabel1;
  public Registro() { initComponents();
    set();
    iniciarRevision();
    control = new Control(this);
    setDefaultCloseOperation(3);
    java.awt.Image ico = Toolkit.getDefaultToolkit().getImage(getClass().getResource("registro.png"));
    setIconImage(ico);
    opciones = new vistaOpciones(this, true); }
  
  private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel7;
  void iniciarRevision() { Revisarformato r = new Revisarformato(this);
    Thread t = new Thread(r);
    t.start(); }
  
  private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel3; private JPanel jPanel5;
  void set() { setDimensiones();
    setResizable(false);
    setTitle("AÑADIR REDACCION");
    texto.setColumns(5);
    texto.setLineWrap(true);
    ajustarApariencia();
    javax.swing.SwingUtilities.updateComponentTreeUI(this);
    setVisible(true);
    getContentPane().setBackground(new Color(144, 210, 255));
    repaint();
    tipoAdec.setEditable(false);
    comboNivel.setEditable(false);
    procesar.setEnabled(true);
    save.setEnabled(false); }
  
  private javax.swing.JScrollPane jScrollPane1;
  private JSeparator jSeparator1; private JSeparator jSeparator2; private javax.swing.JSpinner jSpinner1; public JLabel labelApellido;
  void ajustarApariencia() { try { javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (InstantiationException ex) {}catch (ClassNotFoundException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); } }
  
  public JLabel labelCentro;
  public JLabel labelDetalle; private JLabel labelId; private JLabel labelId1; private JLabel labelId3;
  void setDimensiones() { int ancho = getDefaultToolkitgetScreenSizewidth;
    int alto = getDefaultToolkitgetScreenSizeheight;
    setBounds(ancho / 8 - getWidth() / 8, alto / 4 - getHeight() / 4, 1300, 700); }
  
  private JLabel labelPrivado;
  public JLabel labelSiglas;
  public JLabel label_Id;
  public JLabel labelname;
  public JLabel mensaje$;
  public JLabel mensajeG;
  public JLabel mensajeM;
  public JRadioButton noAdec;
  public JButton procesar;
  private void initComponents() { jSpinner1 = new javax.swing.JSpinner();
    buttonGroup1 = new ButtonGroup();
    buttonGroup2 = new ButtonGroup();
    buttonGroup3 = new ButtonGroup();
    buttonGroup4 = new ButtonGroup();
    jPanel5 = new JPanel();
    labelname = new JLabel();
    labelId = new JLabel();
    labelApellido = new JLabel();
    textName = new JTextField();
    textA2 = new JTextField();
    textId = new JTextField();
    jSeparator1 = new JSeparator();
    botonMasculino = new JRadioButton();
    botonFemenino = new JRadioButton();
    labelCentro = new JLabel();
    labelSiglas = new JLabel();
    labelPrivado = new JLabel();
    botonPublico = new JRadioButton();
    textSiglas = new JTextField();
    textCentro = new JTextField();
    botonPrivado = new JRadioButton();
    labelId3 = new JLabel();
    cca = new JRadioButton();
    SCA = new JRadioButton();
    labelDetalle = new JLabel();
    noAdec = new JRadioButton();
    siA = new JRadioButton();
    tipoAdec = new JComboBox();
    jLabel3 = new JLabel();
    label_Id = new JLabel();
    comboNivel = new JComboBox();
    textA = new JTextField();
    labelId1 = new JLabel();
    textoEdad = new JTextField();
    add = new JButton();
    jPanel1 = new JPanel();
    mensaje$ = new JLabel();
    mensajeM = new JLabel();
    mensajeG = new JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    texto = new JTextArea();
    clear = new JButton();
    procesar = new JButton();
    save = new JButton();
    regresar = new JButton();
    jPanel3 = new JPanel();
    jLabel1 = new JLabel();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    jLabel6 = new JLabel();
    UT = new JTextField();
    CL = new JTextField();
    PAL = new JTextField();
    jLabel7 = new JLabel();
    LPUT = new JTextField();
    jLabel8 = new JLabel();
    LPCL = new JTextField();
    jLabel9 = new JLabel();
    INSUB = new JTextField();
    jSeparator2 = new JSeparator();
    
    setDefaultCloseOperation(3);
    setResizable(false);
    
    jPanel5.setBackground(new Color(202, 210, 255));
    jPanel5.setBorder(new SoftBevelBorder(0));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    
    labelname.setText("Nombre:");
    jPanel5.add(labelname, new AbsoluteConstraints(13, 26, 59, 27));
    
    labelId.setText("EDAD:");
    jPanel5.add(labelId, new AbsoluteConstraints(130, 120, -1, 27));
    
    labelApellido.setText("Apellido:");
    jPanel5.add(labelApellido, new AbsoluteConstraints(13, 59, 59, 27));
    
    textName.setFont(new Font("Verdana", 0, 12));
    textName.setSelectionColor(new Color(153, 153, 255));
    textName.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textNameMouseClicked(evt);
      }
    });
    textName.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textNameActionPerformed(evt);
      }
    });
    jPanel5.add(textName, new AbsoluteConstraints(103, 27, 170, -1));
    
    textA2.setFont(new Font("Verdana", 0, 12));
    textA2.setSelectionColor(new Color(153, 153, 255));
    textA2.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textA2MouseClicked(evt);
      }
    });
    textA2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textA2ActionPerformed(evt);
      }
    });
    jPanel5.add(textA2, new AbsoluteConstraints(190, 60, 80, -1));
    
    textId.setFont(new Font("Verdana", 0, 12));
    textId.setSelectionColor(new Color(153, 153, 255));
    textId.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textIdMouseClicked(evt);
      }
    });
    textId.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textIdActionPerformed(evt);
      }
    });
    jPanel5.add(textId, new AbsoluteConstraints(102, 93, 151, -1));
    jPanel5.add(jSeparator1, new AbsoluteConstraints(20, 300, 240, 10));
    
    buttonGroup1.add(botonMasculino);
    botonMasculino.setSelected(true);
    botonMasculino.setText("Masculino");
    botonMasculino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.botonMasculinoActionPerformed(evt);
      }
    });
    jPanel5.add(botonMasculino, new AbsoluteConstraints(100, 270, -1, -1));
    
    buttonGroup1.add(botonFemenino);
    botonFemenino.setText("Femenino");
    jPanel5.add(botonFemenino, new AbsoluteConstraints(180, 270, -1, -1));
    
    labelCentro.setText("Centro Educativo:");
    jPanel5.add(labelCentro, new AbsoluteConstraints(10, 310, -1, 27));
    
    labelSiglas.setText("Siglas");
    jPanel5.add(labelSiglas, new AbsoluteConstraints(10, 340, 59, 27));
    
    labelPrivado.setText("Tipo:");
    jPanel5.add(labelPrivado, new AbsoluteConstraints(10, 360, -1, 27));
    
    buttonGroup2.add(botonPublico);
    botonPublico.setSelected(true);
    botonPublico.setText("Público");
    botonPublico.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.botonPublicoActionPerformed(evt);
      }
    });
    jPanel5.add(botonPublico, new AbsoluteConstraints(70, 370, -1, -1));
    
    textSiglas.setFont(new Font("Verdana", 0, 12));
    textSiglas.setSelectionColor(new Color(153, 153, 255));
    textSiglas.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textSiglasMouseClicked(evt);
      }
    });
    textSiglas.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textSiglasActionPerformed(evt);
      }
    });
    jPanel5.add(textSiglas, new AbsoluteConstraints(120, 340, 151, -1));
    
    textCentro.setFont(new Font("Verdana", 0, 12));
    textCentro.setSelectionColor(new Color(153, 153, 255));
    textCentro.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textCentroMouseClicked(evt);
      }
    });
    textCentro.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textCentroActionPerformed(evt);
      }
    });
    jPanel5.add(textCentro, new AbsoluteConstraints(120, 310, 151, -1));
    
    buttonGroup2.add(botonPrivado);
    botonPrivado.setText("Privado");
    botonPrivado.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.botonPrivadoActionPerformed(evt);
      }
    });
    jPanel5.add(botonPrivado, new AbsoluteConstraints(140, 370, -1, -1));
    
    labelId3.setText("Sexo:");
    jPanel5.add(labelId3, new AbsoluteConstraints(10, 270, -1, 27));
    
    buttonGroup3.add(cca);
    cca.setText("CCA");
    cca.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.ccaActionPerformed(evt);
      }
    });
    jPanel5.add(cca, new AbsoluteConstraints(10, 170, 50, 20));
    
    buttonGroup3.add(SCA);
    SCA.setSelected(true);
    SCA.setText("SCA");
    SCA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.SCAActionPerformed(evt);
      }
    });
    jPanel5.add(SCA, new AbsoluteConstraints(10, 150, -1, -1));
    
    labelDetalle.setText("Detalle:");
    jPanel5.add(labelDetalle, new AbsoluteConstraints(60, 180, -1, -1));
    
    buttonGroup4.add(noAdec);
    noAdec.setSelected(true);
    noAdec.setText("No posee Adecuación curricular ");
    noAdec.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.noAdecActionPerformed(evt);
      }
    });
    jPanel5.add(noAdec, new AbsoluteConstraints(10, 220, -1, -1));
    
    buttonGroup4.add(siA);
    siA.setText("Posee Adecuación curricular ");
    siA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.siAActionPerformed(evt);
      }
    });
    jPanel5.add(siA, new AbsoluteConstraints(10, 240, -1, -1));
    
    tipoAdec.setEditable(true);
    tipoAdec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Significativa", "No significativa", "De acceso" }));
    tipoAdec.setEnabled(false);
    tipoAdec.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.tipoAdecActionPerformed(evt);
      }
    });
    jPanel5.add(tipoAdec, new AbsoluteConstraints(200, 240, 120, -1));
    
    jLabel3.setFont(new Font("Arial", 1, 14));
    jLabel3.setText("Información Personal");
    jPanel5.add(jLabel3, new AbsoluteConstraints(67, 3, -1, -1));
    
    label_Id.setText("Identificación:");
    jPanel5.add(label_Id, new AbsoluteConstraints(13, 92, -1, 27));
    
    comboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7mo", "8vo", "9no", "10mo", "11mo", "12vo", "Otro" }));
    comboNivel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.comboNivelActionPerformed(evt);
      }
    });
    jPanel5.add(comboNivel, new AbsoluteConstraints(60, 120, -1, -1));
    
    textA.setFont(new Font("Verdana", 0, 12));
    textA.setSelectionColor(new Color(153, 153, 255));
    textA.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textAMouseClicked(evt);
      }
    });
    textA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textAActionPerformed(evt);
      }
    });
    jPanel5.add(textA, new AbsoluteConstraints(103, 60, 80, -1));
    
    labelId1.setText("NIVEL:");
    jPanel5.add(labelId1, new AbsoluteConstraints(20, 120, -1, 27));
    
    textoEdad.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textoEdadMouseClicked(evt);
      }
    });
    textoEdad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.textoEdadActionPerformed(evt);
      }
    });
    jPanel5.add(textoEdad, new AbsoluteConstraints(180, 120, 30, -1));
    
    add.setText("AGREGAR");
    add.setEnabled(false);
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.addActionPerformed(evt);
      }
    });
    jPanel5.add(add, new AbsoluteConstraints(100, 180, 130, -1));
    
    jPanel1.setBackground(new Color(144, 210, 255));
    
    mensaje$.setFont(new Font("Tahoma", 0, 12));
    mensaje$.setForeground(new Color(255, 0, 0));
    mensaje$.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    
    mensajeM.setFont(new Font("Tahoma", 0, 12));
    mensajeM.setForeground(new Color(255, 0, 51));
    mensajeM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    
    mensajeG.setFont(new Font("Tahoma", 0, 12));
    mensajeG.setForeground(new Color(255, 0, 0));
    mensajeG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    
    texto.setColumns(20);
    texto.setFont(new Font("Verdana", 0, 13));
    texto.setRows(5);
    texto.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Registro.this.textoMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(texto);
    
    clear.setText("LIMPIAR VENTANA");
    clear.setBorder(new SoftBevelBorder(0));
    clear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.clearActionPerformed(evt);
      }
      
    });
    procesar.setText("PROCESAR");
    procesar.setBorder(new SoftBevelBorder(0));
    procesar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.procesarActionPerformed(evt);
      }
      
    });
    save.setText("GUARDAR RESULTADOS");
    save.setBorder(new SoftBevelBorder(0));
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.saveActionPerformed(evt);
      }
      
    });
    regresar.setText("REGRESAR");
    regresar.setBorder(new SoftBevelBorder(0));
    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Registro.this.regresarActionPerformed(evt);
      }
      
    });
    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(24, 24, 24)
      .addComponent(jScrollPane1, -2, 755, -2))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(47, 47, 47)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(mensaje$, -2, 150, -2)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(mensajeM, -2, 150, -2))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(clear, -2, 161, -2)
      .addGap(18, 18, 18)
      .addComponent(procesar, -2, 118, -2)))
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(mensajeG, -2, 150, -2)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(save, -2, 198, -2)
      .addGap(18, 18, 18)
      .addComponent(regresar, -2, 118, -2)))))
      .addGap(29, 29, 29)));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(jScrollPane1, -2, 578, -2)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(mensajeM, -2, 16, -2)
      .addComponent(mensaje$, -2, 16, -2)
      .addComponent(mensajeG, -2, 16, -2))
      .addGap(18, 18, 18)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(save, -2, 34, -2)
      .addComponent(regresar, -2, 34, -2))
      .addComponent(procesar, GroupLayout.Alignment.TRAILING, -2, 34, -2)
      .addComponent(clear, GroupLayout.Alignment.TRAILING, -2, 31, -2))
      .addGap(12, 12, 12)));
    

    jPanel3.setBackground(new Color(202, 210, 255));
    jPanel3.setBorder(new SoftBevelBorder(0));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    
    jLabel1.setFont(new Font("Arial", 1, 14));
    jLabel1.setText("Resultados ");
    jPanel3.add(jLabel1, new AbsoluteConstraints(110, 10, -1, -1));
    
    jLabel4.setText("UT:");
    jPanel3.add(jLabel4, new AbsoluteConstraints(50, 40, -1, -1));
    
    jLabel5.setText("CL:");
    jPanel3.add(jLabel5, new AbsoluteConstraints(50, 90, -1, -1));
    
    jLabel6.setText("PAL:");
    jPanel3.add(jLabel6, new AbsoluteConstraints(50, 140, -1, -1));
    
    UT.setEditable(false);
    jPanel3.add(UT, new AbsoluteConstraints(50, 60, 90, -1));
    
    CL.setEditable(false);
    jPanel3.add(CL, new AbsoluteConstraints(50, 110, 90, -1));
    
    PAL.setEditable(false);
    jPanel3.add(PAL, new AbsoluteConstraints(50, 160, 90, -1));
    
    jLabel7.setText("LP-UT:");
    jPanel3.add(jLabel7, new AbsoluteConstraints(160, 40, -1, -1));
    
    LPUT.setEditable(false);
    jPanel3.add(LPUT, new AbsoluteConstraints(160, 60, 100, -1));
    
    jLabel8.setText("LP-CL:");
    jPanel3.add(jLabel8, new AbsoluteConstraints(160, 90, -1, -1));
    
    LPCL.setEditable(false);
    jPanel3.add(LPCL, new AbsoluteConstraints(160, 110, 100, -1));
    
    jLabel9.setText("IN-SUB:");
    jPanel3.add(jLabel9, new AbsoluteConstraints(160, 140, -1, -1));
    
    INSUB.setEditable(false);
    jPanel3.add(INSUB, new AbsoluteConstraints(160, 160, 100, -1));
    
    jSeparator2.setOrientation(1);
    jPanel3.add(jSeparator2, new AbsoluteConstraints(150, 30, -1, 150));
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jPanel5, -1, -1, 32767)
      .addComponent(jPanel3, -1, -1, 32767))
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jPanel1, -2, 786, -2)
      .addContainerGap()));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(jPanel5, -2, -1, -2)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(jPanel3, -2, 192, -2))
      .addComponent(jPanel1, -2, -1, -2))
      .addContainerGap(58, 32767)));
    

    pack();
  }
  

  private JButton regresar;
  
  public JButton save;
  
  public JRadioButton siA;
  public JTextField textA;
  public JTextField textA2;
  public JTextField textCentro;
  public JTextField textId;
  public JTextField textName;
  public JTextField textSiglas;
  public JTextArea texto;
  public JTextField textoEdad;
  public JComboBox tipoAdec;
  private void textNameActionPerformed(ActionEvent evt) {}
  
  private void textA2ActionPerformed(ActionEvent evt) {}
  
  private void textIdActionPerformed(ActionEvent evt) {}
  
  private void botonMasculinoActionPerformed(ActionEvent evt) {}
  
  private void botonPublicoActionPerformed(ActionEvent evt) {}
  
  private void textSiglasActionPerformed(ActionEvent evt) {}
  
  private void textCentroActionPerformed(ActionEvent evt) {}
  
  private void botonPrivadoActionPerformed(ActionEvent evt) {}
  
  private void noAdecActionPerformed(ActionEvent evt)
  {
    tipoAdec.setEnabled(siA.isSelected()); }
  

  private void siAActionPerformed(ActionEvent evt) {
    tipoAdec.setEnabled(siA.isSelected());
  }
  
  private void procesarActionPerformed(ActionEvent evt) {
    control.procesar();
  }
  
  private void ccaActionPerformed(ActionEvent evt) {
    add.setEnabled(cca.isSelected());
  }
  
  private void SCAActionPerformed(ActionEvent evt) {
    add.setEnabled(cca.isSelected());
  }
  

  private void tipoAdecActionPerformed(ActionEvent evt) {}
  
  private void clearActionPerformed(ActionEvent evt)
  {
    if (!modo) { control.clear();
    } else {
      int opc = javax.swing.JOptionPane.showConfirmDialog(javax.swing.JOptionPane.getRootFrame(), "¿DESEA ELIMINAR EL REGISTRO POR COMPLETO?");
      
      if (opc == 0) {
        control.remove();
        setVisible(false);
        parent.dispose();
        parent = new Busqueda();
        parent.jButton3.doClick();
        dispose();
      }
    }
  }
  
  private void saveActionPerformed(ActionEvent evt) {
    if (modo) {
      control.update();
      setVisible(false);
      parent.dispose();
      parent = new Busqueda();
      parent.jButton3.doClick();
      dispose();
    } else {
      control.save();
    }
  }
  
  private void textoMouseClicked(MouseEvent evt) { mensajeG.setText(""); }
  
  private void textNameMouseClicked(MouseEvent evt)
  {
    textName.setBackground(new Color(254, 254, 254));
  }
  
  private void textA2MouseClicked(MouseEvent evt) {
    textA2.setBackground(new Color(254, 254, 254));
  }
  
  private void textIdMouseClicked(MouseEvent evt) {
    textId.setBackground(new Color(254, 254, 254));
  }
  
  private void textCentroMouseClicked(MouseEvent evt) {
    textCentro.setBackground(new Color(254, 254, 254));
  }
  
  private void textSiglasMouseClicked(MouseEvent evt) {
    textSiglas.setBackground(new Color(254, 254, 254));
  }
  
  private void regresarActionPerformed(ActionEvent evt) {
    setVisible(false);
    
    if (modo)
      parent.setVisible(true); else
      Vista localVista = new Vista();
    dispose();
  }
  
  private void textAMouseClicked(MouseEvent evt) {
    textA.setBackground(new Color(254, 254, 254));
  }
  

  private void textAActionPerformed(ActionEvent evt) {}
  
  private void textoEdadMouseClicked(MouseEvent evt)
  {
    textoEdad.setBackground(new Color(254, 254, 254));
  }
  

  private void textoEdadActionPerformed(ActionEvent evt) {}
  
  private void addActionPerformed(ActionEvent evt)
  {
    opciones.setVisible(true);
  }
  
  private void comboNivelActionPerformed(ActionEvent evt) {}
}
