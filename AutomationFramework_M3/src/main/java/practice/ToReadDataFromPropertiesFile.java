package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		//step1: craeate object for fis
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		Properties pro= new Properties();
		
		pro.load(fis);
		String URL = pro.getProperty("browser");
		System.out.println(URL);
		

	}

}
