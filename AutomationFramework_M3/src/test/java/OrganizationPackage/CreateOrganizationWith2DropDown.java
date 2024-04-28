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
public class CreateOrganizationWith2DropDown extends BaseClass{
@Test(groups="regression")
	public void toCreateOrganizationWithDropDown()throws IOException {
		Reporter.log("Browser got Launched Successfully",true);
		Reporter.log("Login to the Apllication successfully",true);
		//web driver utility in genericUtility Package(different package)
		WebDriverUtility wdu= new WebDriverUtility();
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
		//oip.getIndustrydropdown().click();
		WebElement DDOPTION = oip.getIndustrydropdown();
		String option = oip.getDropdownoption().getText();
		wdu.handleDropDown(DDOPTION, option);
		WebElement TYPEDD = oip.getTypedropdown();
		wdu.handleDropDown("Customer", TYPEDD);
		//wdu.handleDropDown(option, DDOPTION);
		oip.getSavebutton().click();
		Reporter.log("organization name with industry and type dropdown craeted successfully",true);
		String Conformationmsg = oip.getOrginformationmsg().getText();
		//assertTrue(true, Conformationmsg);
		Assert.fail();
		Reporter.log("organization name was varified successfully",true);
		Reporter.log("Logout application Successfully",true);
		Reporter.log("Brower got closed sucessfully",true);
	}

}
