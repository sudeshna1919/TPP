package script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Landingpage;
import pages.LiveProjectPage;
import pages.LoginPage;

public class LiveProjectScript extends BasePage{
	
	@Test(priority = 0)
	public void validDetails() throws InterruptedException {
		
		LiveProjectPage appLP = new LiveProjectPage(driver);
		
		appLP.openLiveProject();
		
		appLP.openApplication();
		
		appLP.personalDetails("sudeshna", "shetty", "sudeshnashetty2211@gmail.com", "9133690791");
		
		appLP.enterPin("1919");
		
		appLP.verifyPin();
		
		appLP.linkedInUrl("www.linkedin.com/in/setti-gari-sudeshna-59b930264");
		
		appLP.clickNext();
		
		appLP.underGraduateStream("computer Science");
		
		appLP.underGraduateCollege("osmania uneriversity");
		
		appLP.underGraduateYearDropDown();
		
		appLP.underGraduateYear("2016");
		
		appLP.selectingPostGraduationCompletion();
		
		appLP.selectingPostGradYN("Yes");
		
		appLP.postGraduateStream("Computer Science");
		
		appLP.postGraduateCollege("osmania univeristy");
		
		appLP.postGraduateYearDropDown();
		
		appLP.postGraduateYear("2018");
		
		appLP.anyPMCertification();
		
		appLP.selectingCertificateYN("No");
		
		appLP.clickNext();
	
		appLP.experienceDropDown();
		
		appLP.selectingExpYN("Yes");
		
		appLP.workExperDropDown();
		
		appLP.selectingworkExpYN("Between 2 to 3 years");
		
		appLP.rolePrevExp("PM");
		
		appLP.industryPrevExp("Food");
		
		appLP.areaOfExpertise("Sales");
		
		appLP.priorExpPM();
		
		appLP.selectingPMExpYN("Yes");
		
		appLP.uploadResume("C:\\Users\\Dell\\Downloads\\ProblemStatement (24).pdf");
		
		appLP.clickNext();
		
		appLP.areaOfInterest("IT");
		
		appLP.focusIndustry("sales");
		
		appLP.explainInterest("\r\n"
				+ "The concept of working on live projects, particularly in fields like software development or data science, holds several benefits:\r\n"
				+ "\r\n"
				+ "Real-world Application: Live projects provide an opportunity to apply theoretical knowledge to real-world scenarios. This practical experience helps individuals understand how concepts are implemented in actual projects and prepares them for challenges they might encounter in their professional careers.\r\n"
				+ "\r\n"
				+ "Hands-on Experience: Working on live projects allows individuals to gain hands-on experience with tools, technologies, and methodologies commonly used in their field. This practical exposure helps in developing proficiency and confidence.");
		
		appLP.clickNext();
		
		appLP.availability();
		
		appLP.selectingAvailability("3-4 months");
		
		appLP.commitment();
		
		appLP.selectingCommitment("4 hours per day");
		
		appLP.stipendRange();
		
		appLP.selectingStipend("20,000 - 30,000");
		
		appLP.clickForDate();
		
		appLP.selectdateMonth();
		
		//appLP.Submit();
		
	}
	
	
	@Test(priority = 1)
	public void checkForMandatory() throws InterruptedException {
		
		LiveProjectPage appLP = new LiveProjectPage(driver);
		
		appLP.openLiveProject();
		
		appLP.openApplication();
		
		appLP.personalDetails("sudeshna", "shetty", "sudeshnashetty2211@gmail.com", "9133690791");
		
		appLP.enterPin("1919");
		
		appLP.verifyPin();
		
		appLP.linkedInUrl("");
		
		appLP.clickNext();
		
		
		
	}

}
