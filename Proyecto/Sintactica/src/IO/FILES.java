package IO;

import Vista.Busqueda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.CentroEducativo;
import modelo.Persona;
import modelo.Redaccion;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;










public class FILES
{
  protected static String ruta = "File.xlsx";
  
  public static String getRuta()
  {
    return ruta;
  }
  
  public static String[] cols = new String[20];
  static { cols[0] = "ID";
    cols[1] = "NOMBRE";
    cols[2] = "APELLIDO";
    cols[3] = "APELLIDO2";
    cols[4] = "NIVEL";
    cols[5] = "EDAD";
    cols[6] = "SEXO";
    cols[7] = "CENTRO EDUCATIVO";
    cols[8] = "SIGLAS";
    cols[9] = "PUBLICO/PRIVADO";
    cols[10] = "CCA/SCA";
    cols[11] = "DETALLE CCA";
    cols[12] = "ADECUACION";
    cols[13] = "TIPO ADECUACION";
    cols[14] = "UT";
    cols[15] = "CL";
    cols[16] = "PAL";
    cols[17] = "LPUT";
    cols[18] = "LPCL";
    cols[19] = "NSUB";
  }
  
  public FILES() { ruta = "File.xlsx";
    File f = new File(ruta);
    if (!f.exists())
      try {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet s = wb.createSheet("hoja1");
        XSSFSheet s2 = wb.createSheet("hoja2");
        save(wb);
        header();
      } catch (FileNotFoundException ex) {
        Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public FILES(String path) {
    ruta = path + ".xlsx";
    File f = new File(ruta);
    if (f.exists()) {
      f.delete();
    }
    f = new File(ruta);
    try {
      XSSFWorkbook wb = new XSSFWorkbook();
      XSSFSheet s = wb.createSheet("hoja1");
      XSSFSheet s2 = wb.createSheet("hoja2");
      save(wb);
      header();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  final void save(Workbook wb) throws FileNotFoundException, IOException { FileOutputStream fl = new FileOutputStream(new File(ruta));
    wb.write(fl);
    fl.flush();
    fl.close();
  }
  
  public void write(ArrayList<Persona> ps) { if (ps == null) return;
    if (ps.isEmpty()) return;
    for (Persona p : ps)
      try {
        write(p, p.getRedaccion().getR());
      } catch (Exception ex) {
        String nl = System.getProperty("line.separator");
        Object mensaje = "ASEGURESE QUE EL ARCHIVO SOBRE EL QUE TRATA DE ESCRIBIR NO ESTA SIENDO UTILIZADO POR OTRO PROGRAMA";
        mensaje = mensaje + nl + "LA INFORMACIÓN NO PODRÁ SER GUARDADA HASTA QUE EL ARCHIVO ESTE CERRADO";
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", 0);
        Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
        break;
      }
  }
  
  public void overWrite(Persona p, String texto) throws Exception {
    if (p == null) return;
    Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
    Sheet hoja = wb.getSheetAt(0);
    boolean encontrado = false;
    Row row = null;
    Iterator it = hoja.rowIterator();
    while (it.hasNext()) {
      row = (Row)it.next();
      if (row.getCell(0).getStringCellValue().equalsIgnoreCase(p.getId())) {
        encontrado = true;
      }
    }
    
    if (!encontrado) return;
    int aux = row.getRowNum();
    hoja.removeRow(row);
    row = hoja.createRow(aux);
    CentroEducativo centro = p.getCentro();
    Redaccion R = p.getRedaccion();
    for (int i = 0; i < cols.length; i++) {
      Cell cell = row.createCell(i);
      switch (i) {
      case 0:  cell.setCellValue(p.getId()); break;
      case 1:  cell.setCellValue(p.getName()); break;
      case 2:  cell.setCellValue(p.getLastName()); break;
      case 3:  cell.setCellValue(p.getLastName2()); break;
      case 4:  cell.setCellValue(p.getNivel()); break;
      case 5:  cell.setCellValue(p.getEdad()); break;
      case 6:  cell.setCellValue(p.isMale() ? "M" : "F"); break;
      case 7:  cell.setCellValue(centro.getName()); break;
      case 8:  cell.setCellValue(centro.getSiglas()); break;
      case 9:  cell.setCellValue(centro.isPublic() ? "PUBLICO" : "PRIVADO"); break;
      case 10:  cell.setCellValue(p.isCCA() ? "CCA" : "CSA"); break;
      case 11:  cell.setCellValue(p.isCCA() ? p.getCCA_DETALLE() : "-"); break;
      case 12:  cell.setCellValue(p.isAdecuacion() ? "SI" : "NO"); break;
      case 13:  cell.setCellValue(p.isAdecuacion() ? modelo.Info.tipos[p.getTipo()] : "-"); break;
      case 14:  cell.setCellValue(R.getUT()); break;
      case 15:  cell.setCellValue(R.getCL()); break;
      case 16:  cell.setCellValue(R.getPAL()); break;
      case 17:  cell.setCellValue(R.getLPUT()); break;
      case 18:  cell.setCellValue(R.getLPCL()); break;
      case 19:  cell.setCellValue(R.getINSUB());
      }
    }
    REDACCIONES.overWrite(wb, p, texto);
    save(wb);
  }
  
  public void write(Persona p, String texto) throws Exception { if (p == null) return;
    Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
    Sheet hoja = wb.getSheetAt(0);
    int inx = 0;
    Iterator it = hoja.rowIterator();
    while (it.hasNext()) {
      inx++;
      it.next();
    }
    Row row = hoja.createRow(inx);
    CentroEducativo centro = p.getCentro();
    Redaccion R = p.getRedaccion();
    for (int i = 0; i < cols.length; i++) {
      Cell cell = row.createCell(i);
      switch (i) {
      case 0:  cell.setCellValue(p.getId()); break;
      case 1:  cell.setCellValue(p.getName()); break;
      case 2:  cell.setCellValue(p.getLastName()); break;
      case 3:  cell.setCellValue(p.getLastName2()); break;
      case 4:  cell.setCellValue(p.getNivel()); break;
      case 5:  cell.setCellValue(p.getEdad()); break;
      case 6:  cell.setCellValue(p.isMale() ? "M" : "F"); break;
      case 7:  cell.setCellValue(centro.getName()); break;
      case 8:  cell.setCellValue(centro.getSiglas()); break;
      case 9:  cell.setCellValue(centro.isPublic() ? "PUBLICO" : "PRIVADO"); break;
      case 10:  cell.setCellValue(p.isCCA() ? "CCA" : "CSA"); break;
      case 11:  cell.setCellValue(p.isCCA() ? p.getCCA_DETALLE() : "-"); break;
      case 12:  cell.setCellValue(p.isAdecuacion() ? "SI" : "NO"); break;
      case 13:  cell.setCellValue(p.isAdecuacion() ? modelo.Info.tipos[p.getTipo()] : "-"); break;
      case 14:  cell.setCellValue(R.getUT()); break;
      case 15:  cell.setCellValue(R.getCL()); break;
      case 16:  cell.setCellValue(R.getPAL()); break;
      case 17:  cell.setCellValue(R.getLPUT()); break;
      case 18:  cell.setCellValue(R.getLPCL()); break;
      case 19:  cell.setCellValue(R.getINSUB());
      }
    }
    REDACCIONES.write(wb, p, texto);
    save(wb);
  }
  
  public void remove(String id) throws Exception {
    try {
      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
      Sheet hoja = wb.getSheetAt(0);
      Iterator rows = hoja.rowIterator();
      
      int i = 0;
      Persona p = null;
      while (rows.hasNext()) {
        Row row = (Row)rows.next();
        if (row.getCell(0).getStringCellValue().equalsIgnoreCase(id)) {
          removeRow(hoja, row);
          REDACCIONES.remove(id, wb);
          save(wb);
          break;
        }
        i++;
      }
    }
    catch (IOException|InvalidFormatException|EncryptedDocumentException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void removeRow(Sheet sheet, Row row) { int rowIndex = row.getRowNum();
    sheet.removeRow(row);
    int lastRowNum = sheet.getLastRowNum();
    if ((rowIndex >= 0) && (rowIndex < lastRowNum))
      sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
  }
  
  void header() {
    try {
      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
      Sheet hoja = wb.getSheetAt(0);
      Row row = hoja.createRow(0);
      int h = 0;
      for (String s : cols) {
        Cell cell = row.createCell(h++);
        cell.setCellValue(s);
      }
      save(wb);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidFormatException|EncryptedDocumentException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public Persona getById(String id) { if (id.equals("")) return null;
    Persona p = null;
    try
    {
      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
      Sheet hoja = wb.getSheetAt(0);
      Iterator rows = hoja.rowIterator();
      
      while (rows.hasNext()) {
        Row row = (Row)rows.next();
        if (row.getCell(0).getStringCellValue().equalsIgnoreCase(id)) {
          p = toPersona(row);
        }
      }
    }
    catch (IOException|InvalidFormatException|EncryptedDocumentException ex)
    {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
    return p;
  }
  
  Persona toPersona(Row r) throws IOException { if (r == null) return null;
    Persona p = new Persona();
    Iterator cells = r.cellIterator();
    int i = 0;
    
    String str = "";
    while (cells.hasNext()) {
      Cell aux = (Cell)cells.next();
      if ((i != 4) && (i != 5) && (i < 14))
        str = aux.getStringCellValue();
      switch (i) {
      case 0:  p.setId(str); break;
      case 1:  p.setName(str); break;
      case 2:  p.setLastName(str); break;
      case 3:  p.setLastName2(str); break;
      case 4:  p.setNivel((int)aux.getNumericCellValue()); break;
      case 5:  p.setEdad((int)aux.getNumericCellValue()); break;
      case 6:  p.setMale(str.equalsIgnoreCase("M")); break;
      case 7:  p.getCentro().setName(str); break;
      case 8:  p.getCentro().setSiglas(str); break;
      case 9:  p.getCentro().setPublic(str.equalsIgnoreCase("PUBLICO")); break;
      case 10:  p.setCCA(str.equalsIgnoreCase("CCA"), " "); break;
      case 11:  p.setCCA_DETALLE(str);
      case 12:  p.setAdecuacion(str.equalsIgnoreCase("SI"), -1); break;
      case 13:  p.setTipoDeAdecuacion(str); break;
      case 14:  p.getRedaccion().setUT((int)aux.getNumericCellValue()); break;
      case 15:  p.getRedaccion().setCL((int)aux.getNumericCellValue()); break;
      case 16:  p.getRedaccion().setPAL((int)aux.getNumericCellValue()); break;
      case 17:  p.getRedaccion().setLPUT((float)aux.getNumericCellValue()); break;
      case 18:  p.getRedaccion().setLPCL((float)aux.getNumericCellValue()); break;
      case 19:  p.getRedaccion().setINSUB((float)aux.getNumericCellValue());
      }
      i++;
    }
    p.getRedaccion().setR(REDACCIONES.read(p.getId()));
    return p;
  }
  
  public ArrayList<Persona> busquedaConFiltro(Busqueda v) { ArrayList<Persona> p = new ArrayList();
    try
    {
      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(ruta)));
      Sheet hoja = wb.getSheetAt(0);
      Iterator rows = hoja.rowIterator();
      
      Row row = (Row)rows.next();
      while (rows.hasNext()) {
        row = (Row)rows.next();
        Persona p2 = toPersona(row);
        if (is(v, p2)) p.add(p2);
      }
    }
    catch (IOException|InvalidFormatException|EncryptedDocumentException ex) {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
    return p;
  }
  
  boolean is(Busqueda v, Persona p) { 
    if ((v.textoCentro.getText().length() > 0) && (
      (!p.getCentro().getName().equalsIgnoreCase(v.textoCentro.getText())) ||
            (!p.getCentro().getSiglas().equalsIgnoreCase(v.textoCentro.getText())))) {
      return false;
    }
    if ((v.jComboBox1.getSelectedIndex() != 0) && 
      (p.getNivel() != v.jComboBox1.getSelectedIndex() + 6)) {
      return false;
    }
    if ((v.checkPrivado.isSelected()) && (!v.checkPublico.isSelected()) && 
      (p.getCentro().isPublic())) { return false;
    }
    if ((!v.checkPrivado.isSelected()) && (v.checkPublico.isSelected()) && 
      (!p.getCentro().isPublic())) { return false;
    }
    if ((v.checkF.isSelected()) && (!v.checkM.isSelected()) && 
      (p.isMale())) { return false;
    }
    if ((!v.checkF.isSelected()) && (v.checkM.isSelected()) && 
      (!p.isMale())) { return false;
    }
    if ((v.checkCCA.isSelected()) && (!v.checkSCA.isSelected()) && 
      (!p.isCCA())) { return false;
    }
    if ((!v.checkCCA.isSelected()) && (v.checkSCA.isSelected()) && 
      (p.isCCA())) { return false;
    }
    if ((!v.checkAD.isSelected()) && (v.checkNoAd.isSelected()) && 
      (p.isAdecuacion())) { return false;
    }
    if ((v.checkAD.isSelected()) && (!v.checkNoAd.isSelected()) && 
      (!p.isAdecuacion())) { return false;
    }
    return true;
  }
}
