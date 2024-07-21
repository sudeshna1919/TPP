package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//img[@alt=\"three dot\"])[1]")
	WebElement threedots;
	
	@FindBy(xpath="(//img[@alt='edit'])[1]")
	WebElement edit;
	
	@FindBy(css="[class=\"_modal_button_skip_17z51_63\"]")
	WebElement skip;
	
	@FindBy(css="[class='_modal_button_add_19srs_153']")
	WebElement settingGoal;
	
	@FindBy(xpath="(//img[@alt='arrow right'])[1]")
	WebElement next;
	
	@FindBy(xpath="(//img[@alt='arrow left'])[1]")
	WebElement previous;
	
	
	
	public Homepage(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	
	public void selectingModuleFromLearn(String moduleName) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0, 500)");
		
		int i =0;
		
		List<WebElement>  modules= driver.findElements(By.xpath("//span[@class='_common_text_6vc0f_405 _card_heading_text_6vc0f_537']"));
		
		for(WebElement modeLevel : modules) {
			i++;
			System.out.println(i + modeLevel.getText() );	
			if(modeLevel.getText().equals(moduleName)) {
				WebElement clickExplore = driver.findElement(By.xpath("(//button[@class='_card_cta_6vc0f_347 _common_text_6vc0f_405 _cta_text_6vc0f_549'])["+i+"]"));
				js.executeScript("arguments[0].scrollIntoView();", modeLevel);
				System.out.println(modeLevel);
				clickExplore.click();
				break;
			}
		}
		
	}
	

	
	public void goalList() {
		List<WebElement>  listBeforeGoalsEdit1= driver.findElements(By.xpath("//div[@class='_each_activity_1h5y2_57']"));
		List<WebElement> listBeforeGoalsEdit = new ArrayList<WebElement>();
		listBeforeGoalsEdit.addAll(listBeforeGoalsEdit1);
		
		for (WebElement element : listBeforeGoalsEdit) {
            
			System.out.println("3."+element.getText());
        }
		

		List<WebElement>  listBeforeGoalsEdit2 = null;
		if (next.isDisplayed()) {
			
			next.click();
			
			listBeforeGoalsEdit2=driver.findElements(By.xpath("//div[@class='_each_activity_1h5y2_57']"));
			listBeforeGoalsEdit.addAll(listBeforeGoalsEdit2);
			
			
		}
		
		
		for (WebElement element : listBeforeGoalsEdit) {
            
			System.out.println("3."+element.getText());
        }
		
		
		
	}
	public void clickForEditGoal() throws InterruptedException {
		
		Thread.sleep(6000);
		
		edit.click();	
	}
	
	public void clickGoalLevel(String name) {
		
		WebElement level = driver.findElement(By.xpath("//button[contains(text(),'"+name+"')]"));
		
		level.click();
	}
	
	public void checkGoals(String goal) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0, 250)");
		
		WebElement checkGoals = driver.findElement(By.id(goal));
		
		checkGoals.click();
		
	}
	
	public void typeNumberOfGoals(String textbox , String num) throws InterruptedException {
		
		Thread.sleep(6000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0, 250)");
		
		WebElement noGoals = driver.findElement(By.id(textbox));
		
		noGoals.click();
		
		noGoals.sendKeys(num);
	}
	
	public void skipGoal() {
		skip.click();
	}
	
	public void goalSet() {
		settingGoal.click();
	}
}
