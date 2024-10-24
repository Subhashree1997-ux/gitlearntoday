package org.two;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static void initBrowser(String browser) {
		switch(browser) {
		case "Chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
	    default:
	    	System.out.println("None of the drivers matched");
	    	break;
		}
	}
 public static void getURL(String url) {
	 driver.get(url);
	 
 }
public static String readExcelData(int rownum,int cellNum) {
	String value=null;
	try {
		File f=new File("/Users/dineshwaren/Desktop/ExcelRead.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fs);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch(cellType) {
		case STRING:
			value=cell.getStringCellValue();
			break;
		default:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s=new SimpleDateFormat("dd/MMMM/YYYY");
				value=s.format(dateCellValue);
			}else {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long)numericCellValue;
				BigDecimal valueOf = BigDecimal.valueOf(l);
				value=valueOf.toString();
			}
		}
	}catch(Exception e) {
		
	}
	return value;
	
}

}
