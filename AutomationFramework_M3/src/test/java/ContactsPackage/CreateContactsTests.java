package ContactsPackage;
import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import vtiger.ObjectRepository.ContactsInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactsPage;
import vtiger.ObjectRepository.HomePage;
@Listeners(genericUtility.ListenersImplementation.class)
public class CreateContactsTests extends BaseClass{
	
	@Test(groups="smoke")
		
		public void toCreateContacts_001() throws IOException {
		Reporter.log("Browser gor Launched Successfully",true);
		Reporter.log("Login to an application successfully",true);
		ExcelFileUtility efu= new ExcelFileUtility();
		String LASTNAME=efu.toReadDataFromExcelFile("Contacts", 1, 2);
		//To click contacts link
		HomePage hp= new HomePage(driver);
		hp.getContacts().click();
		//Create contact look up image
		ContactsPage cp= new ContactsPage(driver);
		cp.getAddicon().click();
		//enter the lastname
		CreateContactsPage ccp= new CreateContactsPage(driver);
		ccp.getLastnametextfield().sendKeys(LASTNAME);
		//To save the contact
		ccp.getSavebutton().click();
		Reporter.log("Contact Created Successfully",true);
		// to validate
		ContactsInformationPage cip= new ContactsInformationPage(driver);
		String NAME = cip.getContactsinformationmessage().getText();
		//assertTrue(true, NAME);
		Assert.fail();
		Reporter.log("Contacts page validated Successfully",true);
		Reporter.log("Application Logout Successfully",true);
		Reporter.log("Browser got closed Successfully",true);
	}

}
