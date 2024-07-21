package script;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Landingpage;
import pages.LoginPage;



public class LandingPageScript extends BasePage {

	@Test(priority = 0)
	public void conceptCardsNavigation() throws InterruptedException {
		
		Landingpage cCards = new Landingpage(driver);
		
		cCards.clickLearnDropDown();
		
		cCards.openConceptCards();

		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9553259691","1910");
		
		String actual = cCards.conceptCardsPage();
		
		String expected = "Choose what you want to learn";
		
		Assert.assertEquals(actual, expected);
		
		logIn.logOut();
		
		System.out.println("1");		
				
	}
	
	@Test(priority = 1)
	public void CardsFromStartLearning() throws InterruptedException {
		
		Landingpage cCards = new Landingpage(driver);
		
		cCards.cardsFromStartLearning();
		
		LoginPage log = new LoginPage(driver);
		
		log.logIn("9553259691","1910");
		
		String actual = cCards.conceptCardsPage();
		
		String expected = "Choose what you want to learn";
		
		Assert.assertEquals(actual, expected);
		
		log.logOut();
		
		System.out.println("2");
		
		
	}
	
	@Test(priority = 2)
	public void sampleQANavigation() {
		
		Landingpage sample = new Landingpage(driver);
		
		sample.clickLearnDropDown();
		
		sample.clickQ_A();
		
		String actual = sample.sampleQAPage();
		
		String expected = "Sample Q&A";
		
		Assert.assertEquals(actual, expected);
		
		sample.productLogoForIQC();
		
		System.out.println("3");
	}
	
	@Test(priority = 3)
    public void qAFromStartLearning() {
		
		Landingpage sample = new Landingpage(driver);
		
		sample.startSampleQ_A();
		
		String actual = sample.sampleQAPage();
		
		String expected = "Sample Q&A";
		
		Assert.assertEquals(actual, expected);
				
		sample.productLogoForIQC();
		
		System.out.println("4");
	}
	
	@Test(priority = 4)
	public void interviewQuestionsNavigation() throws InterruptedException {
		
		Landingpage iQ = new Landingpage(driver);
		
		iQ.clickPracticeDropDown();
		
		String actual= iQ.openingInterviewQuestions();
		
		String expected = "Interview Questions";
		
		Assert.assertEquals(actual, expected);	
		
		iQ.productLogoForIQC();
		
		System.out.println("5");
		
	}
	
	@Test(priority = 5)
	public void interviewFromStartPracticing() throws InterruptedException {
		
		Landingpage iQ = new Landingpage(driver);
		
		String actual = iQ.InterviewQFromStartPracticing();
				
		String expected = "Interview Questions";
		
		Assert.assertEquals(actual, expected);
		
		iQ.productLogoForIQC();	
		
		System.out.println("6");
		
	}
	
	@Test(priority = 6)
	public void cardsFromQA() {
		
		Landingpage sample = new Landingpage(driver);
		
		sample.clickLearnDropDown();
		
		sample.clickQ_A();
		
		sample.clickLearnDropDown();
		
		sample.openConceptCards();
		
		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9553259691","1910");
		
		String actual = sample.conceptCardsPage();
		
		String expected = "Choose what you want to learn";
		
		Assert.assertEquals(actual, expected);
		
		System.out.println("7");
			
	}
	
	
	
	
}
