package Control;

import Vista.Registro;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.CentroEducativo;
import modelo.Persona;
import modelo.Redaccion;
import modelo.T;

public class constructorDeObjetos
{
  public constructorDeObjetos() {}
  
  public CentroEducativo construyeCentro(Registro v)
  {
    boolean ok = true;
    if (!verificaJTF(v.textCentro)) ok = false;
    if (!verificaJTF(v.textSiglas)) ok = false;
    if (!ok) return null;
    return new CentroEducativo(v.textCentro.getText(), v.textSiglas.getText(), v.botonPublico.isSelected());
  }
  
  public Persona construyePersona(Registro v) { CentroEducativo ce = construyeCentro(v);
    boolean ok = true;
    String detalle = "";
    int tipoAdec = -1;
    if (!verificaJTF(v.textName)) ok = false;
    if (!verificaJTF(v.textA2)) ok = false;
    if (!verificaJTF(v.textId)) ok = false;
    if (!verificaJTF(v.textA)) ok = false;
    if (!verificaJTFINT(v.textoEdad)) ok = false;
    int nivel = v.comboNivel.getSelectedIndex() + 7;
    if (!v.SCA.isSelected()) {
      detalle = v.detalle;
    }
    if (!v.noAdec.isSelected()) {
      tipoAdec = v.tipoAdec.getSelectedIndex();
    }
    if ((!ok) || (ce == null)) return null;
    return new Persona(Integer.parseInt(v.textoEdad.getText()), v.textName.getText(),
               v.textA.getText(), v.textA2.getText(), v.textId.getText(), 
            nivel, !v.SCA.isSelected(), detalle, !v.noAdec.isSelected(), tipoAdec, v.botonMasculino.isSelected(), ce);
  }
  
  boolean verificaJTF(JTextField j) { if (j == null) return false;
    String aux = j.getText();
    if (aux.length() == 0) {
      j.setBackground(new Color(255, 237, 237));
      return false;
    }
    j.setBackground(new Color(254, 254, 254));
    return true;
  }
  
  boolean verificaJTF(JTextArea j) { if (j == null) return false;
    String aux = j.getText();
    if (aux.length() == 0) {
      j.setBackground(new Color(255, 237, 237));
      return false;
    }
    j.setBackground(new Color(254, 254, 254));
    return true;
  }
  
  boolean verificaJTFINT(JTextField j) { if (j == null) return false;
    String aux = j.getText();
    try
    {
      int aux2 = Integer.parseInt(aux);
      j.setBackground(new Color(254, 254, 254));
    } catch (NumberFormatException e) {
      j.setBackground(new Color(255, 237, 237));
      return false; 
    }
    return true;
  }
  

  boolean hayErrores(Registro v) {
    return (v.texto.getText().length() == 0) || (v.mensaje$.getText().length() != 0)
            || (v.mensajeM.getText().length() != 0) || (v.mensajeG.getText().length() != 0); 
  }
  
  public Redaccion construyeRedaccion(Registro v) {
    Parser parser = new Parser();
    int i = 0;
    String txt = v.texto.getText();
    ArrayList<T> ts = new ArrayList();
    while ((i < txt.length()) && (i != -1)) {
      try {
        v.mensajeG.setText("");
        T t = parser.extract$(i, txt);
        ts.add(t);
      }
      catch (Exception e) {
        if ((v.mensajeG.getText().length() == 0) && (!e.getMessage().equals("1"))) {}
        v.mensajeG.setText(e.getMessage());
      }
      i = txt.indexOf('$', i + 1);
      if (i != -1) i = txt.indexOf('$', i + 1);
    }
    if (hayErrores(v)) {
      String nl = System.getProperty("line.separator");
      Object mensaje = "NO SE PUEDE PROCESAR LA REDACCION" + nl + "VERIFIQUE LO SIGUIENTE" + nl + "->EL AREA DE TEXTO NO SE ENCUENTRA EN BLANCO" + nl + "->NO EXISTEN ERRORES AL ABRIR O CERRAR $,%";
      JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", 0);
      return null;
    }
    Redaccion R = new Redaccion();
    R.setRedaccion(ts);
    return R;
  }
}