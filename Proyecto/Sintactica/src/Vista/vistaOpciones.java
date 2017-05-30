package Vista;

import javax.swing.JCheckBox;

public class vistaOpciones extends javax.swing.JDialog
{
  Registro parent;
  public String[] descripciones;
  public JCheckBox[] opciones;
  public JCheckBox Abulia;
  public JCheckBox Ansiedad;
  public JCheckBox Asperguer;
  public JCheckBox Autoestima;
  public JCheckBox CC;
  public JCheckBox DAH;
  public JCheckBox DAI;
  public JCheckBox DAP;
  public JCheckBox Deficitpragmaticosemantico;
  
  public vistaOpciones(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    this.parent = ((Registro)parent);
    initComponents();
    set();
    iniciarDescripciones();
    iniciarOpciones();
    setTitle("DETALLE CCA");
  }
  
  final void set() { addWindowListener(new java.awt.event.WindowAdapter()
    {
      @Override
      public void windowClosing(java.awt.event.WindowEvent e) {
        parent.detalle = marcadas();
        setVisible(false);
      }
    });
    setLocation(parent.getLocation());
    setSize(parent.getWidth() / 2, parent.getHeight() / 2);
    setResizable(false);
    getContentPane().setBackground(new java.awt.Color(202, 210, 255));
    try {
      javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (InstantiationException ex) {}catch (ClassNotFoundException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    setVisible(false);
  }
  
  final void iniciarDescripciones() { descripciones = new String[20];
    descripciones[0] = "Abulia";
    descripciones[1] = "Ansiedad";
    descripciones[2] = "Asperguer";
    descripciones[3] = "Autoestima";
    descripciones[4] = "Conducta/Comportamiento";
    descripciones[5] = "DAH (déficit atencional con hiperactividad)";
    descripciones[6] = "DAI (déficit atencional con impulsividad)";
    descripciones[7] = "DAP (déficit atencional pasivo)";
    descripciones[8] = "Déficit memoria";
    descripciones[9] = "Déficit pragmático-semántico";
    descripciones[10] = "Depresión";
    descripciones[11] = "Discalculia";
    descripciones[12] = "Disgrafía (motricidad)";
    descripciones[13] = "Dislexia";
    descripciones[14] = "Disortografía";
    descripciones[15] = "Distimia";
    descripciones[16] = "Estrés";
    descripciones[17] = "Pánico";
    descripciones[18] = "TObsesivo/Compulsivo";
    descripciones[19] = "Otro";
  }
  
  final void iniciarOpciones() { opciones = new JCheckBox[20];
    opciones[0] = Abulia;
    opciones[1] = Ansiedad;
    opciones[2] = Asperguer;
    opciones[3] = Autoestima;
    opciones[4] = CC;
    opciones[5] = DAH;
    opciones[6] = DAI;
    opciones[7] = DAP;
    opciones[8] = memoria;
    opciones[9] = Deficitpragmaticosemantico;
    opciones[10] = Depresion;
    opciones[11] = Discalculia;
    opciones[12] = Disgrafía;
    opciones[13] = Dislexia;
    opciones[14] = Disortografìa;
    opciones[15] = Distimia;
    opciones[16] = Estres;
    opciones[17] = Panico;
    opciones[18] = toc;
    opciones[19] = Otro;
  }
  
  String marcadas() { String salida = "";
    for (int i = 0; i < 19; i++)
      if (opciones[i].isSelected())
        salida = salida + " - " + descripciones[i];
    if (opciones[19].isSelected())
      salida = salida + " - *Otro: " + jTextField1.getText();
    return salida; }
  
  public JCheckBox Depresion;
  public JCheckBox Discalculia;
  public JCheckBox Disgrafía;
  
  private void initComponents() { Abulia = new JCheckBox();
    Ansiedad = new JCheckBox();
    Asperguer = new JCheckBox();
    Autoestima = new JCheckBox();
    CC = new JCheckBox();
    DAH = new JCheckBox();
    DAI = new JCheckBox();
    memoria = new JCheckBox();
    Deficitpragmaticosemantico = new JCheckBox();
    Depresion = new JCheckBox();
    Otro = new JCheckBox();
    DAP = new JCheckBox();
    Disgrafía = new JCheckBox();
    Dislexia = new JCheckBox();
    Disortografìa = new JCheckBox();
    Discalculia = new JCheckBox();
    Distimia = new JCheckBox();
    Estres = new JCheckBox();
    Panico = new JCheckBox();
    toc = new JCheckBox();
    jTextField1 = new javax.swing.JTextField();
    ok = new javax.swing.JButton();
    
    Abulia.setText("Abulia");
    
    Ansiedad.setText("Ansiedad");
    
    Asperguer.setText("Asperguer");
    
    Autoestima.setText("Autoestima");
    
    CC.setText("Conducta/Comportamiento");
    
    DAH.setText("DAH  (déficit atencional con hiperactividad)");
    
    DAI.setText("DAI (déficit atencional con impulsividad)");
    
    memoria.setText("Déficit memoria");
    
    Deficitpragmaticosemantico.setText("Déficit pragmático-semántico");
    
    Depresion.setText("Depresión");
    
    Otro.setText("Otro");
    Otro.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        vistaOpciones.this.OtroMouseClicked(evt);
      }
    });
    Otro.addActionListener((java.awt.event.ActionEvent evt) -> {
        vistaOpciones.this.OtroActionPerformed(evt);
  });
    DAP.setText("DAP (déficit atencional pasivo)");
    
