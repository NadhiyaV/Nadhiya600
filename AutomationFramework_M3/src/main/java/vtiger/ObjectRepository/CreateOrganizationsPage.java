package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationsPage {
//Constructor
	public CreateOrganizationsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement organizationname;
	
	@FindAll({@FindBy(name="button"),@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")})
	private WebElement savebutton;
	
	@FindAll({@FindBy(name="button"),@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")})
	private WebElement cancelbutton;

	public WebElement getOrganizationname() {
		return organizationname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}
}
