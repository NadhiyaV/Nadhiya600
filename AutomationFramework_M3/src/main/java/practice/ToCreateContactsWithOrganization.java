package practice;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateContactsWithOrganization {

	public static void main(String[] args) throws IOException {
/** create object for the class to use the non static method
 * 		
 */
		WebDriverUtility wutily= new WebDriverUtility();
		PropertyFileUtility putily= new PropertyFileUtility();
		ExcelFileUtility eutily= new ExcelFileUtility();
/**
 * To call the methods and store it in variables		
 */
		String URL = putily.toReadDataFromPropertiesFile("url");
		String BROWSER = putily.toReadDataFromPropertiesFile("browser");
		String USERNAME = putily.toReadDataFromPropertiesFile("username");
		String PASSWORD = putily.toReadDataFromPropertiesFile("password");
		String LASTNAME = eutily.toReadDataFromExcelFile("Contacts", 1, 2);
/**
 * Check the driver control witch is present in out system
 */
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		//To make the driver to wait until web elements to be loaded
		wutily.waitForElements(driver);
		//To maximize the window by calling maximize method
		wutily.maximizeWindow(driver);
		driver.get(URL);
		
		
//To Login the application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	
//To Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
				
		//click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
		//To store data in mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		//To select the Organization using the web driver method switchto method
		wutily.toSwichWindow(driver, "Accounts");
		driver.findElement(By.linkText("nadhiya")).click();
		//ToSwitch back using Switch back method in web driver utility 
		wutily.toSwichWindow(driver, "Contacts");
		//To save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains(LASTNAME)) {
			System.out.println(name+"--name is passed");
		}
		else
			System.out.println(name+"name is failed");
			
		//To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutily.toMouseHOver(driver, logout);
		driver.findElement(By.linkText("Sign Out")).click();
				
		//To close the application
		driver.quit();

	}

}
