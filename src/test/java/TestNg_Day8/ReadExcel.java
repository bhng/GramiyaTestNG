package TestNg_Day8;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test	
	void excelread() throws IOException {
		//open excel file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Data\\Test Data Read.xlsx");
		//open workbook
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//goto sheet
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//XSSFSheet sheet=workbook.getSheetAt(1); // index start with 0
		int rows=sheet.getLastRowNum();//how many no of rows in sheet
		int cells=sheet.getRow(0).getLastCellNum();//how many number of cells in one row
		System.out.println(rows);// Print number of rows
		System.out.println(cells); // Print number of cells
		
		for(int r=0;r<=rows;r++) {
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0;c<cells;c++) {
				XSSFCell cell=currentrow.getCell(c);//goto current cell (0,0)
				String value=cell.toString();//read the cell data
				System.out.print(value+" ");// Print the cell data we are using pint()
			}
			System.out.println(); // Move to the next line after printing each row
		}
		workbook.close();
		file.close();
	}

}
