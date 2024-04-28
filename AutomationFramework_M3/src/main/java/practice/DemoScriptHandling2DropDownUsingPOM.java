package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.javaUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfomationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class DemoScriptHandling2DropDownUsingPOM {

	public static void main(String[] args) throws IOException {
		WebDriverUtility wdu= new WebDriverUtility();
		ExcelFileUtility efu= new ExcelFileUtility();
		PropertyFileUtility pfu= new PropertyFileUtility();
		javaUtility ju= new javaUtility();

		WebDriver driver=null;
		
		String BROWSER=pfu.toReadDataFromPropertiesFile("browser");
		String URL=pfu.toReadDataFromPropertiesFile("url");
		String USERNAME=pfu.toReadDataFromPropertiesFile("username");
		String PASSWORD=pfu.toReadDataFromPropertiesFile("password");
		String ORGANIZATIONNAME = efu.toReadDataFromExcelFile("Organization", 1, 2);
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.get(URL);
		wdu.maximizeWindow(driver);
		wdu.waitForElements(driver);
		
		//To Login
		LoginPage lp= new LoginPage(driver);
		lp.toLogin(USERNAME,PASSWORD);
		HomePage hp= new HomePage(driver);
		hp.getOrganization().click();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getAddicon().click();
		OrganizationInfomationPage oip= new OrganizationInfomationPage(driver);
		int randomnum = ju.toGetRandomNumber();
		oip.getOrganizationname().sendKeys(ORGANIZATIONNAME+randomnum);
		//oip.getIndustrydropdown().click();
		WebElement DDOPTION = oip.getIndustrydropdown();
		String option = oip.getDropdownoption().getText();
		wdu.handleDropDown(DDOPTION, option);
		WebElement TYPEDD = oip.getTypedropdown();
		wdu.handleDropDown("Customer", TYPEDD);
		//wdu.handleDropDown(option, DDOPTION);
		oip.getSavebutton().click();
		String Conformationmsg = oip.getOrginformationmsg().getText();
		if(Conformationmsg.contains(ORGANIZATIONNAME)) {
			System.out.println(Conformationmsg+"-- TEST SCRIPT PASSED");
		}
		else
			System.out.println(Conformationmsg+"-- TEST SCRIPT FAILED");
		hp.getAdminstratoricon().click();
		hp.getSignout().click();
		//to quit the app
		driver.quit();

	}

}
