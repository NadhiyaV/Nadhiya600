package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_DragandDrop {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Actions action= new Actions(driver);
		
		WebElement source = driver.findElement(By.id("box3"));
		
		WebElement target = driver.findElement(By.id("box103"));
		action.dragAndDrop(source, target).perform();
		
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement italy = driver.findElement(By.id("box106"));
		action.clickAndHold(rome).moveToElement(italy).click().perform();
		
		WebElement store=driver.findElement(By.id("small-searchterms"));
		
		action.moveToElement(store).click().sendKeys("mobiles").perform();
		
		}
	
	

}
