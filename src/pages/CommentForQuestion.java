package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommentForQuestion {
	
	WebDriver driver;
	
	@FindBy(xpath="(//span[@class='m4-comment-hide'])[1]")
	WebElement commentBeforeLogin;
	
	@FindBy(css="(//div[@class=\"m4_question_comments_box\"])[1]")
	WebElement commentBoxDisplayed;
	
	@FindBy(xpath="//textarea[@id='comment-text-input']")
	WebElement WriteCommentForQuestion;
	
	@FindBy(xpath="//button[@class='m4-question-post-btn']")
	WebElement PostButtonForQuestion;
	
	@FindBy(xpath="//div[contains(text(),'Your Comment has been Posted!')]")
	WebElement CommentQuestionSuccess;
	
	@FindBy(xpath="//input[@class='comment-input-section-mod-4-user']")
	WebElement WriteCommentForAnswer;
	
	@FindBy(xpath="//button[@class=' comment-post-btn-mod-4']")
	WebElement PostButtonForAnswer;// each answer card post option so how many 
	
	@FindBy(xpath="//div[contains(text(),'Your Comment has been Posted!')]")
	WebElement CommentAnswerSuccess;
	
	@FindBy(xpath="//div[contains(text(),'Comment requires a minimum of 25 characters')]")
	WebElement QuestionAlertLessChar;
	
	@FindBy(xpath="//div[contains(text(),'Comment requires a minimum of 50 characters')]")
	WebElement AnswerAlertLessChar;
	
	@FindBy(xpath="//div[contains(text(),'Maximum character limit for comment is 200')]")
	WebElement QuestionAlertMoreChar;
	
	@FindBy(xpath="//div[contains(text(),'Maximum character limit for comment is 1000')]")
	WebElement AnswerAlertMoreChar;
	
	@FindBy(xpath="//div[@class='navvbar-elements']//div//img[@alt='Avatar Image']")//(//div[@style='cursor: pointer;'])[2]
	WebElement Profile;
	
    @FindBy(xpath = "//span[normalize-space()='Logout']")  
	WebElement logout;
	 
	@FindBy(xpath= "//img[@alt='product-logo']")
	WebElement productLogo;
	
	
	
	 public CommentForQuestion(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public CommentForQuestion clickOnComment() {
		 
		 if (commentBeforeLogin.isDisplayed()) {
		        
			 	commentBeforeLogin.click();
		    
		 } 
		
		 
		 return new CommentForQuestion(driver);
	 }
	 
	 public void writeComment(String comment) {
		 
		 WriteCommentForQuestion.sendKeys(comment);
		 
	 }
	 
	 public void postComment() {
		 
		 PostButtonForQuestion.click();
		 
	 }
	 
	 public String alertValidation(String commentText) throws InterruptedException {
		 
		 Thread.sleep(2000);
		 
		 String alert = null;
		 
		 Thread.sleep(4000);
		 
		 if(commentText != null && commentText.length() >= 25 && commentText.length() <= 200) {
	      
			 alert=CommentQuestionSuccess.getText();
		 }
		 
		 if(commentText ==null || commentText.length() < 25) {
			 
			 alert= QuestionAlertLessChar.getText();
		 }
		 
		 
		 
		 if(commentText .length() > 200) {
			 
			 alert=QuestionAlertMoreChar.getText();
		 }
		 
		 return alert;
	 }
	 
	 public void logoutFromInterview() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  js.executeScript("arguments[0].scrollIntoView", Profile);
		  
		  Profile.click();
		  
		  logout.click();
		  
		  productLogo.click();
	 }

}
