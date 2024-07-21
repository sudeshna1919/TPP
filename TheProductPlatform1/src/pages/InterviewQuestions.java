package pages;

import java.time.temporal.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InterviewQuestions {
	
	WebDriver driver;
	
	@FindBy(xpath="//p[normalize-space()='Practice']")
	WebElement practiceDropDown;
	
	@FindBy(xpath="//div[contains(text(), 'Company')]")
	WebElement company;
	
	@FindBy(xpath="//div[contains(text(), 'Role')]")
	WebElement role;
	
	@FindBy(xpath="//div[contains(text(), 'Question Type')]")
	WebElement QuestionType;
	
	@FindBy(xpath="//span[text()='Popular']")
	WebElement Sort;
	
	@FindBy(xpath="//div[@class='ql-editor ql-blank']")
	WebElement WriteAnswer;
	
	@FindBy(xpath="//button[contains(text(), 'Submit Answer')]")
	WebElement SubmitAnswer;
	
	@FindBy(xpath="//button[contains(text(), 'Save')]")
	WebElement saveAnswer;
	
	@FindBy(xpath="//div[contains(text(),'Answer saved!')]")
	WebElement SaveAlert;
	
	@FindBy(xpath="//h3[text()='Register to Submit your answer!']")
	WebElement RegisterText;
	
	 @FindBy(xpath="//button[@class='static-screen-register-btn']")
	 WebElement Register;
	 
	 @FindBy(xpath="//button[text()='Continue Answering']")
	 WebElement ContiuneAnswering;
	 
	 @FindBy(xpath="//*[@role='alert']/div[contains(text(),'Your Answer has been Posted!')]")
	 WebElement submitAlert;
	 
	 @FindBy(xpath="//div[contains(text(),'Answer requires a minimum of 200 characters')] ")
	 WebElement AnswerAlertForLessChar;
	 
	 @FindBy(xpath="//div[contains(text(), 'Answer requires a minimum of 200 characters') or contains(text(), 'Your Answer has been Posted!')]")
	 WebElement AlertForAnswerSubmission;
	 
	 @FindBy(xpath="//div[@class='user-edit-txt']")
	 WebElement editAnswer;
	 
	 @FindBy(xpath="//div[@class=\"ql-editor\"]")
	 WebElement WriteAnswerForEdit;
	 
	 @FindBy(xpath="//div[@class='delete-user-ans-mod-4']")
	 WebElement deleteAnswer;
	 
	 @FindBy(xpath="//button[@class='delete-ans-btn']")
	 WebElement confirmDelete;
	 
	 @FindBy(xpath="//button[@class='cancel-ans-btn']")
	 WebElement canceDelete;
	 
	 @FindBy(xpath="//div[contains(text(),'Your Answer has been deleted!')]")
	 WebElement deleteAlert;
	 
	 @FindBy(xpath="(//div[@style='cursor: pointer;'])[2]")
	 WebElement Profile;
	 
	 @FindBy(css="[class='Toastify__close-button Toastify__close-button--light']")
	 WebElement closeAlert;
	 
	 @FindBy(xpath="//img[@class='arr-back']")
	 WebElement backToQuestions;
	 
	 @FindBy(xpath="//img[@alt='close_img']")
	 WebElement popUpClose;
	 
	 @FindBy(xpath="//h1[@class='common_text congratulations_popup_text']")
	 WebElement congrats;
	 
	 
	 public InterviewQuestions(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	 	 
	  
/*	 public InterviewQuestions  selectingInterviewQuestions(int id) throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='/interview-answer-page?questionId="+id+"']")));
			
			WebElement SelectQuestion = driver.findElement(By.xpath("//a[@href='/interview-answer-page?questionId="+id+"']"));
			
			js.executeScript("arguments[0].scrollIntoView(true)", SelectQuestion);
			
			String parent=driver.getWindowHandle();

			Thread.sleep(6000);
			
	        SelectQuestion.click();
	        
	       String child =driver.getWindowHandle();
	        
	        driver.switchTo().window(parent);
			
			return new InterviewQuestions(driver);
	 }*/
	
	 
	 public InterviewQuestions writeAnswer(String Answer) {
			
			WriteAnswer.sendKeys(Answer);
			
			return  new InterviewQuestions(driver); 
		}
		
	 public String SaveAnswer() throws InterruptedException {
			
			saveAnswer.click();
			
			Thread.sleep(1000);
			
			String actualAlert=SaveAlert.getText();
			
			return actualAlert;
		}
		
		public String submitAnswerBeforeLogin() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollTo(0, 5);");
			
			//js.executeScript("arguments[0].scrollIntoView(true)", SubmitAnswer);
			
			SubmitAnswer.click();
			
			String alert = Register.getText();
			
			return alert;
			
		}
		
		public void ContiuneAnswer() throws InterruptedException {
			
			Thread.sleep(5000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollTo(0, 10);");
			
			//js.executeScript("arguments[0].scrollIntoView(true)", ContiuneAnswering);
			
			ContiuneAnswering.click();
		}
		
		public String submitAnswerAfterLogin() throws InterruptedException {
				
			SubmitAnswer.click();
			
			Thread.sleep(4000);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			
			wait.until(ExpectedConditions.visibilityOf(congrats));
			
			String actualSucessfulAlert = congrats.getText();
			
			//driver.navigate().refresh();
				
			return actualSucessfulAlert;
		}
		
		public void editAnswer() {
			
			//WebElement userAnswer = driver.findElement(By.xpath("//div[contains(text(),'"+userName+"')]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].scrollIntoView(true)", editAnswer);
			
			editAnswer.click();
			
		}
		
		
		public void clearAnswer() {
			
			WriteAnswerForEdit.clear();		
		}
		
		
		public void writingAnsweringForEdit(String answer) {
		
			writeAnswer(answer);
				
		}
		
		
		public String submitAnswerAfterEditing() throws InterruptedException {
            
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
            js.executeScript("window.scrollTo(0, 5);");
            
			//js.executeScript("arguments[0].scrollIntoView(true)", SubmitAnswer);
            
            SubmitAnswer.click();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			
			wait.until(ExpectedConditions.visibilityOf(AlertForAnswerSubmission));
			
			String actualSucessfulAlert = AlertForAnswerSubmission.getText();
			
			System.out.println(actualSucessfulAlert);
			
			
			return actualSucessfulAlert;
			
			
		}
		
		public void deleteUserAnswer() {
			
            deleteAnswer.click();
            
		}
		
		public String ConfirmDelete() throws InterruptedException {
			
			confirmDelete.click();
			
			Thread.sleep(4000);
			
			String alert = deleteAlert.getText();
			
			return alert;
		}
		
		
		public void CancelDelete() {
			
			canceDelete.click();
		}
		
		
		public void profileOpening() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
            
			js.executeScript("arguments[0].scrollIntoView(true)", Profile);
			
			Thread.sleep(6000);
			
			Profile.click();
			
		}

		public void alertClosing() {
			
			closeAlert.click();
		}
		
		public InterviewQuestions paginationForQuestion(int id) throws InterruptedException {
		    
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    boolean questionFound = false;

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		    WebElement nextPageButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Next page']")));
		    
		    String parent=driver.getWindowHandle();
		    

		    while (!questionFound) {
		       
		        List<WebElement> questionLinks = driver.findElements(By.xpath("//a[contains(@href, '?questionId=')]"));
		        
		        for (WebElement questionLink : questionLinks) {
		            
		            String href = questionLink.getAttribute("href");
		            

		            if (href.contains("?questionId=" + id)) {
		            	
		                js.executeScript("arguments[0].scrollIntoView(true)", questionLink);

		                questionLink.click();
		                
		                questionFound = true;
		                
		                break; 
		            }
		        }

		        if (!questionFound) {

		            js.executeScript("arguments[0].scrollIntoView(true)", nextPageButton);
		            
		            nextPageButton.click();
		        }
		    }
		    
		    Set<String> child=driver.getWindowHandles();
            
            Iterator<String> I1= child.iterator();
            
            while(I1.hasNext())
            {

            	String child_window=I1.next();

            	if(!parent.equals(child_window)) {
            
            		driver.switchTo().window(parent).close();
                
            		driver.switchTo().window(child_window);
           
            	}
            
            }

		    return new InterviewQuestions(driver);
		}
		
		
		public void backToQuestionPage() {
			
			backToQuestions.click();
		
		}
		
		public void closeCongrats() {
			
			popUpClose.click();
		}

		
		
}