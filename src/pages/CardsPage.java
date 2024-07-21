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

public class CardsPage {
		
		WebDriver driver;
		
		@FindBy(xpath="//p[@class='button-more']")
		WebElement more;
		
		@FindBy(xpath="//p[@class='clear-filter']")
		WebElement clear;
		
		@FindBy(xpath="//button[@class='category-btn']")
		WebElement start;
		
		@FindBy(css="[class=\"right_navigate\"]")
		WebElement nextSlide;
		
		@FindBy(xpath="(//div[@class='_swiper_main_body_un0d1_1']//*[name()='svg'])[1]")
		WebElement previousSlide;
		
		@FindBy(xpath="//button[@class='category-btn']")
		WebElement reset;
		
		@FindBy(xpath="//div[@class='_exit_btn_z0ul1_63']//*[name()='svg']")
		WebElement exit;
		
		@FindBy(xpath="//button[@class='_endsession_btn_z0ul1_217']")
		WebElement confirmExit;
		
		@FindBy(xpath="//button[@class='_close_btn_z0ul1_198']")
		WebElement cancelExit;
		
		@FindBy(xpath="//div[@class='_final_card_btn_left_un0d1_106']")
		WebElement returnMain;
		
		@FindBy(xpath="//div[@class='_final_card_btn_right_un0d1_107']")
		WebElement addMoremins; //same for more cards also
		
		@FindBy(xpath="//h3[normalize-space()='Session Duration']")
		WebElement customDuration;
		
		@FindBy(xpath="//input[@type='range']")
		WebElement slider;
		
		@FindBy(xpath="//input[@type='number']")
		WebElement rangeInText;
		
		@FindBy(css="[class=\"right_navigate swiper-button-disabled\"]")
		WebElement nextDisabled;
		
		
		

		public CardsPage(WebDriver driver) {
			 
			 this.driver = driver;  
			 
			 PageFactory.initElements(driver, this); 
		 }
		
		public void clickMore() {
			
			more.click();
			
		}
		
		public void selectModule(String moduleName) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

			List<WebElement> modules = driver.findElements(By.xpath("//section[1]//ul[1]//li"));

			wait.until(ExpectedConditions.visibilityOfAllElements(modules));

			for (WebElement module : modules) {
			    if (module.getText().contains(moduleName)) {
			        js.executeScript("arguments[0].click();", module);
			        break; // Stop iterating once the module is found and clicked
			    }
			}
		}
		
		public void selectTopic(String topicName) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");

			List<WebElement> topics = driver.findElements(By.xpath("//section[2]/ul/li"));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(topics));

			for (WebElement topic : topics) {
			    if (topic.getText().equals(topicName)) {
			        topic.click();
			        break; 
			    }
			}
		}
		
		public void selectDifficulty(String difficulty) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");
			
			WebElement diff =driver.findElement(By.xpath("//li[contains(text(),'"+difficulty+"')]"));	
			
			List<WebElement> difficulties = driver.findElements(By.xpath("//section[3]//ul[1]//li"));
				
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			for(WebElement level : difficulties) {
				
				if(level.getText().equals(difficulty)) {
					wait.until(ExpectedConditions.textToBePresentInElement(diff,difficulty));
					level.click();
				}
			}
			
		}
		
		public void selectMode(String mode) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			List<WebElement> modes = driver.findElements(By.xpath("//section[4]//ul[1]//li"));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(modes));
			
			for(WebElement modeLevel : modes) {
				if(modeLevel.getText().equals(mode)) {
					modeLevel.click();
				}
			}
			
		}
		
		public void selectNofCards(String num) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement option = driver.findElement(By.xpath("//section[5]//ul/li[1]"));
			
			option.click();
			
	        /*List<WebElement> limitedOptions = driver.findElements(By.xpath("//section[5]//ul[1]//li"));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(limitedOptions));
			
			for(WebElement limit : limitedOptions) {
				if(limit.getText().contains(num)) {
					limit.click();
				}
			}*/
		}
		
		public void selectTime(String min) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			List<WebElement> timeOptions = driver.findElements(By.xpath("//section[5]//ul[1]//li"));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(timeOptions));
			
			
			for(WebElement mins : timeOptions) {
				if(mins.getText().contains(min)) {
					mins.click();
				}
			}	
		}
		
		public void selectCustomDuration() {
			
			customDuration.click();
		}
		
		public void setCustomDurationUsingSlide() {
			
			Actions actions = new Actions(driver);
	        actions.clickAndHold(slider).moveByOffset(100, 0).perform(); 
		}
		
		public void setCustomDurationUsingText(String range) {
			
			rangeInText.sendKeys(range);
		}
		
		public void clearFilters() {
			clear.click();	
		}
		
		public void startSession() {
			start.click();
		}
		
		public void goToNextSlide() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 250)");
				
			// Set a variable to keep track of the condition
	        boolean conditionMet = false;

	        String next = driver.findElement(By.cssSelector("[aria-label=\"Next slide\"]")).getAttribute("class");
	        
	        // Loop to keep clicking on the "Next" option until the condition is met
	        while (!next.contains("disabled")) {
	 
	            nextSlide.click();
	            
	            next = driver.findElement(By.cssSelector("[aria-label=\"Next slide\"]")).getAttribute("class");
	           //div[@class='swiper_body']
	            }
	        nextDisabled.click();
	}
		public void goToPreviousSlide() {
			
			previousSlide.click();
		}
		
		public void clickExit() {
			exit.click();
		}
		
		public void processReset() {
			
			reset.click();
		}
		
		public void backToMain() {
			
			returnMain.click();
		}
		
		public void addMoreTime() {
			
			addMoremins.click();
		}
		
		public void addMoreCards() {
			
			addMoremins.click();
		}
		
		
		
	}




