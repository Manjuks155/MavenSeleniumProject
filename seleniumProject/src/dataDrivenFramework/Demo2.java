package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {

	int i=1;
	@Test(dataProvider="provider")
	public void readData(String userName, String passWord) {
		System.out.println(i + " : " + userName + " - " + passWord);
		i++;
	}


	@DataProvider(name="provider")
	public Object[][] provideData() throws IOException {

		File file = new File("./testData/testData.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = (sheet.getLastRowNum())+1;

		Object[][] data = new Object[rows][2];

		for(int i=0; i<rows; i++) {

			data[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1] = sheet.getRow(i).getCell(1).getStringCellValue();
		}

		wb.close();
		return data;

	}

}
