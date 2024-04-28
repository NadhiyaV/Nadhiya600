package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.Select;

		public class ToCreateRandomNumber {
			public static void main(String[] args) {
			//To launch the Browser
				WebDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888/");
				
			//To Login to Application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				//To Navigate Organization link
				driver.findElement(By.linkText("Organizations")).click();
				
			//To click create organization look up image
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			//random number gebneration
				Random r=new Random();
				int random=r.nextInt(1000);
				//To create Organization with mandatory fields
				driver.findElement(By.name("accountname")).sendKeys("Tavent"+random);
				
			//To Select energy in the industry dropdown
				WebElement dropdown = driver.findElement(By.name("industry"));
				Select select= new Select(dropdown);
				select.selectByValue("Energy");
				
			//To Select Customer in the type dropdown
				WebElement accounttype = driver.findElement(By.name("accounttype"));
				Select select1=new Select(accounttype);
				select1.selectByValue("Customer");
				
			//To save and verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(name.contains("Tavent"))
				{
					System.out.println(name+"--name is passed");
				}
				else
					System.out.println(name+"--name is failed");
			
			//To logout
				WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action= new Actions(driver);
				action.moveToElement(logout).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
			//To close the application
				driver.quit();
				

			}

				
	}


