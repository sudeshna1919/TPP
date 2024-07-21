package script;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Landingpage;
import pages.LoginPage;

public class LoginTest extends BasePage {

	@Test(priority = 0)
	public void logInWithValidCredentials() throws InterruptedException  {
		
		Landingpage landing=new Landingpage(driver);
		
		landing.openingLoginPage();
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.LogInValidation("9553259691", "1919");
		
		String actual="43 learners started started learning from case study";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with Valid Credentials");
	
		ValidCredentials.logOut();

	}
	
	@Test(priority = 1)
	public void logInWithInValidPin()  {
		
		Landingpage landing=new Landingpage(driver);
		
		landing.openingLoginPage();
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.LogInValidation("9553259691", "1910");
		
		String actual="Incorrect Pin";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with InValid pin");
		
		driver.navigate().refresh();

	}
	
	@Test(priority = 2)
	public void logInWithInValidNumber()  {
		
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.LogInValidation("9876543210", "1919");
		
		String actual="Invalid number";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with InValid number");
		
		driver.navigate().refresh();
		

	}
	
	@Test(priority = 3)
	public void logInWithSequnceNumber()  {
		
	
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.LogInValidation("2222222222", "1919");
		
		String actual="Invalid number";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with sequnce number");
		
		driver.navigate().refresh();
		

	}
	
	@Test(priority = 4)
	public void logInWithAscendingNumber()  {
		
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.LogInValidation("0123456789", "1919");
		
		String actual="Invalid number";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with Ascending number");
		
		driver.navigate().refresh();
		

	}
	
	@Test(priority = 5)
	public void logInWithUnRegisterdNumber()  {
		
	
		
		LoginPage ValidCredentials = new LoginPage(driver);
		
		String Expected = ValidCredentials.logInWithUnregistered("9703533184", "1919");
		
		String actual="This number is not registered, please register to continue.";
		
		Assert.assertEquals(actual, Expected);
		
		System.out.println(" Asserted Login with Unregistered Number");
		
		driver.navigate().refresh();
		

	}
	
	
	
	
	
}
