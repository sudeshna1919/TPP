package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersForInterviewQuestion {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(), 'Company')]")
	WebElement company;
	
	@FindBy(xpath="//div[contains(text(), 'Role')]")
	WebElement role;
	
	@FindBy(xpath="//div[contains(text(), 'Question Type')]")
	WebElement QuestionType;
	
	@FindBy(xpath="//span[text()='Popular']")
	WebElement Sort;
	
	
	public FiltersForInterviewQuestion(WebDriver driver) {
		 
		this.driver = driver;  
		
		PageFactory.initElements(driver, this); 
	 
	}
	
	public void clickCompany() throws InterruptedException {
		Thread.sleep(6000);
	 company.click();
	}
	
	public void clickQuestionType() throws InterruptedException {
		Thread.sleep(6000);
		 QuestionType.click();
		}
	
	public void clickRole() throws InterruptedException {
		Thread.sleep(6000);
		 role.click();
		}
	
	
	public void selectingfilters(String filterName) throws InterruptedException {
		 
	     Thread.sleep(6000);
	 
	    	     
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
		// Find all company options
		List<WebElement> filterOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='m4-filter-key']")));

		// Extract text from options
		List<String> optionsText = filterOptions.stream()  .map(WebElement::getText) .collect(Collectors.toList());


		// Find and click the desired company option
		for (int i = 0; i < optionsText.size(); i++) {
		    if (optionsText.get(i).equalsIgnoreCase(filterName)) {
		        filterOptions.get(i).click();
		        break; // Exit loop once the company is found and clicked
		    }
		}
		
	 
	 }
	
	public String companyName() throws InterruptedException {
	
		Thread.sleep(3000);
	
		String name= driver.findElement(By.xpath("(//div[@class='m4-company-api-data'])[1]")).getText();
	
		System.out.println(name);
	
		return name;
	}
	
	
	public String questionType() throws InterruptedException {
		
		Thread.sleep(3000);
	
		String name= driver.findElement(By.xpath("(//div[@class='m4-question-tag'])[2]")).getText();
	
		System.out.println(name);
	
		return name;
	}
	

	public String roleType() throws InterruptedException {
		
		Thread.sleep(3000);
	
		String name= driver.findElement(By.xpath("(//div[@class='m4-question-tag'])[1]")).getText();
	
		System.out.println(name);
	
		return name;
	}
	 
}
