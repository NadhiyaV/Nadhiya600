package practice;
import java.io.IOException;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;

public class ToPracticeGU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility pfu= new PropertyFileUtility();
		String URL = pfu.toReadDataFromPropertiesFile("url");
		System.out.println(URL);
		String BROWSER = pfu.toReadDataFromPropertiesFile("browser");
		System.out.println(BROWSER);
		String USERNAME = pfu.toReadDataFromPropertiesFile("username");
		System.out.println(USERNAME);
		String PASSWORD = pfu.toReadDataFromPropertiesFile("password");
		System.out.println(PASSWORD);
		
		ExcelFileUtility efu= new ExcelFileUtility();
		String data = efu.toReadDataFromExcelFile("Contacts", 1, 2);
		System.out.println(data);
		int noofdata = efu.toGetRowCount("Contacts");
		System.out.println(noofdata);
		
	}

}
