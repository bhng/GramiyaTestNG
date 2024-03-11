package TestNg_Day9;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	@Test
	void excelwrite() throws IOException {
		//open file to write
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Data\\Test Data Write.xlsx");
		//open workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		//create sheet
		XSSFSheet sheet=workbook.createSheet();
		XSSFRow row1=sheet.createRow(0);//create 1st row
		row1.createCell(0).setCellValue("Selenium");//write data into cell
		row1.createCell(1).setCellValue("Java");
		row1.createCell(2).setCellValue("TestNG");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("Datadriven");
		row2.createCell(1).setCellValue("Hybrid");
		
		workbook.write(file);//this will write data into xl
		workbook.close();
		file.close();
				System.out.println("writing completed");
	}	
}
