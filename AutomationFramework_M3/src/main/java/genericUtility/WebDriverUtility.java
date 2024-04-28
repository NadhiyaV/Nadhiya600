package genericUtility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class consists of methods related to webdriver
 */
public class WebDriverUtility {
/**
 * this method maximize the browser
 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait webelements to be loaded
	 * @param driver
	 */
	public void waitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	/**
	 * this method will wait until element is clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will wait until element is visible
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will select based on index in dropdown
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method will select based on value in dropdown
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/** this method will select based on visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method will perform double click on anywhere
	 * @param driver
	 */
	public void toDubleClick(WebDriver driver) {
		Actions action= new Actions(driver);
		action.doubleClick().perform();
			
	}
	/**
	 * this method will perform double clivk on web element
	 * @param driver
	 * @param element
	 */
	
	public void toDubleClickOnElement(WebDriver driver,WebElement element) {
		Actions action= new Actions(driver);
		action.doubleClick(element).perform();
			
	}
	/*
	 * this method will perform right click on anywhere
	 */
	public void toRightClick(WebDriver driver) {
		Actions action= new Actions(driver);
		action.contextClick().perform();
			
	}
	/**
	 * this method will perform right click on web element
	 * @param driver
	 * @param element
	 */
	public void toRightClickOnElement(WebDriver driver,WebElement element) {
		Actions action= new Actions(driver);
		action.contextClick(element).perform();
			
	}
	/** this method will perform mouse hover action on anywhere
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHOver(WebDriver driver,WebElement element) {
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method will perform drag and drop on web element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragandDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions action= new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	/** this method will perform click and hold anywhere
	 * 
	 * @param driver
	 */
	public void toClickandHold(WebDriver driver) {
		Actions action= new Actions(driver);
		action.clickAndHold().perform();
	}
	/** this method will perform switch to based on id
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/** this method will perform switch to frame based on id or name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver,String id_name) {
		driver.switchTo().frame(id_name);
	}
	/** this method will perform switch to frame based on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/** this method will switch back to immediate parent frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
		
	}
	/** this method will switch back to main page
	 * 
	 * @param driver
	 */
	public void toSwitchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will switch the driver control to alert
	 * @param driver
	 */
	public void toSwitchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	/**
	 * this method will switch the driver control to alert and click on ok button
	 * @param driver
	 */
	public void toSwitchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will switch the driver control to alert and get text
	 * @param driver
	 * @param text
	 * @return
	 */
	public String toSwitchToAlertandGetText(WebDriver driver, String text) {
		String text1 =driver.switchTo().alert().getText();
		return text1;
	}
	/**
	 * this method will switch driver control to alert and click on cancel
	 * @param driver
	 */
	public void toSwitchToAlertandDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will switch the driver control window to based on title
	 * @param driver
	 * @param partialname
	 */
	public void toSwichWindow(WebDriver driver,String partialname) {
		Set<String> allwind = driver.getWindowHandles();
		for(String id:allwind) {
			String currentTitle = driver.switchTo().window(id).getTitle();
			if(currentTitle.contains(partialname)) {
				break;
			}
		}
	}
	/**
	 * this method will take screenshot of web page
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String toTakeScreenShot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorshots/"+screenshotname+".jpeg");
		FileHandler.copy(temp, src);
		return src.getAbsolutePath();
	}
	/**
	 * this method is used to scroll the window using scrollIntoView method 
	 * @param driver
	 * @param element
	 * @param flag
	 */
	public void toScrollTheWindow(WebDriver driver,WebElement element) {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
}
