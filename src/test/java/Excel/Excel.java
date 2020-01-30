package Excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

		public static void main(String[] args) throws Throwable{
			//path of the Excel
			File f = new File("C:\\Users\\desk\\eclipse-selenium\\simpleMaven\\Excel\\Exceldata.xlsx");
			//convert to object
			FileInputStream st = new FileInputStream(f);
			//Opening of workbook
			Workbook w = new XSSFWorkbook(st);
			//Opening of WORKBOOK SHEET
			Sheet s = w.getSheet("Sheet1");
			//for row count
			int rowcount = s.getPhysicalNumberOfRows();
			System.out.println(rowcount);
			//opening of Rows in sheet
			Row r = s.getRow(1);
			//for cell count
			int cellcount = r.getPhysicalNumberOfCells();
			System.out.println(cellcount);
			//opening of cells in row
			Cell c = r.getCell(4);
			//to print out of the cell
			System.out.println(c);
			
			//to print all values
			for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
				Row row = s.getRow(i);
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					System.out.println(cell);
					
				}
				
			}			
		}

	}

