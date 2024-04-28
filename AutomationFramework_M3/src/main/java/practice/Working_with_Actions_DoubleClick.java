package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_Actions_DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		Thread.sleep(2000);
		
		//create an object of actions class
		Actions action= new Actions(driver);
		//WebElement doubleclick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
		
		//action.doubleClick(doubleclick).perform();
		
		action.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"))).perform();
	}

}
