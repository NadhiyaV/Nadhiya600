package practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToSelectChemicalsDropDownb {

	public static void main(String[] args) {
		// To Launch Browser
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://localhost:8888/");
		
		//To Login the application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//To navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create Organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		//To create mandatory data and select dropdown option
		driver.findElement(By.name("accountname")).sendKeys("Tavent Organization5");
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select select=new Select(dropdown);
		select.selectByValue("Chemicals");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//To Validate the expected data with actual data
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains("Tavent")) {
			System.out.println(name+"--name is passed");
		}
		else
			System.out.println(name+"name is failed");
		
		//logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action= new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//close
		driver.quit();

	}

}
