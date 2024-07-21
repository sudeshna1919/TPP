package script;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CardsPage;
import pages.Landingpage;
import pages.LoginPage;

public class ConceptCards extends BasePage {
	
	@Test(priority = 0)
	public void startingSession() throws InterruptedException {
		
		Landingpage lP = new Landingpage(driver);
		
		lP.clickLearnDropDown();
		
		lP.openConceptCards();
		
		LoginPage logInTo = new LoginPage(driver);
		
		logInTo.logIn("9553259691", "1919");
		
		CardsPage optionToSelect = new CardsPage(driver);
		
		optionToSelect.clickMore();
		
		optionToSelect.selectModule("Introduction to Product Management");
		
		optionToSelect.selectTopic("Understanding Product Management");
		
		Thread.sleep(5000);
		
		optionToSelect.selectDifficulty("Easy");
		
		optionToSelect.selectMode("Limited cards");
		
		//optionToSelect.selectMode("Timed session");
		
		//optionToSelect.selectCustomDuration();
		
		//optionToSelect.setCustomDurationUsingSlide();
		
		optionToSelect.selectNofCards("12");
		
		optionToSelect.startSession();
		
		optionToSelect.goToNextSlide();
		
		optionToSelect.backToMain();
			
	}

	
}
