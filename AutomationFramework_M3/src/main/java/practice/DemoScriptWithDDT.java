package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScriptWithDDT {

	public static void main(String[] args) throws IOException {
		// To Read Data from Properties file
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		// To read data from Excel sheet
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet("Contacts").getRow(1).getCell(2).toString();
		System.out.println(value);
		// To launch Browser
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(URL);

		// To Login the application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// To Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// To store data in mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(value);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// To Validate the expected data with actual data
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(value)) {
			System.out.println(name + "--name is passed");
		} else
			System.out.println(name + "name is failed");

		// To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// To close
		driver.quit();

	}

}
