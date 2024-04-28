package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		public HomePage(WebDriver driver){
			PageFactory.initElements(driver,this);
		}
		@FindBy(linkText = "Contacts")
		private WebElement contacts;
		public WebElement getContacts() {
			return contacts;
		}
		@FindBy(linkText = "Organizations")
		private WebElement organization;
		public WebElement getOrganization() {
			return organization;
		}
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminstratoricon;
		public WebElement getAdminstratoricon() {
			return adminstratoricon;
		}
		@FindBy(linkText = "Sign Out")
		private WebElement signout;
		public WebElement getSignout() {
			return signout;
		}
}
