/**
* Licencia de Software Libre
* Copyright (c) 2017 Dra. Olga Arce Cascante.
* Es condición necesaria para la utilización, distribución, 
* ingeniería inversa o cualquier otro procedimiento informático que
* haga necesario el acceso al ejecutable y código fuente del software MASIM
* Ver documento LICENSE para más detalle
*/
package Vista;





public class Revisarformato
  implements Runnable
{
  char[] operadores = new char[2];
  Registro vista;
  
  public Revisarformato(Registro v) { operadores[0] = '$';
    operadores[1] = '%';
    vista = v;
  }
  
  public boolean revisarParidad(String s, char c) { int cont = 0;
    for (int i = 0; i != -1;) {
      i = s.indexOf(c, i);
      if (i != -1) { cont++;i++;
      } }
    return cont % 2 == 0;
  }
  
  @Override
  public void run()
  {
    int aux = 0;
    for (;;) {
      try {
        if (vista.texto.getText().length() != 0) {
          if (!revisarParidad(vista.texto.getText(), operadores[aux])) {
            if (aux == 0) {
              vista.mensaje$.setText("$ FALTANTE");
            } else if (aux == 1) {
              vista.mensajeM.setText("% FALTANTE");
            }
          } else if (aux == 0) {
            vista.mensaje$.setText("");
          } else if (aux == 1)
            vista.mensajeM.setText("");
        } else {
          vista.mensaje$.setText("");vista.mensajeM.setText("");
        } } catch (Exception e) {}
      aux++;aux %= operadores.length;
    }
  }
}