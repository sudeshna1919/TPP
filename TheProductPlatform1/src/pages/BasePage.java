package pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BasePage {
	public static WebDriver driver;
	@BeforeTest 
    public void initializeWebDriver() throws IOException {  
		//System.setProperty("webdriver.chrome.driver","‪C:\\Users\\Dell\\Desktop\\live\\chrome122\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
	     
        // To maximize browser  
       driver.manage().window().maximize();  
    
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("http://theproductplatformqe.s3-website.ap-south-1.amazonaws.com/"); 
	
	}
	
	 @AfterTest
	 public void quitDriver() {  
         driver.quit();  
    }
	

}
