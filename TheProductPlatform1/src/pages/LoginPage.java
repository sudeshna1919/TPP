package pages;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	 @FindBy(xpath="//button[@class='signup-btn start-btn ']")
	 WebElement register;
	 
	 @FindBy(xpath="//button[@class='static-screen-register-btn']")
	 WebElement Register;
	 
	// @FindBy(xpath="//span[text()='Login']")
	 @FindBy(css ="[class=\"submission-pop-up\"] [class=\"static-screen-register-content\"] span")
	 WebElement loginbutton;
	
	 @FindBy(xpath = "//input[@type='number']")  
	 WebElement mobileNumber;
	 
	 @FindBy(xpath= "//input[@type='password']")
	 WebElement Password;
	 
	 @FindBy(xpath= "//button[@type='submit']")
	 WebElement Login;
	 
	 @FindBy(xpath="//p[text()='Incorrect Pin']")
	 WebElement IncorrectPin;
	 
	 @FindBy(xpath="(//div[@class='navvbar-elements']//div//img[@alt='Avatar Image'])[1]")//(//div[@style='cursor: pointer;'])[2]
	 WebElement Profile;
	 
	 @FindBy(xpath="//div[@class='user-profile-details']//p")
	 WebElement email;
	 
	 @FindBy(xpath = "//span[normalize-space()='Logout']")  
	 WebElement logout;
	 
	 @FindBy(xpath= "//img[@alt='product-logo']")
	 WebElement productLogo;
	 
	 @FindBy(xpath="//div[contains(text(),'This number is not registered, please register to continue.')]")
	 WebElement unRegistered;
	 
	 
	 public LoginPage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public void LogInFromRegistration(String number, String pass) {
         
		 Login.click();
		 
		 mobileNumber.sendKeys(number);
		 
		 Login.click();
		 
		 Password.sendKeys(pass);
		 
		 Login.click();
		 
	 }
	 
	 public void logIn(String number, String pass) {
		 
		 mobileNumber.sendKeys(number);
		 
		 Login.click();
		 
		 Password.sendKeys(pass);
		 
		 Login.click();
		 
		 
	 }
	 
	 public String LogInValidation(String number, String pass) {
		 
		 String actual;
		 
		 Login.click();
		 
		 mobileNumber.sendKeys(number);
		 
		 Login.click();
		 
		 
		 
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		 
		 //validating the mobile number
		 
		 if (!isValidMobileNumber(number) || isAscendingOrder(number) || isContinuousSequence(number) || isDescendingOrder(number)) {
			 
			 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='existed']"))));
			
			 actual = driver.findElement(By.xpath("//p[@class='existed']")).getText();
			 
			 
	         
	        }
		 
		 else {
			 
			 Password.sendKeys(pass);
			 
			 Login.click();
			 
			 if(pass=="1919") {
				 
				 //Profile.click();	
				 
				 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='_common_text_1ab7o_203 _greeting_text_1ab7o_211']"))));
				 
				 actual = driver.findElement(By.cssSelector("[class='_common_text_1ab7o_203 _greeting_text_1ab7o_211']")).getText();
				 
				 System.out.println(actual);
			 }
			 
			 else {
				 
				 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Incorrect Pin']"))));
				 
				 actual = driver.findElement(By.xpath("//div[@class='user-pin-section']//p")).getText();
				 
				 
			 }
		 }
		 
		 
		 return actual;
	 }
	  
	 

   public String logInWithUnregistered(String number, String pass) {
			  
		      String actual;
			 
			 Login.click();
			 
			 mobileNumber.sendKeys(number);
			 
			 Login.click();
			 
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30)); 
			 
			 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'This number is not registered, please register to continue.')]"))));
			 
			 actual=  unRegistered.getText();

		  
		  return actual;
		 
	  }    
	    
	    
	        
    public LoginPage logOut() throws InterruptedException {
    	
    	Thread.sleep(4000);
			  
    	/*JavascriptExecutor js = (JavascriptExecutor) driver;
		  
	     js.executeScript("arguments[0].scrollIntoView", Profile);*/
    	
		 Actions actions = new Actions(driver);
					 
		 //actions.moveToElement(Profile);
					 
		 actions.moveToElement(Profile).click(); 
					 
			  
		Profile.click();
				  
		logout.click();
				  
	    productLogo.click();
			 
			  
			  return new LoginPage(driver);
		  }
    
    public void clickProductLogo() {
	      
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  js.executeScript("arguments[0].scrollIntoView", productLogo);
	      
		  productLogo.click();
   }
  
	 
	 public static boolean isValidMobileNumber(String mobileNumber) {
	        // Regular expression to match a 10-digit Indian mobile number starting with 6, 7, 8, or 9
	        String regex = "^[6-9]\\d{9}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(mobileNumber);
	        return matcher.matches();
	    }
	 
	 public static boolean isAscendingOrder(String mobileNumber) {
	        for (int i = 0; i < mobileNumber.length() - 1; i++) {
	            if (mobileNumber.charAt(i) >= mobileNumber.charAt(i + 1)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static boolean isContinuousSequence(String mobileNumber) {
	        char firstDigit = mobileNumber.charAt(0);
	        for (int i = 1; i < mobileNumber.length(); i++) {
	            if (mobileNumber.charAt(i) != firstDigit) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	    public static boolean isDescendingOrder(String mobileNumber) {
	        for (int i = 0; i < mobileNumber.length() - 1; i++) {
	            if (mobileNumber.charAt(i) <= mobileNumber.charAt(i + 1)) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
  public LoginPage logInWithValidCredentialsFromInterviewQuestions() throws InterruptedException {
		  
		      Thread.sleep(5000);
			
			 //Click on login link
			 loginbutton.click();
			 
			/* //Click on Enter the mobile number and enter the registered mobile number
			 Thread.sleep(1000);
			 mobileNumber.click();
			 mobileNumber.click();
			 mobileNumber.sendKeys("9553259691");
			 
			 //Click on Login for entering the PIN
			 Login.click();
			 Password.sendKeys("1910");
			 
			 //Click on Login
			 Login.click();*/
		return new LoginPage(driver);
		
	  }
	  
	 
}
