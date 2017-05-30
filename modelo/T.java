package modelo;

import java.util.ArrayList;

public class T
{
  ArrayList<Clausula> clausulas;
  
  public T()
  {
    clausulas = new ArrayList();
  }
  
  public T(T t) { clausulas = clausulas; }
  

  public void add(Clausula w) { clausulas.add(w); }
  
  public void parse(String txt) throws Exception {
    int i = 0;
    while ((i < txt.length()) && (i != -1)) {
      try {
        Clausula c = Extract(i, txt);
        clausulas.add(c);
      }
      catch (Exception e) {
        throw new Exception("EXISTEN ERRORES");
      }
      i = txt.indexOf('%', i + 1);
      if (i != -1) i = txt.indexOf('%', i + 1);
    }
  }
  
  public Clausula Extract(int currentPos, String texto) throws Exception {
    if (texto.charAt(currentPos) != '%') {
      currentPos = texto.indexOf('%', currentPos);
      if (currentPos == -1) throw new Exception("2");
    }
    int next = texto.indexOf('%', currentPos + 1);
    if (next == -1) throw new Exception("2");
    Clausula C = new Clausula();
    C.add(texto.substring(currentPos + 1, next));
    return C;
  }
  
  public ArrayList<Clausula> getclausulas() { return clausulas; }
}