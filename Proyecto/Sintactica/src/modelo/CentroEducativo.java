/**
* Licencia de Software Libre
* Copyright (c) 2017 Dra. Olga Arce Cascante.
* Es condición necesaria para la utilización, distribución, 
* ingeniería inversa o cualquier otro procedimiento informático que
* haga necesario el acceso al ejecutable y código fuente del software MASIM
* Ver documento LICENSE para más detalle
*/
package modelo;


public class CentroEducativo
{
  String name;
  
  String siglas;
  boolean Public;
  
  public CentroEducativo(String name, String siglas, boolean Public)
  {
    this.name = name;
    this.siglas = siglas;
    this.Public = Public;
  }
  
  @Override
  public String toString()
  {
    return "CentroEducativo{name=" + name + ", siglas=" + siglas + ", Public=" + Public + '}';
  }
  
  public CentroEducativo() {
    name = "-";
    siglas = "-";
    Public = true;
  }
  
  public CentroEducativo(CentroEducativo C) { 
    name = C.name;
    siglas = C.siglas;
    Public = C.Public;
  }
  
  public String getName() { return name; }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getSiglas() {
    return siglas;
  }
  
  public void setSiglas(String siglas) {
    this.siglas = siglas;
  }
  
  public boolean isPublic() {
    return Public;
  }
  
  public void setPublic(boolean Public) {
    this.Public = Public;
  }
}