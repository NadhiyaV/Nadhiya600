package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//constructor
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameTextFild;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordTextField;
	
	public WebElement getUsernameTextFild() {
		return usernameTextFild;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}


	public WebElement getLoginbutton() {
		return loginbutton;
	}
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	
	//Business Library
	public void toLogin(String username,String password) {
		usernameTextFild.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginbutton.click();
	}
}
