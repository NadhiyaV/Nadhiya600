package practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.Organizations;

public class DemoScript2createContactWithOrganization {

	public static void main(String[] args) throws IOException {
		WebDriverUtility wdu= new WebDriverUtility();
		PropertyFileUtility pfu= new PropertyFileUtility();
		ExcelFileUtility efu= new ExcelFileUtility();
		
		WebDriver driver=null;
		
		String BROWSER=pfu.toReadDataFromPropertiesFile("browser");
		String URL=pfu.toReadDataFromPropertiesFile("url");
		String USERNAME=pfu.toReadDataFromPropertiesFile("username");
		String PASSWORD=pfu.toReadDataFromPropertiesFile("password");
		String LASTNAME = efu.toReadDataFromExcelFile("Contacts", 1, 2);
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.get(URL);
		wdu.maximizeWindow(driver);
		wdu.waitForElements(driver);
		
		//To Login
		LoginPage lp= new LoginPage(driver);
		lp.toLogin(USERNAME,PASSWORD);
		//lp.getUsernameTextFild().sendKeys(USERNAME);
		//lp.getPasswordTextField().sendKeys(PASSWORD);
		//lp.getLoginbutton().click();
		
		//To click contacts link
		HomePage hp= new HomePage(driver);
		hp.getContacts().click();
		//To click on look up image
		ContactsPage cp= new ContactsPage(driver);
		cp.getAddicon().click();
		//enter the lastname
		CreateContactsPage ccp= new CreateContactsPage(driver);
		ccp.getLastnametextfield().sendKeys(LASTNAME);
		String parentid = driver.getWindowHandle();
		ccp.getAddorganizationicon().click();
		Set<String> allwindids = driver.getWindowHandles();
		allwindids.remove(parentid);
		for(String windowid:allwindids) {
			driver.switchTo().window(windowid);
			Organizations org= new Organizations(driver);
			org.getOrganizationname().click();
		}
		driver.switchTo().window(parentid);
		ccp.getSavebutton().click();
		ContactsInformationPage cip= new ContactsInformationPage(driver);
		String NAME = cip.getContactsinformationmessage().getText();
		if(NAME.contains(LASTNAME)) {
			System.out.println(NAME+"-- TEST SCRIPT PASSED");
		}else
			System.out.println(NAME+"-- TEST SCRIPT FAILED");
		hp.getAdminstratoricon().click();
		hp.getSignout().click();
		//to quit the app
		driver.quit();
		

	}

}
