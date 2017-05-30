package Vista;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;

public class dialogo extends javax.swing.JDialog
{
  Busqueda parent;
  private JButton cancel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JTextField jTextField1;
  private JButton save;
  
  public dialogo(Busqueda j, boolean p)
  {
    super(j, p);
    parent = j;
    initComponents();
    setResizable(false);
    setTitle("REPORTE");
    setLocation(parent.getWidth() / 3, parent.getHeight() / 3);
    getContentPane().setBackground(new java.awt.Color(202, 210, 255));
    setVisible(true);
  }
  







  private void initComponents()
  {
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    cancel = new JButton();
    save = new JButton();
    
    jLabel1.setFont(new java.awt.Font("Verdana", 0, 14));
    jLabel1.setText("Bajo que nombre desea que se guarde el informe");
    
    cancel.setText("CANCELAR");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        dialogo.this.cancelActionPerformed(evt);
      }
      
    });
    save.setText("GUARDAR");
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        dialogo.this.saveActionPerformed(evt);
      }
      
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGap(69, 69, 69)
      .addComponent(jTextField1, -2, 298, -2)
      .addContainerGap(-1, 32767))
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addContainerGap(38, 32767)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addComponent(jLabel1, -2, 367, -2)
      .addContainerGap())
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addComponent(save)
      .addGap(29, 29, 29)
      .addComponent(cancel)
      .addGap(111, 111, 111)))));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(jLabel1)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jTextField1, -2, -1, -2)
      .addGap(18, 18, 18)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(cancel)
      .addComponent(save))
      .addContainerGap(16, 32767)));
    

    pack();
  }
  
  private void cancelActionPerformed(ActionEvent evt) {
    parent.reporte = "";
    dispose();
  }
  
  private void saveActionPerformed(ActionEvent evt) {
    String a = jTextField1.getText();
    if (a.equals("")) {
      javax.swing.JOptionPane.showMessageDialog(null, "DEBE ESCRIBIR UN NOMBRE PARA EL ARCHIVO", "SIN NOMBRE", 1);
    } else {
      if ((a.contains("~")) || (a.contains("#")) || (a.contains("%")) || (a.contains("&")) || (a.contains("*")) || (a.contains("{")) || (a.contains("}")) || (a.contains("\\")) || (a.contains("<")) || (a.contains(">")) || (a.contains("?")) || (a.contains("/")) || (a.contains("+")) || (a.contains("|")) || (a.contains("\""))) {
        String nl = System.getProperty("line.separator");
        Object mensaje = "NO SE PUEDE CREAR UN ARCHIVO CON ESE NOMBRE" + nl + "VERIFIQUE NO ESTAR USANDO ALGUNO DE LOS SIGUIENTES SIGNOS:" + nl + "~ # % & * { } \\ < > ? + / | \"";
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "!!!", 0);
        return;
      }
      if (a.equalsIgnoreCase("File")) {
        javax.swing.JOptionPane.showMessageDialog(null, "NO SE PUEDE USAR File como nombre de para reporte", "!!!", 0);
        jTextField1.setText("");
        return;
      }
      
      parent.reporte = a;
      dispose();
    }
  }
}