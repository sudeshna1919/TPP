package pages;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.checkerframework.checker.units.qual.m;
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

public class LiveProjectPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/liveproject']")
	WebElement lProject;
	
	@FindBy(xpath="//a[@href='/liveproject-application']")
	WebElement application;
	
	@FindBy(xpath="//input[@name='personal-firstName']")
	WebElement fName;
	
	@FindBy(xpath="//input[@name='personal-lastName']")
	WebElement lName;
	
	@FindBy(xpath="//input[@name='personal-emailID']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='personal-mobileNumber']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@name='personal-linkedInUrl']")
	WebElement linkedIn;
	
	@FindBy(xpath="//input[@name='personal-instagram']")
	WebElement insta;
	
	@FindBy(xpath="//input[@type='password']")// four digits have four xpath
	WebElement livePin;
	
	@FindBy(xpath="//img[@alt='right arrow']")
	WebElement checkPin;
	
	@FindBy(xpath="//div[contains(text(),'Next')]")
	WebElement next;
	
	@FindBy(xpath="//input[@name='education-undergraduateStream']")
	WebElement uGraduate;
	
	@FindBy(xpath="//input[@name='education-undergraduateCollege']")
	WebElement uGraduateCollege;
	
	@FindBy(xpath="(//img[@alt='Dropdown Arrow'])[1]") 	//use it for work experience dropdown and availability of live project
	WebElement uGraduateYear;
	
	@FindBy(xpath="(//img[@alt='Dropdown Arrow'])[2]")// use it for year of experience and commitment per day
	WebElement pG;
	
	@FindBy(xpath="//input[@name='education-postGraduateStream']")
	WebElement pGraduate;
	
	@FindBy(xpath="//input[@name='education-postGraduateCollege']")
	WebElement pGraduateCollege;
	
	@FindBy(xpath="(//img[@alt='Dropdown Arrow'])[3]")// use this for experience in product management and stipend range
	WebElement pGraduateYear;
	
	@FindBy(xpath="(//img[@alt='Dropdown Arrow'])[4]")
	WebElement pMCertification;
	
	@FindBy(xpath="//input[@name='experience-role']")
	WebElement roleExperience;
	
	@FindBy(xpath="//input[@name='experience-industry']")
	WebElement industryExperience;
	
	@FindBy(xpath="//input[@name='experience-area']")
	WebElement areaExpertise;
	
	@FindBy(xpath="//input[@accept='.pdf']")
	WebElement resume;
	
	@FindBy(xpath="//input[@name='interests-areaOfInterest']")
	WebElement areaInterest;
	
	@FindBy(xpath="//input[@name='interests-focusIndustry']")
	WebElement findustry;
	
	@FindBy(xpath="//textarea[@name='interests-explanation']")
	WebElement interestExplanation;
	
	@FindBy(xpath="//input[@name='education-certificationName']")
	WebElement certificateName;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy(xpath="//input[@placeholder='Earliest date to start working']")
	WebElement date;
	
	@FindBy(xpath="//button[@aria-label='Next Month']")
	WebElement nextMonth;
	
	@FindBy(xpath="//button[@aria-label='Previous Month']")
	WebElement prevMonth;
	
	
	public LiveProjectPage(WebDriver driver) {
		 
			this.driver = driver;  
		 
			PageFactory.initElements(driver, this); 
	 }
	 
	
	
	public void openLiveProject() {
		
			lProject.click();
	}
	
	
	
	public void openApplication() {
		
			application.click();
	}
	
	
	public void personalDetails(String firstName, String lastName, String mail, String phneNo) {
		
			fName.sendKeys(firstName);
			lName.sendKeys(lastName);
			email.sendKeys(mail);
			mobileNumber.sendKeys(phneNo);
		
	}
	
	
	public void enterPin(String pin) {
	
			livePin.sendKeys(pin);
		//livePin.sendKeys(Keys.TAB);
	}
	
	
	public void verifyPin() {
		
			checkPin.click();
	}
	
	
	public void linkedInUrl(String Url) {
		
			linkedIn.sendKeys(Url);
	}
	
	
	public String  clickNext() {
		
			String alert = null;
		
			next.click();
		
			return alert;
	}
	
	
	public void underGraduateStream(String course) {
		
			uGraduate.sendKeys(course);
	}
	
	
	public void underGraduateCollege(String college) {
		
			uGraduateCollege.sendKeys(college);
	}
	
	
	public void underGraduateYearDropDown() {
		
			uGraduateYear.click();
	}
	
	
	public void underGraduateYear(String year) throws InterruptedException {
		
			Thread.sleep(5000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listYear = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement option : listYear) {
			
				if (option.getText().contains(year)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", option);
					
					option.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	
	public void selectingPostGraduationCompletion() {
			
			pG.click();
	}
	
	
	public void selectingPostGradYN(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	public void postGraduateStream(String course) {
		
			pGraduate.sendKeys(course);
	}
	
	
	public void postGraduateCollege(String college) {
		
			pGraduateCollege.sendKeys(college);
	}
	
	
	public void postGraduateYearDropDown() {
		
			pGraduateYear.click();
	}
	
	
	public void postGraduateYear(String year) throws InterruptedException {
		
			Thread.sleep(5000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listYear = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement option : listYear) {
			
				if (option.getText().contains(year)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", option);
					
					option.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
		
	}
	
	
	public void anyPMCertification() {
		
			pMCertification.click();
	}
	
	
	public void selectingCertificateYN(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
		    	 
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
		        
					optionsYN.click();
		        
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	public void giveCertificateName(String name) {
		
		certificateName.sendKeys(name);
	}
	
	public void experienceDropDown() {
		
		uGraduateYear.click();
	}
	
	public void selectingExpYN(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
		    	
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
		        
					optionsYN.click();
		        
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	

	public void workExperDropDown() {
		
		pG.click();
	
	}
	
	public void selectingworkExpYN(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
		       
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	
	public void priorExpPM() {
		
		pGraduateYear.click();
	}
	
	
	public void selectingPMExpYN(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	

	public void uploadResume(String cV) throws InterruptedException {
		
			resume.sendKeys(cV);
		
			Thread.sleep(6000);
	}
	
	
	public void rolePrevExp(String role) {
		
			roleExperience.sendKeys(role);
	}
	
	
	public void industryPrevExp(String industry) {
		
			industryExperience.sendKeys(industry);
	}
	
	
	public void areaOfExpertise(String exp) {
		
			areaExpertise.sendKeys(exp);
	}
	
	
	public void areaOfInterest(String interest) {
			
			areaInterest.sendKeys(interest);
	}
	
	
	public void focusIndustry(String industry) {
	     	
			findustry.sendKeys(industry);	
	}
	
	
	public void explainInterest(String phara) {
		
			interestExplanation.sendKeys(phara);
	}
	
	
	public void availability() {
			
			uGraduateYear.click();
	}
	
	public void selectingAvailability(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	
	public void commitment() {
		
			pG.click();
	}
	
	public void selectingCommitment(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	
	public void stipendRange() {
			
		pGraduateYear.click();
	}
	
	
	public void selectingStipend(String option) throws InterruptedException {
		
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			List<WebElement> listoptions = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
			for (WebElement optionsYN : listoptions) {
			
				if (optionsYN.getText().contains(option)) {
					
					js.executeScript("arguments[0].scrollIntoView(true)", optionsYN);
					
					optionsYN.click();
					
					break; // Stop iterating once the module is found and clicked
				}
			}
	}
	
	
	public void clickForDate() {
		
			date.click();
	}
	
	
	public void selectdateMonth() {
		
			boolean flag = false;
		
			while(flag == false) {
			
				if(driver.findElements(By.xpath("//div[@aria-label='Choose Wednesday, May 29th, 2024']")).size()>0) {
				
					driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, May 29th, 2024']")).click();
				
					flag = true;
					
					break;
				}
			
				nextMonth.click();
			}
		
	}
	
	
	public void Submit() {
			
			submit.click();
	}
	

}
