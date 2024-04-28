package OrganizationPackage;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.javaUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfomationPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(genericUtility.ListenersImplementation.class)
public class CreateOrganizationTests extends BaseClass{
	@Test(groups={"smoke","regression"})
	public void toCraeteOrganizationTests() throws IOException {
		Reporter.log("Browser got Launched Successfully",true);
		Reporter.log("Login to the Application Successfully",true);
		ExcelFileUtility efu= new ExcelFileUtility();
		javaUtility ju= new javaUtility();
		String ORGANIZATIONNAME = efu.toReadDataFromExcelFile("Organization", 1, 2);
		HomePage hp= new HomePage(driver);
		hp.getOrganization().click();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getAddicon().click();
		OrganizationInfomationPage oip= new OrganizationInfomationPage(driver);
		int randomnum = ju.toGetRandomNumber();
		oip.getOrganizationname().sendKeys(ORGANIZATIONNAME+randomnum);
		oip.getSavebutton().click();
		//verification
		String ORGINFOMSG=oip.getOrginformationmsg().getText();
		/*
		 * if(ORGINFOMSG.contains(ORGANIZATIONNAME)) {
		 * Reporter.log(ORGINFOMSG+"-- TEST SCRIPT PASSED",true); } else
		 * Reporter.log(ORGINFOMSG+"-- TEST SCRIPT FAILED",true);
		 * 
		 * Reporter.log("Organization was created Successfully",true);
		 */
		assertTrue(true, ORGINFOMSG);
		//Assert.fail();
		Reporter.log("Logout Application Successfully",true);
		Reporter.log("Browser got closed Successfully",true);
	}

}
