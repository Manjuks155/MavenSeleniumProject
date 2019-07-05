package advanced;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(listeners.TestListener.class)
public class ReadProprtyFile {

	@Test(priority=2, description="This is property file test case")
	public void read() throws IOException {
		File file = new File("testData\\config.properties");
		FileInputStream fid = new FileInputStream(file);
		
		Properties pro = new Properties();
		pro.load(fid);
		
//		System.out.println(pro.getProperty("userName"));
//		System.out.println(pro.getProperty("passWord"));
	}
	
	@Test(priority=1, description="This is demo test case")
	public void verify() {
		System.out.println("This is demo method");
		AssertJUnit.assertEquals("Manjunath", "Manjunatha");
	}
	
}
