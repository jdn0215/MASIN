

package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class REDACCIONES
{
  public REDACCIONES() {}
  
  public static void write(Workbook wb, Persona p, String texto)
    throws FileNotFoundException, IOException
  {
    if ((p == null) || (wb == null)) return;
    Sheet h = wb.getSheetAt(1);
    int inx = 0;
    Iterator it = h.rowIterator();
    while (it.hasNext()) {
      inx++;
      it.next();
    }
    Row row = h.createRow(inx);
    Cell cell1 = row.createCell(0);
    cell1.setCellValue(p.getId());
    Cell cell2 = row.createCell(1);
    cell2.setCellValue(texto);
  }
  
  public static void overWrite(Workbook wb, Persona p, String texto) throws FileNotFoundException, IOException { if ((p == null) || (wb == null)) return;
    Sheet h = wb.getSheetAt(1);
    boolean encontrado = false;
    Row row = null;
    Iterator it = h.rowIterator();
    while (it.hasNext()) {
      row = (Row)it.next();
      if (row.getCell(0).getStringCellValue().equalsIgnoreCase(p.getId())) {
        encontrado = true;
      }
    }
    
    if (!encontrado) return;
    int aux = row.getRowNum();
    h.removeRow(row);
    row = h.createRow(aux);
    Cell cell1 = row.createCell(0);
    cell1.setCellValue(p.getId());
    Cell cell2 = row.createCell(1);
    cell2.setCellValue(texto);
  }
  
  public static void remove(String id, Workbook wb) {
    try { Sheet hoja = wb.getSheetAt(1);
      Iterator rows = hoja.rowIterator();
      
      while (rows.hasNext()) {
        Row row = (Row)rows.next();
        if (row.getCell(0).getStringCellValue().equalsIgnoreCase(id)) {
          FILES.removeRow(hoja, row);
        }
      }
    }
    catch (EncryptedDocumentException ex)
    {
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static String read(String id) throws FileNotFoundException, IOException {
    String salida = "";
    try
    {
      Workbook wb = WorkbookFactory.create(new FileInputStream(new File(FILES.ruta)));
      Sheet hoja = wb.getSheetAt(1);
      Iterator rows = hoja.rowIterator();
      
      while (rows.hasNext()) {
        Row row = (Row)rows.next();
        if (row.getCell(0).getStringCellValue().equalsIgnoreCase(id)) {
          salida = row.getCell(1).getStringCellValue();
        }
      }
    }
    catch (IOException|InvalidFormatException|EncryptedDocumentException ex)
    {
      salida = "";
      Logger.getLogger(FILES.class.getName()).log(Level.SEVERE, null, ex);
    }
    return salida;
  }
}

