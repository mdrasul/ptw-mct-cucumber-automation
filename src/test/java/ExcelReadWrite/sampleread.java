package ExcelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sampleread {

	
	
	public static final String FILE_NAME = System.getProperty("user.dir") + "/EmployeeSalary.xlsx";

	
	
	public static void main(String[] args) throws IOException {
		
			FileInputStream myexcel = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(myexcel);
           
           
           Sheet datatypeSheet = workbook.getSheetAt(0);

           Iterator<Row> iterator = datatypeSheet.iterator();
           while (iterator.hasNext()) {  // Rows 
               Row currentRow = iterator.next();
               Iterator<Cell> cellIterator = currentRow.iterator();
               
               while (cellIterator.hasNext()) {  // Columns 
                   Cell currentCell = cellIterator.next();
                   if (currentCell.getCellTypeEnum() == CellType.STRING) {
                       System.out.print(currentCell.getStringCellValue() + "--");
                   } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                       System.out.print(currentCell.getNumericCellValue() + "--");
                   }
               }
               
               System.out.println();
           }
			
			
			
			//System.out.println("sdfdfad");
			
		
		
	}

}
