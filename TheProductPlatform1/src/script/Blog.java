package script;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Blog {

	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\live\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
	     
        // To maximize browser  
       driver.manage().window().maximize();  
    
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://thebootcampplatform.com/"); 
        
       /* WebElement blog= driver.findElement(By.xpath("//p[@class=\"blog-text\"]"));
        blog.click();*/
	
   	 WebElement register = driver.findElement(By.xpath("//button[@class='signup-btn start-btn tw-whitespace-nowrap']"));
   	 register.click();
   
   	 /*WebElement Register = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
   	 Register.click();*/
   	 
   	 //@FindBy(css ="[class=\"submission-pop-up\"] [class=\"static-screen-register-content\"] span")
   	 WebElement loginbutton = driver.findElement(By.xpath("//span[text()='Login']"));
   	 loginbutton.click();
   	
   	 WebElement mobileNumber=driver.findElement(By.xpath("//input[@type='number']"));
   	 mobileNumber.click();
   	  mobileNumber.sendKeys("9553259691");
   	 
   	 //loginbutton.click();
   	 
   	 WebElement Password= driver.findElement(By.xpath("//input[@type='password']"));
   	 //Password.click();
   	 Password.sendKeys("1919");
   	 
   	 WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
   	 Login.click();
        
	}
}
