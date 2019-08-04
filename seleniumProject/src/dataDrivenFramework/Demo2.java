package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(dataProvider="provider")
	public void createTest(String uName, String pwd) {
		System.out.println(uName + " - " + pwd);
	}

	@DataProvider(name="provider")
	public Object[][] testDataProvider() throws IOException {
		
		File file = new File("./testData/testData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int count = (sheet.getLastRowNum())+1;
		Object[][] data = new Object[count][2];
		
		for(int i=0; i<count; i++) {
			data[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1] = sheet.getRow(i).getCell(1).getStringCellValue();
		}
		
		return data;
	}

}
