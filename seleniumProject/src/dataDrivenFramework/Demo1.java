package dataDrivenFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1 {

	int i = 1;
	@Test(dataProvider="provider")
	public void readData(String userName, String password) {
		System.out.println(i +" : " + userName + " - " + password);
		i++;
	}
	
	@DataProvider(name="provider")
	public Object[][] provideData() {
		Object[][] data = new Object[3][2];
		
		System.out.println(data.length);
		data[0][0] = "Demo1";
		data[0][1] = "pass1";
		
		data[1][0] = "Demo2";
		data[1][1] = "pass2";
		
		data[2][0] = "Demo3";
		data[2][1] = "pass3";
		
		return data;
	}
}


