package Control;

import IO.FILES;
import Vista.Registro;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Redaccion;

public class Control
{
  Registro v;
  Redaccion R;
  Persona p;
  constructorDeObjetos c;
  FILES io = new FILES();
  
  public Control(Registro v) { this.v = v;
    c = new constructorDeObjetos();
    R = null;
    p = null;
  }
  
  public void remove() {
    try { io.remove(v.textId.getText());
    } catch (Exception ex) {
      Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void update() {
    try { if (p == null) return;
      v.setEnabled(false);
      io.overWrite(p, v.texto.getText());
      clear();
    } catch (Exception ex) {
      String nl = System.getProperty("line.separator");
      Object mensaje = "ASEGURESE QUE EL ARCHIVO SOBRE EL QUE TRATA DE ESCRIBIR NO ESTA SIENDO UTILIZADO POR OTRO PROGRAMA";
      mensaje = mensaje + nl + "LA INFORMACIÓN NO PODRÁ SER GUARDADA HASTA QUE EL ARCHIVO ESTE CERRADO";
      JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", 0);
      Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
    }
    v.setEnabled(true);
  }
  
  public void save() {
    try { if (p == null) return;
      if (io.getById(p.getId()) == null) {
        v.setEnabled(false);
        io.write(p, v.texto.getText());
        clear();
      }
      else {
        v.textId.setBackground(new java.awt.Color(255, 237, 237));
        Object mensaje = "LA PERSONA " + p.getId() + " YA SE ENCUENTRA REGISTRADA";
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", 0);
      }
    } catch (Exception ex) {
      String nl = System.getProperty("line.separator");
      Object mensaje = "ASEGURESE QUE EL ARCHIVO SOBRE EL QUE TRATA DE ESCRIBIR NO ESTA SIENDO UTILIZADO POR OTRO PROGRAMA";
      mensaje = mensaje + nl + "LA INFORMACIÓN NO PODRÁ SER GUARDADA HASTA QUE EL ARCHIVO ESTE CERRADO";
      JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", 0);
    }
    v.setEnabled(true);
  }
  
  public void clear() { v.textName.setText("");
    v.textA2.setText("");
    v.textId.setText("");
    v.comboNivel.setSelectedIndex(0);
    v.SCA.doClick();
    v.noAdec.doClick();
    v.tipoAdec.setSelectedIndex(0);
    v.botonMasculino.setSelected(true);
    v.textCentro.setText("");
    v.textSiglas.setText("");
    v.botonPublico.setSelected(true);
    v.texto.setText("");
    v.mensaje$.setText("");
    v.mensajeG.setText("");
    v.mensajeM.setText("");
    v.UT.setText("");
    v.CL.setText("");
    v.PAL.setText("");
    v.LPUT.setText("");
    v.LPCL.setText("");
    v.INSUB.setText("");
    v.textA.setText("");
    v.textoEdad.setText("");
    v.procesar.setEnabled(true);
    v.save.setEnabled(false);
  }
  
  public void procesar() { R = c.construyeRedaccion(v);
    p = c.construyePersona(v);
    if ((R == null) || (p == null)) return;
    v.save.setEnabled(true);
    p.setRedaccion(R);
    resultados();
  }
  
  public void resultados() { v.UT.setText(String.valueOf(R.getUT()));
    v.CL.setText(String.valueOf(R.getCL()));
    v.PAL.setText(String.valueOf(R.getPAL()));
    v.LPUT.setText(String.valueOf(R.getLPUT()));
    v.LPCL.setText(String.valueOf(R.getLPCL()));
    v.INSUB.setText(String.valueOf(R.getINSUB()));
  }
  
  void detalles() {
    if (p == null) return;
    String aux = p.getCCA_DETALLE();
    if (aux.equals("")) return;
    for (int i = 0; i < 19; i++)
      v.opciones.opciones[i].setSelected(aux.contains(v.opciones.descripciones[i]));
    if (aux.contains("Otro")) {
      int idx = aux.indexOf("*");
      String sub = "";
      try { sub = aux.substring(idx + 7);
      } catch (Exception e) {}
      v.opciones.jTextField1.setText(sub);
      v.opciones.opciones[19].setSelected(true);
      v.opciones.jTextField1.setEnabled(true);
    }
  }
  
  public void load(String id) { p = io.getById(id);
    String t;
    boolean ok = true;
    try {
      t = IO.REDACCIONES.read(id);
    } catch (IOException e) { ok = false;t = ""; }
    if ((!ok) || (p == null) || (t.length() == 0)) {
      t = "%$REDACCIÓN NO DISPONIBLE$ $ES POSIBLE QUE ALGUN ARCHIVO ESTE DAÑADO O FUERA MODIFICADO$%";
      JOptionPane.showMessageDialog(null, "REDACCIÓN NO ENCONTRADA", "Mensaje de Error", 0);
    }
    v.texto.setText(t);
    v.textName.setText(p.getName());
    v.textA2.setText(p.getLastName2());
    v.textId.setText(p.getId());
    v.comboNivel.setSelectedIndex(p.getNivel() - 7);
    if (p.isCCA()) {
      v.cca.doClick();
      detalles();
    } else { v.SCA.doClick(); }
    if (p.isAdecuacion()) {
      v.siA.doClick();
      v.tipoAdec.setSelectedIndex(p.getTipo());
    } else { v.noAdec.doClick(); }
    v.botonMasculino.setSelected(p.isMale());
    v.textCentro.setText(p.getCentro().getName());
    v.textSiglas.setText(p.getCentro().getSiglas());
    v.botonPublico.setSelected(p.getCentro().isPublic());
    v.UT.setText(String.valueOf(p.getRedaccion().getUT()));
    v.CL.setText(String.valueOf(p.getRedaccion().getCL()));
    v.PAL.setText(String.valueOf(p.getRedaccion().getPAL()));
    v.LPUT.setText(String.valueOf(p.getRedaccion().getLPUT()));
    v.LPCL.setText(String.valueOf(p.getRedaccion().getLPCL()));
    v.INSUB.setText(String.valueOf(p.getRedaccion().getINSUB()));
    v.textA.setText(p.getLastName());
    v.textoEdad.setText(String.valueOf(p.getEdad()));
  }
}
