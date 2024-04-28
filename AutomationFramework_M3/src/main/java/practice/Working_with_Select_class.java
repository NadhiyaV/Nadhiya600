package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Working_with_Select_class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("Books")).click();
		//Identify the web elements
		WebElement sort=driver.findElement(By.id("products-orderby"));
		WebElement displaydd=driver.findElement(By.id("products-pagesize"));
		WebElement griddd= driver.findElement(By.id("products-viewmode"));
		
		
		Select select= new Select(sort);
		Select select1= new Select(displaydd);
		Select select2= new Select(griddd);
		
		try {
		select.selectByVisibleText("Price: Low to High");
		//Thread.sleep(1000);
//		WebElement displaydd=driver.findElement(By.id("products-pagesize"));
//		Select select1= new Select(displaydd);
		Thread.sleep(2000);
		select1.selectByValue("https://demowebshop.tricentis.com/books?pagesize=12");
//		select1.selectByVisibleText("12");
//		Thread.sleep(1000);
//		WebElement griddd= driver.findElement(By.id("products-viewmode"));
//		Select select2= new Select(griddd);
		select2.selectByIndex(1);
		}
		
		finally {
			System.out.println("handlied");
		}
//		
		
		//get options
		
		/*
		 * List<WebElement> sort_by_values =select.getOptions(); for(WebElement
		 * ele:sort_by_values) { System.out.println(ele.getText()); }
		 */
		
		System.out.println(select.isMultiple());
	}

}
