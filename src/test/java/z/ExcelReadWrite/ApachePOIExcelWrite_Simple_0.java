package z.ExcelReadWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite_Simple_0 {

	//private static final String FILE_NAME = "../tmp/MyFirstExcel.xlsx";
	public static final String FILE_NAME = System.getProperty("user.dir") + "/EmployeeSalary.xlsx";

	public static void main(String[] args) {

		// Creating Excel Work Books & sheet reference Using Apache POI
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Payroll");

		// Start Creating Excel Table :  Header Rows & Columns  !!
		System.out.println("Start Creating Excel Table :  Header Rows & Columns  !!");
		String[] columnHeader= {"SL#","Employee Name","Total Hour","Hourly-Rate","Gross-Pay","Net-Pay","Result"};
		Row headerRow = sheet.createRow(0);
		int headerColPointer = 0;
		for(int i=0; i<columnHeader.length;i++) {
			Cell headerCell = headerRow.createCell(headerColPointer++);
			headerCell.setCellValue((String) columnHeader[i]);
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