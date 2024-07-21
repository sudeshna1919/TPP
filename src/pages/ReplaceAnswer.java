package pages;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.*;
import pages.LoginPage;

public class ReplaceAnswer {
	
     WebDriver driver;
	
	//finding the elements from the webpage
	
	 @FindBy(xpath="//div[@class='ql-editor ql-blank']")
	 WebElement WriteAnswer;
	
	 @FindBy(xpath="//button[contains(text(), 'Submit Answer')]")
	 WebElement SubmitAnswer;
	
	 
	 @FindBy(xpath="//div[@class='ql-editor ql-blank']")
	 WebElement writeAnswer;
	 
	 @FindBy(xpath="//button[text()='Continue Answering']")
	 WebElement ContiuneAnswering;
	 
	 @FindBy(xpath="//button[@class='static-screen-register-btn']")
	 WebElement replaceButton;
	 
	 @FindBy(xpath="//span[normalize-space()='Keep your submitted Answer']")
	 WebElement keepSubmitted;
	 
	 @FindBy(xpath="//*[@role='alert']/div[contains(text(),'Your Answer has been Posted!')]")
	 WebElement submitAlert;
	 
	 //xpath to get user name from answer card=//div[@class='answer-card-username']
	 
	 public ReplaceAnswer(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public ReplaceAnswer writingAnswerBeforeLogin() {
		 
		 writeAnswer.sendKeys("This answer is editing for testing automation code and then will be replaced again for same answer for the same user i think this should be more than 200 characters This answer is editing for testing automation code and then will be replaced again for same answer for the same user i think this should be more than 200 characters");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			
	     js.executeScript("window.scrollTo(0, 10);");
	     
	     SubmitAnswer.click();
	     
		 
		 return new ReplaceAnswer(driver);
	 }
	 
	 public String popUpForReplace() throws InterruptedException {
		 
		 
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			
	     js.executeScript("window.scrollTo(0, 40);");
	     
	     ContiuneAnswering.click();
		 
		 SubmitAnswer.click();
		 
		 replaceButton.click();
		 
		// System.out.println("existing answer is "+existingAnswer);
		 
		 Thread.sleep(4000);
		 String alert= submitAlert.getText();
		 
		 return alert;
		 
	 }
	 
/*	 public String ReplacedAnswer() throws InterruptedException {
		 
		 Thread.sleep(10000);
		 
		 String replacedAnswer= driver.findElement(By.xpath("//div[@class='answer-card-text truncate-text']")).getText();
		 
		 System.out.println("replaced Answer" +replacedAnswer);
		 
		 return replacedAnswer;
	 }*/
		
	 public ReplaceAnswer KeepSubmittedAnswer() {
		 
		 keepSubmitted.click();
		 
		 return new ReplaceAnswer(driver);
	 }


}
