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
import genericUtility.javaUtility;

public class ToCreateOrganizationUsingUtitlity {
	public static void main(String[] args) throws IOException {
		//To use the all the non static methods inside these class we need to create object for these classes
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelFileUtility efu= new ExcelFileUtility();
		PropertyFileUtility pfu= new PropertyFileUtility();
		javaUtility ju= new javaUtility();
		//read common data from Properties file
		String URL = pfu.toReadDataFromPropertiesFile("url");
		String BROWSER = pfu.toReadDataFromPropertiesFile("browser");
		String USERNAME = pfu.toReadDataFromPropertiesFile("username");
		String PASSWORD = pfu.toReadDataFromPropertiesFile("password");
		//read test data from Excel sheet
		String NAMEOFORG = efu.toReadDataFromExcelFile("Organization", 1, 2);
		//To call random number
		int rn = ju.toGetRandomNumber();
		
		//To Start Script
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		wdu.waitForElements(driver);
		wdu.maximizeWindow(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(NAMEOFORG+rn);
		WebElement industorydd = driver.findElement(By.name("industry"));
		wdu.handleDropDown(industorydd, "Banking");
		WebElement typedd = driver.findElement(By.name("accounttype"));
		wdu.handleDropDown("Analyst", typedd);
		driver.findElement(By.xpath("//input[@value='T']")).click();
		//To save and verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(name.contains(NAMEOFORG))
				{
					System.out.println(name+"--name is passed");
				}
				else
					System.out.println(name+"--name is failed");
			
			//To logout
				WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wdu.toMouseHOver(driver, logout);
				driver.findElement(By.linkText("Sign Out")).click();
				
			//To close the application
				driver.quit();
		
	
	}

}
