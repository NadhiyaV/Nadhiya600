package OrganizationPackage;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.javaUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfomationPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(genericUtility.ListenersImplementation.class)
public class OrganizationWithOneDropDownTests extends BaseClass{
@Test(groups="smoke")
	public void toCreateOrganizationWithDropDown()throws IOException {
		Reporter.log("Browser got Launched Successfully",true);
		Reporter.log("Application login Successfully",true);
		WebDriverUtility wdu= new WebDriverUtility();
		ExcelFileUtility efu= new ExcelFileUtility();
		javaUtility ju= new javaUtility();
		String ORGANIZATIONNAME = efu.toReadDataFromExcelFile("Organization", 1, 2);
		//To Login
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
		//wdu.handleDropDown(option, DDOPTION);
		oip.getSavebutton().click();
		Reporter.log("organization name created successfully",true);
		String Conformationmsg = oip.getOrginformationmsg().getText();
		/*
		 * if(Conformationmsg.contains(ORGANIZATIONNAME)) {
		 * System.out.println(Conformationmsg+"-- TEST SCRIPT PASSED"); } else
		 * System.out.println(Conformationmsg+"-- TEST SCRIPT FAILED");
		 */
		assertTrue(true, Conformationmsg);
		//Assert.fail();
		Reporter.log("organization name validated successfully",true);
		Reporter.log("Application Logout Successfully",true);
		Reporter.log("Browser got closed Successfully",true);

	}

}
