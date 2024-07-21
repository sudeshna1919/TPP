package pages;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
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


public class Landingpage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@class='signup-btn start-btn ']")
	 WebElement register;
	
	@FindBy(xpath="//p[normalize-space()='Learn']")
	WebElement learnDropDown;
	
	@FindBy(xpath="//p[normalize-space()='Practice']")
	WebElement PracticeDropDown;
	
	@FindBy(xpath="//a[@href='/liveproject']")
	WebElement liveProject;
	
	@FindBy(xpath="(//a[@href='/question-page'])[2]")
	WebElement sampleQ_A;
	
	@FindBy(xpath="//button[@class='start-btn card-img-btn flash-img-btn']")
	WebElement StartLearning;
	
	@FindBy(xpath="//button[@class='start-btn card-img-btn flash-img-btn interview-card-img-btn mod-4-testing']")
	WebElement StartPracticing;
	
	@FindBy(xpath="(//img[@alt='PracticeInterviewBox'])[6]")
	WebElement PracticeQuestions;
	
	@FindBy(xpath="//button[@class='start-btn quiz-img-btn flash-img-btn']")
	WebElement startLearnQ_A;
	
	@FindBy(xpath="//button[@class='start-btn card-img-btn flash-img-btn']")
	WebElement startLearnCards;
	
	@FindBy(xpath="(//h5[normalize-space()='Concept Cards'])[2]")
	WebElement conceptCards;
	
	@FindBy(xpath="(//h5[normalize-space()='Sample Q&A'])[2]")
	WebElement q_A;
	
	@FindBy(xpath="//button[@class='start-btn card-img-btn flash-img-btn practice-card-img-btn ']")
	WebElement startReading;
	
	@FindBy(xpath="//button[@class='start-btn card-img-btn flash-img-btn interview-card-img-btn mod-4-testing']")
	WebElement startPracticing;
	
	@FindBy(xpath="(//h5[normalize-space()='Interview Questions'])[2]")
	WebElement InterviewQuestions;
	
	@FindBy(xpath="//h5[normalize-space()='Case study Repo']")
	WebElement caseRepo;
	
	@FindBy(xpath="(//img[@alt='RegisterBtnArrow'])[2]")
	WebElement registerToStart;
	
	@FindBy(xpath="//button[@class='start-btn desktop-testimonial-start-btn']")
	WebElement GetStartedForFree;
	
	@FindBy(xpath="//button[@class='register-btn start-btn']")
	WebElement GetStartedForFreeBottom;
	
	@FindBy(xpath="//h2[normalize-space()='Choose what you want to learn']")
	WebElement conceptCardsHeading;
	
	@FindBy(xpath="//h1[normalize-space()='Sample Q&A']")
	WebElement sampleHeading;
	
	@FindBy(xpath="//h1[normalize-space()='Create Your Account']")
	WebElement registrationHeading;
	
	@FindBy(xpath="//h1[normalize-space()='Welcome Back!']")
	WebElement loginHeading;
	
	@FindBy(xpath="//img[@alt='back_icon']")
	WebElement back;
	
	@FindBy(xpath= "//img[@alt='TPP Logo']")
	WebElement productLogo;
	
	@FindBy(xpath="//img[@alt='product-logo']")
	WebElement logo; //use this xpath from interview questions, sample Q_A, casestudyrepo
	

	 public Landingpage(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public Landingpage openingLoginPage() {
		 
		 register.click();
		 
		 return new Landingpage(driver);
	 }
	 
	 public void clickLearnDropDown() {
		 
		 Actions actions = new Actions(driver);
		 
		 actions.moveToElement(learnDropDown);
		 
		 learnDropDown.click();
		 
	 }
	 
	 public void  openConceptCards() {
		
		 conceptCards.click();	 
	 }
	 
	 public String conceptCardsPage() {

		 String heading = conceptCardsHeading.getText();
		 
		 return heading;
	 }
	 
	 public void clickQ_A() {
		 
		 q_A.click();
	 }
	 
	 public String sampleQAPage() {

		 String heading = sampleHeading.getText();
		 
		 return heading;
	 }
	 
	
	 public void clickPracticeDropDown() {
		 
		 Actions actions = new Actions(driver);
		 
		 actions.moveToElement(PracticeDropDown);
		 
		 PracticeDropDown.click(); 
		 
	 }
	  
	 public String openingInterviewQuestions() throws InterruptedException{
		 
		 InterviewQuestions.click();
		 
		 String alert = driver.findElement(By.xpath("(//h1[@class='m4-header-heading'])[1]")).getText();

		 return alert;
	 }
	
	 
	 public void openingCaseRepo() {
		 
		 caseRepo.click();
	 
	 }
	 
	 public void startSampleQ_A() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView", startLearnQ_A);
		 
		 startLearnQ_A.click();
		 
	 }
	 
	 public void cardsFromStartLearning() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView", startLearnCards);
		 
		 startLearnCards.click();
		 
	 }
	 
	 public void caseRepoFromDropDown() {
		 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 
			 js.executeScript("arguments[0].scrollIntoView", startReading);
			 
			 startReading.click();
			 
	 }
	 
	 public String InterviewQFromStartPracticing() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView", startPracticing);
		 
		 startPracticing.click();
		 
		 String alert = driver.findElement(By.xpath("(//h1[@class='m4-header-heading'])[1]")).getText();

		 return alert;
		 
 }
	 
	 public void ProductLogo() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView", productLogo);
		 
		 productLogo.click();
	 }
	 
	 public void productLogoForIQC() {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].scrollIntoView", logo);
		 
		 logo.click();
		 
	 }
	 
	 public void clickBack() {
		 back.click();
	 }
	 
	 
	 
 }
	 
	 
	 
	

