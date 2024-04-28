package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
public Organizations(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(linkText = "gooduivtiger")
private WebElement organizationname;
public WebElement getOrganizationname() {
	return organizationname;
}
}
