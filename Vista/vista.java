package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Vista extends javax.swing.JFrame
{
  private JButton jButton1;
  private JButton jButton3;
  private JButton jButton4;
  private JLabel jLabel1;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  
  public Vista()
  {
    initComponents();
    setTitle("VENTANA PRINCIPAL");
    try {
      javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (InstantiationException ex) {}catch (ClassNotFoundException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    setVisible(true);
    setResizable(false);
    setLocation(500, 100);
    setDefaultCloseOperation(3);
    java.awt.Image ico = java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png"));
    setIconImage(ico);
    getContentPane().setBackground(new Color(202, 232, 255));
  }
  







  private void initComponents()
  {
    jPanel1 = new javax.swing.JPanel();
    jButton1 = new JButton();
    jLabel1 = new JLabel();
    jLabel4 = new JLabel();
    jButton3 = new JButton();
    jLabel5 = new JLabel();
    jButton4 = new JButton();
    
    setDefaultCloseOperation(3);
    setBackground(new Color(202, 232, 255));
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    
    jPanel1.setBackground(new Color(202, 232, 255));
    
    jButton1.setBackground(new Color(202, 210, 255));
    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/registro.png")));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Vista.this.jButton1ActionPerformed(evt);
      }
      
    });
    jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
    jLabel1.setText("Nueva");
    
    jLabel4.setFont(new java.awt.Font("Verdana", 1, 14));
    jLabel4.setText("Redacción");
    
    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(jButton1)
      .addGap(1, 1, 1)
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1)
      .addComponent(jLabel4))));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jButton1)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(40, 40, 40)
      .addComponent(jLabel1)
      .addGap(2, 2, 2)
      .addComponent(jLabel4)));
    

    getContentPane().add(jPanel1, new AbsoluteConstraints(10, 100, -1, -1));
    
    jButton3.setBackground(new Color(202, 210, 255));
    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icon.png")));
    jButton3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icon.png")));
    jButton3.setEnabled(false);
    getContentPane().add(jButton3, new AbsoluteConstraints(217, 11, 300, 394));
    
    jLabel5.setFont(new java.awt.Font("Verdana", 1, 14));
    jLabel5.setText("Busqueda");
    getContentPane().add(jLabel5, new AbsoluteConstraints(120, 280, -1, 32));
    
    jButton4.setBackground(new Color(202, 210, 255));
    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/buscar.png")));
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Vista.this.jButton4ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton4, new AbsoluteConstraints(10, 230, 108, 86));
    
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    Registro r = new Registro();
    dispose();
  }
  
  private void jButton4ActionPerformed(ActionEvent evt) {
    Busqueda b = new Busqueda();
    dispose();
  }
}
