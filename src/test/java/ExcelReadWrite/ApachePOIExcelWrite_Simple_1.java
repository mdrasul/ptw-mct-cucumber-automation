package ExcelReadWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite_Simple_1 {

	//private static final String FILE_NAME = "../tmp/MyFirstExcel.xlsx";
	public static final String FILE_NAME = System.getProperty("user.dir") + "/EmployeeSalary.xlsx";

	public static void main(String[] args) {

		// Creating Excel Work Books & sheet reference Using Apache POI
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Payroll");

		// Start Creating Excel Table :  Header Rows & Columns  !!
		System.out.println("Start Creating Excel Table :  Header Rows & Columns  !!");
		String[] columnHeader= {"SL#","Employee Name","Total Hour","Hourly-Rate","Gross-Pay","Net-Pay"};
		Row headerRow = sheet.createRow(0);
		int headerColPointer = 0;
		for(int i=0; i<6;i++) {
			Cell headerCell = headerRow.createCell(headerColPointer++);
			headerCell.setCellValue((String) columnHeader[i]);
		}

		// Start Adding  Rows From 2nd Row in Excel Files  !!
		System.out.println("Start Adding  data From 2nd Row of Excel Files  !!");
		Object[][] rowData = {
				{1,"Mr X",40.00,10.00,400.00,390.00},
				{2,"Mr Y",50.00,10.00,500.00,490.00},
				{3,"Mr Y",50.00,10.00,500.00,490.00},
		};    	

		int rowPointer = 1;
		for(int m=0; m<rowData.length;m++) {
			Row row = sheet.createRow(rowPointer++);

			int colPointer = 0;
			for(int x=0; x<6;x++) {
				Cell cell = row.createCell(colPointer++);
				if (rowData[m][x] instanceof Integer) {
					cell.setCellValue((Integer) rowData[m][x]);
				} else if (rowData[m][x] instanceof String) {
					cell.setCellValue((String) rowData[m][x]);
				} else if (rowData[m][x] instanceof Double) {
					cell.setCellValue((Double) rowData[m][x]);
				}
			}

		}

		// Creating a FileOutputStream & Saving all Stream data to Excel FIle
		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}