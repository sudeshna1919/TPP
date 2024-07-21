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

public class PracticeQuestions {
	
	WebDriver driver;
	
	//finding the elements from the webpage
	
	@FindBy(xpath="(//img[@alt='PracticeInterviewBox'])[7]")
	WebElement PracticeQuestions;
	
	@FindBy(xpath="(//img[@alt='RegisterBtnArrow'])[2]")
	WebElement registerToStart;
	
	@FindBy(xpath="//span[text()='Industry']")
	WebElement industry;
	
	@FindBy(xpath="//span[text()='Question Type']")
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
	
	 @FindBy(xpath = "//input[@type='number']")  
	 WebElement mobileNumber;
	 
	 @FindBy(xpath= "//input[@type='password']")
	 WebElement Password;
	 
	 @FindBy(xpath= "//button[@type='submit']")
	 WebElement Login;
	 
	 @FindBy(xpath="//button[text()='Continue Answering']")
	 WebElement ContiuneAnswering;
	 
	 @FindBy(xpath="//*[@role='alert']/div[contains(text(),'Your Answer has been Posted!')]")
	 WebElement submitAlert;
	 
	 @FindBy(xpath="(//div[@style='cursor: pointer;'])[2]")
	 WebElement Profile;
	 
	 @FindBy(xpath = "//span[normalize-space()='Logout']")  
	 WebElement logout;
	 
	 @FindBy(xpath=" //img[@alt='product-logo']")
	 WebElement logo;
	 	 
	public PracticeQuestions(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	public PracticeQuestions  selectingPracticeQuestions(int id) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		//Clicking on industry dropdown and selecting a company name
		industry.click();
		Thread.sleep(1000);
		
		
		List<WebElement> industryOptions=driver.findElements(By.xpath("//p[@class='filter-key']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(industryOptions));

		String[] options=new String[industryOptions.size()];
		for(int i=0; i<industryOptions.size();i++) {
			options[i]=industryOptions.get(i).getText();
			System.out.println(options[i]);
		}
		
		String selectingIndustry="Healthcare";
		for(int i=0 ; i<options.length; i++) {
			if(selectingIndustry.contains(options[i])) {
				industryOptions.get(i).click();
			}
		}
		//clicking on Question type and selecting a Question type;
		QuestionType.click();
		
		List<WebElement> questionOptions=driver.findElements(By.xpath("//p[@class='filter-key']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(questionOptions));

		String[] questionOption = new String[questionOptions.size()];
		for(int j=0; j<questionOptions.size(); j++) {
			questionOption[j]=questionOptions.get(j).getText();
		}
		
		String selectQuestionType="Estimates";
		for(int j=0; j<questionOption.length; j++) {
			if(selectQuestionType.contains(questionOption[j])) {
				questionOptions.get(j).click();
				
			}
		}
		
		//thread sleep for sort functionality this is a performance issue
		//Thread.sleep(20000);
		//clicking on sort drop down and selecting sort option
		
		wait.until(ExpectedConditions.visibilityOf(Sort));
		wait.until(ExpectedConditions.elementToBeClickable(Sort));
		Sort.click();
		Thread.sleep(1000);
		List<WebElement> sortOptions = driver.findElements(By.xpath("//div[@class='sort-data']"));
		String[] sortOption = new String[sortOptions.size()];
		for(int i=0 ; i<sortOptions.size(); i++) {
			sortOption[i]=sortOptions.get(i).getText();
			System.out.println(sortOption[i]);
		}
		Thread.sleep(1000);
		
		String selectSort="Oldest";
		for(int i=0; i<sortOption.length;i++) {
			if(selectSort.contains(sortOption[i])) {
				System.out.println(selectSort +"="+sortOption[i]);
				sortOptions.get(i).click();
		}
		
		}
		List<WebElement> selectQuestion=driver.findElements(By.cssSelector("[class='question-div'] [class='question-content']"));
		String[] questions = new String[selectQuestion.size()];
		for(int i=0;i<selectQuestion.size();i++) {
			questions[i]=selectQuestion.get(i).getText();
			//System.out.println(questions[i]);
		}
		WebElement SelectQuestion = driver.findElement(By.xpath("//a[@href='/answer-page?questionId="+id+"']"));
		//scrolling into view the desired Question
		js.executeScript("arguments[0].scrollIntoView(true)", SelectQuestion);
		SelectQuestion.click();
		

		return new PracticeQuestions(driver);
		
  }
	
	
	public PracticeQuestions WriteAnswer() {
		
		WriteAnswer.sendKeys("Estimate Facebook’s ad revenue. Show your "
				+ "work in your own notebook. Make any assumptions as necessary. Answer on the next page"
				+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
				+ "Make any assumptions as necessary. Answer on the next page"
				+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
				+ "Make any assumptions as necessary. Answer on the next page");
		
		
		return  new PracticeQuestions(driver); 
	}
	
	public String SaveAnswer() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView", saveAnswer);
		saveAnswer.click();

		Thread.sleep(1000);
		
		
		String actualAlert=SaveAlert.getText();
		
		
		
		return actualAlert;
	}
	
	public String  submitAnswer() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView", SubmitAnswer);
		SubmitAnswer.click();
		
		String register1="Register for Free!";
		String Warning = Register.getText();
		Assert.assertEquals(register1, Warning);
		
		Register.click();
		
		mobileNumber.click();
		mobileNumber.click();
	    mobileNumber.sendKeys("9553259691");
		 
		//Click on Login for entering the PIN
		Login.click();
		Password.sendKeys("1919");
		 
		//Click on Login
		Login.click();
		
		
		js.executeScript("arguments[0].scrollIntoView", ContiuneAnswering);
		ContiuneAnswering.click();
		
		SubmitAnswer.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(submitAlert));
		String actualSucessfulAlert = submitAlert.getText();
		
		
		driver.navigate().refresh();
		
		js.executeScript("arguments[0].scrollIntoView(true)", Profile);
		Profile.click();
		logout.click();
		logo.click();
		
		return actualSucessfulAlert;
	}
	public PracticeQuestions writeComments() {
		
		return new PracticeQuestions(driver);
	}
	
	
}
