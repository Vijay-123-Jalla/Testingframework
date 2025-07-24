package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reading 
{
	private Workbook book;
	private Sheet sheet;
	Logger log;
	public Excel_reading(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		log.debug("Excel_reading");
		if (filePath.endsWith(".xlsx")) 
		{
			book = new XSSFWorkbook(fis);
		} 
		else if (filePath.endsWith(".xls")) 
		{
			book = new HSSFWorkbook(fis);
		} 
		else 
		{
			throw new IllegalArgumentException("Invalid file format. Only .xls and .xlsx supported.");
		}

		sheet = book.getSheet(sheetName);
		if (sheet == null)
		{
			throw new IllegalArgumentException("Sheet: " + sheetName + " not found in file: " + filePath);
		}
	}

	public String getCellData(int rowNum, int colNum) 
{
		log.debug("Excel_reading");
	Row row=sheet.getRow(rowNum);
	Cell cell=row.getCell(colNum);
	if(row==null || cell==null)
	{
		
		return "Row or Cell are null";
	}
	String celldata=cell.getStringCellValue();
     return celldata;
}
	 public int getRowCount()
	 {
			log.debug("getRowCount");
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	 }
	 public int getColumnCount()
	 {
			log.debug("getColumnCount");
		int columncount=sheet.getLastRowNum();
		return columncount;
		}
public void printAllData() {
    for (Row row : sheet) {
        for (Cell cell : row) {
            System.out.print(new DataFormatter().formatCellValue(cell) + "\t");
        }
        System.out.println();
    }
}
public void close() throws IOException {
   
	
	log.debug("close");
	book.close();
}

}