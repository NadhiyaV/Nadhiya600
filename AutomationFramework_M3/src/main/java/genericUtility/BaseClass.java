package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	WebDriverUtility wdu= new WebDriverUtility();
	PropertyFileUtility pfu= new PropertyFileUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;
@BeforeSuite(groups="smoke")
public void beforeSuiteConfiguration() {
	Reporter.log("To connect with data base",true);
}
//@Parameters("browser")

//@BeforeTest
@BeforeClass(groups="smoke")
public void beforeClassConfiguration() throws IOException { 
	String BROWSER=pfu.toReadDataFromPropertiesFile("browser");
	String URL=pfu.toReadDataFromPropertiesFile("url");
	if(BROWSER.contains("chrome")){
		driver= new ChromeDriver();
	}else if(BROWSER.contains("edge")) {
		driver= new EdgeDriver();
	}
	sDriver=driver;
	wdu.maximizeWindow(driver);;
	wdu.waitForElements(driver);
	driver.get(URL);
}
@BeforeMethod(groups="smoke")
public void beforeMethodConfiguration() throws IOException {
	String USERNAME=pfu.toReadDataFromPropertiesFile("username");
	String PASSWORD=pfu.toReadDataFromPropertiesFile("password");
	LoginPage lp= new LoginPage(driver);
	lp.toLogin(USERNAME,PASSWORD);
}
@AfterMethod(groups="smoke")
public void afterMethodConfiguration() {
	HomePage hp= new HomePage(driver);
	hp.getAdminstratoricon().click();
	hp.getSignout().click();
}
@AfterClass(groups="smoke")
public void afterClassConfiguration() {
	driver.quit();
}

}
