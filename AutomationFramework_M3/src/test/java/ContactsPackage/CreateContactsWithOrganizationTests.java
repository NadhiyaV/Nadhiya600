package ContactsPackage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import vtiger.ObjectRepository.ContactsInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.Organizations;
@Listeners(genericUtility.ListenersImplementation.class)
public class CreateContactsWithOrganizationTests extends BaseClass{
	@Test(groups="regression")
	public void toCreateContactsandOrganization() throws IOException{
		
		ExcelFileUtility efu= new ExcelFileUtility();
		String LASTNAME = efu.toReadDataFromExcelFile("Contacts", 1, 2);
		//To Login
		Reporter.log("Browser got Launched Successfully",true);
		Reporter.log("Login to application successfully",true);
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
		Reporter.log("Contacts with Organization name Created Successfully",true);
		ContactsInformationPage cip= new ContactsInformationPage(driver);
		String NAME = cip.getContactsinformationmessage().getText();
		/*
		 * if(NAME.contains(LASTNAME)) {
		 * Reporter.log(NAME+"TEST SCRIPT IS PASSED",true); }else
		 * Reporter.log(NAME+"TEST SCRIPT IS FAILED",true);
		 */
		//assertTrue(true, NAME);
		Assert.fail();
		Reporter.log("Contacts Created Successfully and validated.",true);
		Reporter.log("Logout Application Successfully",true);
		Reporter.log("Browser got closed Successfully",true);		

	}

}