    Disgrafía.setText("Disgrafía (motricidad)");
    
    Dislexia.setText("Dislexia");
    
    Disortografìa.setText("Disortografìa");
    
    Discalculia.setText("Discalculia");
    
    Distimia.setText("Distimia");
    
    Estres.setText("Estrés");
    
    Panico.setText("Pánico");
    
    toc.setText("T Obsesivo/ Compulsivo");
    
    jTextField1.setText("¿cual?");
    jTextField1.setEnabled(false);
    
    ok.setText("VOLVER");
    ok.addActionListener((java.awt.event.ActionEvent evt) -> {
        vistaOpciones.this.okActionPerformed(evt);
  });
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGap(70, 70, 70)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Ansiedad)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(DAH)
      .addComponent(CC)
      .addComponent(Autoestima)
      .addComponent(Asperguer)
      .addComponent(DAP)
      .addComponent(memoria)
      .addComponent(DAI)
      .addComponent(Deficitpragmaticosemantico)
      .addComponent(Abulia))
      .addGap(29, 29, 29)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(Depresion)
      .addComponent(Disgrafía)
      .addComponent(Dislexia)
      .addComponent(Estres)
      .addComponent(Distimia)
      .addComponent(Disortografìa)
      .addComponent(toc)
      .addComponent(Discalculia)
      .addComponent(Panico)
      .addGroup(layout.createSequentialGroup()
      .addComponent(Otro)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jTextField1, -2, 88, -2))))))
      .addGroup(layout.createSequentialGroup()
      .addGap(245, 245, 245)
      .addComponent(ok)))
      .addGap(130, 130, 130)));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGap(10, 10, 10)
      .addComponent(Abulia)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Ansiedad)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Asperguer)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Autoestima)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(CC))
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(Depresion)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Discalculia)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Disgrafía)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Dislexia)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Disortografìa)))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(Distimia)
      .addComponent(DAH))
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(DAI)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(DAP)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(memoria)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Deficitpragmaticosemantico))
      .addGroup(layout.createSequentialGroup()
      .addGap(23, 23, 23)
      .addComponent(Estres)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(Panico)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(toc)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(Otro)
      .addComponent(jTextField1, -2, -1, -2))))
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, 32767)
      .addComponent(ok)
      .addGap(87, 87, 87)));
    

    pack(); }
  
  public JCheckBox Dislexia;
  
  private void okActionPerformed(java.awt.event.ActionEvent evt) { parent.detalle = marcadas();
    setVisible(false);
  }
  
  public JCheckBox Disortografìa;
  public JCheckBox Distimia;
  
  private void OtroActionPerformed(java.awt.event.ActionEvent evt) {}
  
  private void OtroMouseClicked(java.awt.event.MouseEvent evt) { if (Otro.isSelected()) {
      jTextField1.setEnabled(true);
      jTextField1.setText("");
    } else {
      jTextField1.setEnabled(false);
      jTextField1.setText("¿Cual?");
    }
  }
  
  public JCheckBox Estres;
  public JCheckBox Otro;
  public JCheckBox Panico;
  public javax.swing.JTextField jTextField1;
  public JCheckBox memoria;
  private javax.swing.JButton ok;
  public JCheckBox toc;
}
