package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_Actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		// create object for actions class
		Actions action= new Actions(driver);
		
		WebElement computers = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));
		
		action.moveToElement(computers).perform();
		
		WebElement desktop= driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));
		action.moveToElement(desktop).perform();
		

	}

}
