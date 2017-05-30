package modelo;

import java.util.ArrayList;



public class Clausula
{
  ArrayList<String> words;
  
  public Clausula()
  {
    words = new ArrayList();
  }
  
  public Clausula(Clausula C) { words = C.words; }
  
  public void add(String w) {
    String eachWord[] = w.split(" ");
    
    /*int i = 0;
    int j = 0;
    while (i < w.length()) {
      j = w.indexOf(' ', i);
      if (j != -1) {
        String aux = w.substring(i, j);
        if (aux.length() != 0)
          words.add(aux);
        i = j + 1;
      } else {
        String aux = w.substring(i, w.length());
        if (aux.length() != 0)
          words.add(aux);
      }
    }*/
    boolean aux = true;
    for(String a:eachWord){
        if(a.equals("(") || a.contains("("))
            aux = false;
        if(a.equals(")") || a.contains(")"))
            aux = true;
        else if(aux && a.length() != 0)
            this.words.add(a);
    }
  }
  
  public ArrayList<String> getWords() {
    return words;
  }
}