package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
//Constructor
	public CreateContactsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastnametextfield;
	
	@FindAll({@FindBy(name="button"),@FindBy(xpath = "//input[@title='Save [Alt+S]']")})
	private WebElement savebutton;
	
	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelbutton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addorganizationicon;
	
	public WebElement getAddorganizationicon() {
		return addorganizationicon;
	}

	public WebElement getLastnametextfield() {
		return lastnametextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}

	
}
