package script;

import org.testng.annotations.Test;

import pages.BasePage;
import pages.Homepage;
import pages.InterviewQuestions;
import pages.Landingpage;
import pages.LoginPage;

public class HomePage extends BasePage{
	
	@Test(priority = 1)
	public void navigatingToModule() throws InterruptedException {
		
		Landingpage lP = new Landingpage(driver);
		
		lP.openingLoginPage();
		
		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9553259691", "1919");
		
		Homepage hP = new Homepage(driver);
		
		hP.selectingModuleFromLearn("Learn with Concept cards");
		
		lP.clickBack();
		
	}
	
	@Test(priority = 2)
	public void interactingWithModule() throws InterruptedException {
		
		Landingpage lP = new Landingpage(driver);
		
		/*lP.openingLoginPage();
		
		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9553259691", "1919");*/
		
		Homepage hP = new Homepage(driver);
		
		hP.selectingModuleFromLearn("Practice with Interview questions");
		
		InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
	    
		interviewQuestion.paginationForQuestion(1);
		
		/*interviewQuestion.writeAnswer(" Estimate Facebook’s ad revenue. Show your "
	    		+ "work in your own notebook. Make any assumptions as necessary. Answer on the next page"
	    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
	    		+ "Make any assumptions as necessary. Answer on the next page"
	    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
	    		+ "Make any assumptions as necessary. Answer on the next page");
		
		interviewQuestion.submitAnswerAfterLogin();*/
		
		//logIn.logOut();
		interviewQuestion.backToQuestionPage();
		
		lP.clickBack();
		
	}
	
	@Test(priority = 3)
	
	public void setGoalsWithCustomize() throws InterruptedException {
		
		/*Landingpage lP = new Landingpage(driver);
		
		lP.openingLoginPage();
		
		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9703533184", "1919");*/
		
		Homepage hP = new Homepage(driver);
		
		hP.clickForEditGoal();
		
		hP.clickGoalLevel("Customize");
		// typing the number for each goal
		//pass id of ["id of textbox", "no"]
		hP.typeNumberOfGoals("input", "5");
		///hP.typeNumberOfGoals("input2", "5");
		hP.typeNumberOfGoals("input3", "5");
		hP.typeNumberOfGoals("input4", "5");
		hP.typeNumberOfGoals("input5", "5");
		//hP.typeNumberOfGoals("input6", "5");
		hP.typeNumberOfGoals("input7", "5");
		hP.typeNumberOfGoals("input8", "6");
	//checking the checkbox
		//passing ["id of checkBox"]
		hP.checkGoals("conceptC");
		//hP.checkGoals("quizId");
		hP.checkGoals("pracQ");
		hP.checkGoals("intQ");
		//hP.checkGoals("sPrac");
		hP.checkGoals("sInt");
		hP.checkGoals("sCaseS");
		hP.checkGoals("case");
		
		hP.goalSet();
		
	
		
	}
	
/*	@Test(priority = 4)
	public void setGoalBeginner() throws InterruptedException {
		
		Homepage hP = new Homepage(driver);
		
		hP.clickForEditGoal();
		
		hP.clickGoalLevel("Beginner");
		
		hP.goalSet();
		
	}
	
	@Test(priority = 5)
	public void setGoalIntermediate() throws InterruptedException {
		
		Homepage hP = new Homepage(driver);
		
		hP.clickForEditGoal();
		
		hP.clickGoalLevel("intermediate");
		
		hP.goalSet();
	}
	
	@Test(priority = 6)
	public void setGoalHard() throws InterruptedException {
		
		Homepage hP = new Homepage(driver);
		
		hP.clickForEditGoal();
		
		hP.clickGoalLevel("Hard");
		
		hP.goalSet();
	} 
	
	@Test(priority = 0)
	public void listOfGoals() throws InterruptedException {
		
		Landingpage lP = new Landingpage(driver);
		
		lP.openingLoginPage();
		
		LoginPage logIn = new LoginPage(driver);
		
		logIn.LogInFromRegistration("9553259691", "1910");
		
		Homepage hP = new Homepage(driver);
		
		Thread.sleep(8000);
		
		hP.goalList();
		
	}*/
	
	

}
