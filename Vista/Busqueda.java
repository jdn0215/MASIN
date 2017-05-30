package Vista;

import IO.FILES;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import modelo.CentroEducativo;
import modelo.Persona;
import modelo.Redaccion;

public class Busqueda extends javax.swing.JFrame
{
  DefaultTableModel tabla = new DefaultTableModel();
  FILES files = new FILES();
  ArrayList<Persona> ps;
  public String reporte;
  public JCheckBox checkAD; public JCheckBox checkCCA; public JCheckBox checkF;
  public Busqueda() { ps = new ArrayList();
    initComponents();
    setLocationRelativeTo(null);
    setExtendedState(6);
    try {
      javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (InstantiationException ex) {}catch (ClassNotFoundException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    setVisible(true);
    titulos();
    jTable1.setAutoResizeMode(2);
    ps = files.busquedaConFiltro(this);
    for (Persona a : ps)
      addPersona(a);
    getContentPane().setBackground(new Color(202, 232, 255)); }
  
  public JCheckBox checkM; public JCheckBox checkNoAd;
  void titulos() { tabla.setColumnIdentifiers(FILES.cols);
    jTable1.setModel(tabla); }
  
  public JCheckBox checkPrivado;
  public JCheckBox checkPublico;
  public void vaciar() { tabla = new DefaultTableModel();
    titulos();
    ps.clear(); }
  
  public JCheckBox checkSCA;
  public void addPersona(Persona p) { if (p == null) return;
    String[] values = new String[20];
    CentroEducativo centro = p.getCentro();
    Redaccion R = p.getRedaccion();
    for (int i = 0; i < FILES.cols.length; i++) {
      switch (i) {
      case 0:  values[i] = p.getId(); break;
      case 1:  values[i] = p.getName(); break;
      case 2:  values[i] = p.getLastName(); break;
      case 3:  values[i] = p.getLastName2(); break;
      case 4:  values[i] = (p.getNivel() > 12 ? "+12" : String.valueOf(p.getNivel())); break;
      case 5:  values[i] = String.valueOf(p.getEdad()); break;
      case 6:  values[i] = (p.isMale() ? "M" : "F"); break;
      case 7:  values[i] = centro.getName(); break;
      case 8:  values[i] = centro.getSiglas(); break;
      case 9:  values[i] = (centro.isPublic() ? "PUBLICO" : "PRIVADO"); break;
      case 10:  values[i] = (p.isCCA() ? "CCA" : "CSA"); break;
      case 11:  values[i] = (p.isCCA() ? p.getCCA_DETALLE() : "-"); break;
      case 12:  values[i] = (p.isAdecuacion() ? "SI" : "NO"); break;
      case 13:  values[i] = (p.isAdecuacion() ? modelo.Info.tipos[p.getTipo()] : "-"); break;
      case 14:  values[i] = String.valueOf(R.getUT()); break;
      case 15:  values[i] = String.valueOf(R.getCL()); break;
      case 16:  values[i] = String.valueOf(R.getPAL()); break;
      case 17:  values[i] = String.valueOf(R.getLPUT()); break;
      case 18:  values[i] = String.valueOf(R.getLPCL()); break;
      case 19:  values[i] = String.valueOf(R.getINSUB());
      }
    }
    tabla.addRow(values);
  }
  
  private JButton jButton1;
  private JButton jButton2;
  public JButton jButton3;
  private JButton jButton4;
  public JComboBox jComboBox1;
  private JLabel jLabel1;
  
  private void initComponents()
  {
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new JTable();
    textoID = new JTextField();
    jButton1 = new JButton();
    jButton2 = new JButton();
    jLabel1 = new JLabel();
    jSeparator1 = new JSeparator();
    checkM = new JCheckBox();
    checkF = new JCheckBox();
    jLabel2 = new JLabel();
    textoCentro = new JTextField();
    checkPrivado = new JCheckBox();
    checkPublico = new JCheckBox();
    checkCCA = new JCheckBox();
    checkSCA = new JCheckBox();
    jButton3 = new JButton();
    checkAD = new JCheckBox();
    checkNoAd = new JCheckBox();
    jComboBox1 = new JComboBox();
    jLabel3 = new JLabel();
    jButton4 = new JButton();
    
    setDefaultCloseOperation(3);
    
    jTable1 = new JTable() {
      public boolean isCellEditable(int r, int c) {
        return false;
      }
    };
    jTable1.setBackground(new Color(202, 210, 255));
    jTable1.setFont(new java.awt.Font("Verdana", 0, 12));
    jTable1.setModel(new DefaultTableModel(new Object[0][], new String[] { "Resultados" })
    {






      boolean[] canEdit = { false };
      

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return canEdit[columnIndex];
      }
    });
    jTable1.setCursor(new java.awt.Cursor(12));
    jTable1.setGridColor(new Color(0, 153, 255));
    jTable1.setSelectionBackground(new Color(0, 51, 204));
    jTable1.getTableHeader().setReorderingAllowed(false);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        Busqueda.this.jTable1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTable1);
    
    jButton1.setText("BUSCAR POR ID");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Busqueda.this.jButton1ActionPerformed(evt);
      }
      
    });
    jButton2.setText("Regresar");
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Busqueda.this.jButton2ActionPerformed(evt);
      }
      
    });
    jLabel1.setText("ID:");
    
    jSeparator1.setOrientation(1);
    
    checkM.setText("Masculino");
    
    checkF.setText("Femenino");
    
    jLabel2.setText("Centro Educativo: ");
    
    checkPrivado.setText("Privado");
    
    checkPublico.setText("Público");
    
    checkCCA.setText("CCA");
    
    checkSCA.setText("SCA");
    
    jButton3.setText("BUSCAR POR FILTRO MULTIPLE");
    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Busqueda.this.jButton3ActionPerformed(evt);
      }
      
    });
    checkAD.setText("Tiene Adecuación");
    
    checkNoAd.setText("No tiene Adecuación");
    
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "7mo", "8vo", "9no", "10mo", "11mo", "12vo", "Otro" }));
    jComboBox1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Busqueda.this.jComboBox1ActionPerformed(evt);
      }
      
    });
    jLabel3.setText("Nivel");
    
    jButton4.setText("Generar Reporte con los resultados");
    jButton4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Busqueda.this.jButton4ActionPerformed(evt);
      }
      
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(jButton2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jButton4)
      .addGap(0, 0, 32767))
      .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
      .addGap(20, 20, 20)
      .addComponent(jLabel1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(textoID, -2, 171, -2)
      .addComponent(jButton1, -2, 143, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jSeparator1, -2, 8, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(jLabel2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(textoCentro, -2, 171, -2))
      .addGroup(layout.createSequentialGroup()
      .addGap(37, 37, 37)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(checkAD)
      .addGroup(layout.createSequentialGroup()
      .addComponent(checkPrivado)
      .addGap(18, 18, 18)
      .addComponent(checkPublico)))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(checkNoAd)))
      .addGap(48, 48, 48)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(checkM)
      .addComponent(checkCCA))
      .addGap(40, 40, 40)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(checkSCA)
      .addComponent(checkF)))
      .addGroup(layout.createSequentialGroup()
      .addComponent(jLabel3)
      .addGap(18, 18, 18)
      .addComponent(jComboBox1, -2, 96, -2)))
      .addGap(0, 138, 32767))
      .addComponent(jButton3, -1, -1, 32767))
      .addContainerGap()));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addGroup(layout.createSequentialGroup()
      .addComponent(jSeparator1, -2, 85, -2)
      .addGap(17, 17, 17))
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(textoCentro, -2, -1, -2)
      .addComponent(jLabel2)
      .addComponent(checkM))
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(checkPrivado)
      .addComponent(checkPublico)
      .addComponent(checkCCA))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, 32767)
      .addComponent(checkAD, -2, 23, -2))
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addGap(0, 0, 32767)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(checkNoAd, -2, 23, -2)
      .addComponent(jComboBox1, -2, -1, -2)
      .addComponent(jLabel3)))))
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(textoID, -2, -1, -2)
      .addComponent(jLabel1))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jButton1))
      .addGroup(layout.createSequentialGroup()
      .addComponent(checkF, -2, 23, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(checkSCA)))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, 32767)
      .addComponent(jButton3)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
      .addComponent(jScrollPane1, -1, 235, 32767)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jButton2)
      .addComponent(jButton4))
      .addContainerGap()));
    

    pack();
  }
  
  void error() { javax.swing.JOptionPane.showMessageDialog(null, "NINGUN RESULTADO COINCIDE CON EL CIRTERIO DE BUSQUEDA", "SIN RESULTADOS", 1); }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    vaciar();
    Persona p = files.getById(textoID.getText());
    if (p == null) { error();
    } else {
      ps.add(p);
      addPersona(p); } }
  
  private JLabel jLabel2;
  private JLabel jLabel3;
  
  private void jButton2ActionPerformed(ActionEvent evt) { setVisible(false);
    Vista v = new Vista();
    dispose(); }
  
  private javax.swing.JScrollPane jScrollPane1;
  
  private void jButton3ActionPerformed(ActionEvent evt) { vaciar();
    ps = files.busquedaConFiltro(this);
    if (ps.isEmpty()) {
      error();
      return;
    }
    for (Persona a : ps)
      addPersona(a); }
  
  private JSeparator jSeparator1;
  
  private void jTable1MouseClicked(MouseEvent evt) { if (evt.getClickCount() == 2) {
      int row = jTable1.getSelectedRow();
      if (row != -1) {
        String id = (String)jTable1.getModel().getValueAt(row, 0);
        Registro reg = new Registro(id, this);
        setVisible(false);
      }
    }
  }
  
  private JTable jTable1;
  public JTextField textoCentro;
  public JTextField textoID;
  private void jComboBox1ActionPerformed(ActionEvent evt) {}
  
  private void jButton4ActionPerformed(ActionEvent evt) { if (ps.isEmpty()) {
      javax.swing.JOptionPane.showMessageDialog(null, "NO HAY RESULTADOS SUFICIENTES PARA GENERAR UN REPORTE", "SIN RESULTADOS", 0);
      return;
    }
    reporte = "";
    dialogo g = new dialogo(this, true);
    if (reporte.equals("")) return;
    FILES F = new FILES(reporte);
    F.write(ps);
    F = null;
  }
}
