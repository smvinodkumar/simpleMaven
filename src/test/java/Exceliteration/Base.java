package Exceliteration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	static WebDriver driver;
	
	public static void launchBrowser() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\desk\\eclipse-selenium\\simpleMaven\\drivers\\chromedriver.exe" );
			driver = new ChromeDriver();
			}
	public static void loadurl(String url) {
		driver.get(url);	
	    }
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void getCurrentUrl() {
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
	}
	public static void fill(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static  void selectByI(WebElement w, int index) {
		Select s = new Select(w);
		s.selectByIndex(index);
	}
	public static void buttonClick(WebElement c) {
		c.click();
	}
	public static void quit() {
	driver.quit();
	}
	public static String getDatafromExcel(int rowno,int cellno) throws Throwable {
	File f = new File("C:\\Users\\desk\\eclipse-selenium\\simpleMaven\\Excel\\Exceldata.xlsx");
	String value=null;
	FileInputStream strem = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(strem);
	Sheet s = w.getSheet("Sheet1");
	Row r = s.getRow(rowno);
	Cell c = r.getCell(cellno);
	int type = c.getCellType();
	if (type==1) {
	 value = c.getStringCellValue();	
	}
	else if (type==0) {
		if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat simple = new SimpleDateFormat("dd-mmm-yy");
			 value = simple.format(dateCellValue);
		}else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long)numericCellValue;
			 value = String.valueOf(l);
		}
		
	}return value;
	}
}
