package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfomationPage {
//Constuctor
	public OrganizationInfomationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//organization text field
	@FindBy(name="accountname")
	private WebElement organizationname;
	public WebElement getOrganizationname() {
		return organizationname;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public WebElement getTypedropdown() {
		return typedropdown;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	
	//industry dropdown
	@FindBy(name="industry")
	private WebElement industrydropdown;
	//Type dropdown
	@FindBy(name="accounttype")
	private WebElement typedropdown;
	//save button
	@FindAll({@FindBy(name="button"),@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")})
	private WebElement savebutton;
	//cancel button
	@FindAll({@FindBy(name="button"),@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")})
	private WebElement cancelbutton;
	//organization infomation msg
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orginformationmsg;
	//industry dropdown option
	@FindBy(xpath = "//option[@value='Engineering']")
	private WebElement dropdownoption;
	
	public WebElement getDropdownoption() {
		return dropdownoption;
	}
	public WebElement getOrginformationmsg() {
		return orginformationmsg;
	}
}
