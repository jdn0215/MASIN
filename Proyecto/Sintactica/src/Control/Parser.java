/**
* Licencia de Software Libre
* Copyright (c) 2017 Dra. Olga Arce Cascante.
* Es condición necesaria para la utilización, distribución, 
* ingeniería inversa o cualquier otro procedimiento informático que
* haga necesario el acceso al ejecutable y código fuente del software MASIM
* Ver documento LICENSE para más detalle
*/
package Control;

import modelo.T;

public class Parser
{
  public Parser() {}
  
  public T extract$(int currentPos, String texto)
    throws Exception
  {
    if (texto.charAt(currentPos) != '$') {
      currentPos = texto.indexOf('$', currentPos);
      if (currentPos == -1) throw new Exception("EXISTE UN ERROR");
    }
    int next = texto.indexOf('$', currentPos + 1);
    if (next == -1) throw new Exception("EXISTE UN ERROR");
    T t = new T();
    t.parse(texto.substring(currentPos + 1, next));
    return t;
  }
}