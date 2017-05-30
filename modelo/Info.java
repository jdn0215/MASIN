package modelo;

public class Info
{
  public static String[] tipos = new String[3];
  static { tipos[0] = "SIGNIFICATIVA";
    tipos[1] = "NO SIGNIFICATIVA";
    tipos[2] = "DE ACCESO";
  }
  
  boolean adecuacion;
  int tipoAdecuacion;
  boolean CCA;
  String detalle_CCA;
  public Info(boolean adecuacion, int tipoAdecuacion, boolean CCA, String detalle_CCA) {
    this.adecuacion = adecuacion;
    this.tipoAdecuacion = tipoAdecuacion;
    this.CCA = CCA;
    this.detalle_CCA = detalle_CCA;
  }
  
  public Info() { adecuacion = false;
    tipoAdecuacion = -1;
    CCA = false;
    detalle_CCA = "-";
  }
  
  public String toString()
  {
    return "Info{adecuacion=" + adecuacion + ", tipoAdecuacion=" + tipoAdecuacion + ", CCA=" + CCA + ", detalle_CCA=" + detalle_CCA + '}';
  }
  
  public static String[] getTipos()
  {
    return tipos;
  }
  
  public static void setTipos(String[] tipos) {
    tipos = tipos;
  }
  
  public boolean isAdecuacion() {
    return adecuacion;
  }
  
  public void setAdecuacion(boolean adecuacion) {
    this.adecuacion = adecuacion;
  }
  
  public int getTipoAdecuacion() {
    return tipoAdecuacion;
  }
  
  public void setTipoAdecuacion(int tipoAdecuacion) {
    this.tipoAdecuacion = tipoAdecuacion;
  }
  
  public boolean isCCA() {
    return CCA;
  }
  
  public void setCCA(boolean CCA) {
    this.CCA = CCA;
  }
  
  public String getDetalle_CCA() {
    return detalle_CCA;
  }
  
  public void setDetalle_CCA(String detalle_CCA) {
    this.detalle_CCA = detalle_CCA;
  }
}