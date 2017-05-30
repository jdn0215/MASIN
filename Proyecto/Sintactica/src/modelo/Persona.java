package modelo;

import java.util.Objects;




public class Persona
{
  String id;
  String Name;
  String LastName;
  String LastName2;
  boolean male;
  int edad;
  CentroEducativo centro;
  int nivel;
  Info info;
  Redaccion redaccion;
  
  public Persona(int edad, String Name, String LastName, String LastName2, String id, int nivel, boolean CCA, String CCAD, boolean adecuacion, int tipo, boolean male, CentroEducativo centro)
  {
    this.id = id;
    this.Name = Name;
    this.LastName = LastName;
    this.LastName2 = LastName2;
    this.male = male;
    this.centro = centro;
    this.nivel = nivel;
    info = new Info(adecuacion, tipo, CCA, CCAD);
    redaccion = new Redaccion();
    this.edad = edad;
  }
  
  public int getEdad() {
    return edad;
  }
  
  public void setEdad(int edad) {
    this.edad = edad;
  }
  
  public String getLastName2() {
    return LastName2;
  }
  
  public void setLastName2(String LastName2) {
    this.LastName2 = LastName2;
  }
  
  public Info getInfo() {
    return info;
  }
  
  public void setInfo(Info info) {
    this.info = info;
  }
  
  public Persona() {
    centro = new CentroEducativo();
    redaccion = new Redaccion();
    info = new Info();
  }
  
  public void setCCA_DETALLE(String CCA_DETALLE) {
    info.setDetalle_CCA(CCA_DETALLE);
  }
  
  public String toString()
  {
    return "Persona{id=" + id + ", Name=" + Name + ", LastName=" + LastName + ", male=" + male + ", centro=" + centro + ", nivel=" + nivel + ", info=" + info + ", redaccion=" + redaccion + '}';
  }
  
  public void setTipoDeAdecuacion(int tipoDeAdecuacion)
  {
    info.setTipoAdecuacion(tipoDeAdecuacion);
  }
  
  public void setTipoDeAdecuacion(String tipo) {
    if (tipo.equalsIgnoreCase(Info.tipos[0])) {
      info.setTipoAdecuacion(0);
    } else if (tipo.equalsIgnoreCase(Info.tipos[1])) {
      info.setTipoAdecuacion(1);
    } else if (tipo.equalsIgnoreCase(Info.tipos[2]))
      info.setTipoAdecuacion(2); else {
      info.setTipoAdecuacion(-1);
    }
  }
  
  public Persona(Persona P)
  {
    id = id;
    Name = Name;
    LastName = LastName;
    LastName2 = LastName2;
    male = male;
    centro = centro;
    nivel = nivel;
    info = new Info(info.isAdecuacion(), info.getTipoAdecuacion(), P.isCCA(), info.getDetalle_CCA());
    redaccion = redaccion;
    edad = edad;
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Persona other = (Persona)obj;
    return Objects.equals(id, id);
  }
  
  public int hashCode()
  {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(id);
    return hash;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return Name;
  }
  
  public void setName(String Name) {
    this.Name = Name;
  }
  
  public String getLastName() {
    return LastName;
  }
  
  public void setLastName(String LastName) {
    this.LastName = LastName;
  }
  
  public boolean isMale() {
    return male;
  }
  
  public void setMale(boolean male) {
    this.male = male;
  }
  
  public CentroEducativo getCentro() {
    return centro;
  }
  
  public void setCentro(CentroEducativo centro) {
    this.centro = centro;
  }
  
  public int getNivel() {
    return nivel;
  }
  
  public void setNivel(int nivel) {
    this.nivel = nivel;
  }
  
  public boolean isCCA() {
    return info.isCCA();
  }
  
  public String getCCA_DETALLE() {
    return info.getDetalle_CCA();
  }
  
  public boolean isAdecuacion() {
    return info.isAdecuacion();
  }
  
  public int getTipo() {
    return info.getTipoAdecuacion();
  }
  
  public void setCCA(boolean CCA, String detalle) {
    if (info.isCCA())
      info.setDetalle_CCA(detalle);
    info.setCCA(CCA);
  }
  
  public void setAdecuacion(boolean adecuacion, int t) {
    if (adecuacion)
      info.setTipoAdecuacion(t);
    info.setAdecuacion(adecuacion);
  }
  
  public Redaccion getRedaccion() {
    return redaccion;
  }
  
  public void setRedaccion(Redaccion redaccion) {
    this.redaccion = redaccion;
  }
}