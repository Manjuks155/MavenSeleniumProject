package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadCellValue {

	public static void main(String[] args) throws IOException {
		
		File file = new File("testData/testData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println("Number of rows : " + (sheet.getLastRowNum()+1));
		
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		
		sheet.getRow(0).createCell(2).setCellValue("Added");
		
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		
		wb.close();
	}

}
