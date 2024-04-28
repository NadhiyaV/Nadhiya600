package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToUseDDTToChangeOrganizationName {
	public static void main(String[] args) throws IOException {
		// To Read Common data from properties file
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		// To Read Test data from Excel sheet
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String organationname = wb.getSheet("Organization").getRow(1).getCell(2).toString();
		System.out.println(organationname);
		// Script
		// To Launch the browser
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		// To Login to Application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// To Navigate Organization link
		driver.findElement(By.linkText("Organizations")).click();

		//To click create organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//random number gebneration
		Random r = new Random();
		int random = r.nextInt(1000);
		// To create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(organationname + random);
		
		//To save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(organationname)) {
			System.out.println(name + "--name is passed");
		} else
			System.out.println(name + "--name is failed");

		//To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		//To close the application
		driver.quit();
	}

}
