package modelo;

import java.util.ArrayList;

public class Redaccion {
  ArrayList<T> redaccion;
  int UT;
  int CL;
  int PAL;
  float LPUT;
  float LPCL;
  float INSUB;
  String R = "";
  
  public String getR() {
    return R;
  }
  
  public void setR(String R) {
    this.R = R;
  }
  
  public Redaccion(ArrayList<T> t) { redaccion = t; }
  
  public void setUT(int UT)
  {
    this.UT = UT;
  }
  
  public void setCL(int CL) {
    this.CL = CL;
  }
  
  public void setPAL(int PAL) {
    this.PAL = PAL;
  }
  
  public void setINSUB(float INSUB) {
    this.INSUB = INSUB;
  }
  
  public void setLPUT(float LPUT) {
    this.LPUT = LPUT;
  }
  
  public void setLPCL(float LPCL) {
    this.LPCL = LPCL;
  }
  
  @Override
  public String toString()
  {
    return "Redaccion{redaccion=" + redaccion + ", UT=" + UT + ", CL=" + CL + ", PAL=" + PAL + ", INSUB=" + INSUB + ", LPUT=" + LPUT + ", LPCL=" + LPCL + '}';
  }
  
  public Redaccion() {
    redaccion = new ArrayList();
  }
  
  public ArrayList<T> getRedaccion()
  {
    return redaccion;
  }
  
  public void setRedaccion(ArrayList<T> redaccion) {
    this.redaccion = redaccion;
    UT = totalT();
    CL = totalClausulas();
    PAL = totalPalabras();
    LPUT = promedioT();
    LPCL = promedioC();
    INSUB = indice();
  }
  

  int totalT() { return redaccion.size(); }
  
  int totalClausulas() {
    int t = 0;
    for (int i = 0; i < redaccion.size(); t += ((T)redaccion.get(i++)).getclausulas().size()) {}
    return t;
  }
  
  int totalPalabras() { int t = 0;
    

    for (T redaccion1 : redaccion) {
      T aux = redaccion1;
      for (Clausula clausula : aux.getclausulas()) {
        int YY = 0;
        for (String yy : clausula.getWords()) {
          if (yy.equalsIgnoreCase("&")) YY++;
        }
        t += clausula.getWords().size() - YY;
      }
    }
    return t;
  }
  
  float promedioT() { 
      if (UT == 0) return 0.0F;
      return (float)PAL / (float) UT;
  }
  
  float promedioC() { if (CL == 0) return 0.0F;
    return  (float)PAL / (float) CL;
  }
  
  float indice() { if (UT == 0) return 0.0F;
    return  (float)CL / (float) UT;
  }
  
  public int getUT() {
    return UT;
  }
  
  public int getCL() {
    return CL;
  }
  
  public int getPAL() {
    return PAL;
  }
  
  public float getINSUB() {
    return INSUB;
  }
  
  public float getLPUT() {
    return LPUT;
  }
  
  public float getLPCL() {
    return LPCL;
  }
}