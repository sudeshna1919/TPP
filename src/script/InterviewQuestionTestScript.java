package script;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.BasePage;
import pages.CommentForQuestion;
import pages.FiltersForInterviewQuestion;
import pages.InterviewQuestions;
import pages.Landingpage;
import pages.LoginPage;
import pages.ReplaceAnswer;


public class InterviewQuestionTestScript extends BasePage {
		
/*	@Test(priority = 0)
	public void validatingFilters() throws InterruptedException {
		
		Landingpage landing=new Landingpage(driver);
		
		landing.clickPracticeDropDown();
		
		landing.openingInterviewQuestions();
		
		FiltersForInterviewQuestion Filter = new FiltersForInterviewQuestion(driver);
		
		Filter.clickCompany();
		
		Filter.selectingfilters("Google");
		
		Filter.clickRole();
		
		Filter.selectingfilters("PM");
		
		Filter.clickQuestionType();
		 
		Filter.selectingfilters("Metrics");
		
	    String expectedCompany = Filter.companyName();
	    
	    String actualCompany = "Google";
	    
        String expectedRole = Filter.roleType();
	    
        String actualRole = "PM";
        
        String expectedQuestionType = Filter.questionType();
	    
	    String actualQuestionType = "Metrics";
	    
        Assert.assertEquals(actualCompany, expectedCompany);
	   
	    Assert.assertEquals(actualRole, expectedRole);
	    
	    Assert.assertEquals(actualQuestionType, expectedQuestionType);
	   
	    LoginPage LogIn = new LoginPage(driver);
	   
	    LogIn.clickProductLogo();
		
	}	*/
		
	@Test(priority = 1)
	
	public void selectInterviewQuestion_saveAnswer() throws InterruptedException{
		
		Landingpage landing=new Landingpage(driver);
		
		landing.clickPracticeDropDown();
		
		landing.openingInterviewQuestions();
		
		InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
	    
	    interviewQuestion.paginationForQuestion(87);
	    
	    //writing the answer
	    
	    interviewQuestion.writeAnswer(" Estimate Facebook’s ad revenue. Show your "
	    		+ "work in your own notebook. Make any assumptions as necessary. Answer on the next page"
	    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
	    		+ "Make any assumptions as necessary. Answer on the next page"
	    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
	    		+ "Make any assumptions as necessary. Answer on the next page");
	    
	    //saving the answer
	   
	    String actualAlert1=interviewQuestion.SaveAnswer();
	    
		String alert1="Answer saved!";
		
		interviewQuestion.alertClosing();
		
		Assert.assertEquals(alert1, actualAlert1);
	  
		
	}
	
    @Test(priority = 2)
	
    public void submitAnswerBeforelogIn() throws InterruptedException {
			
	    InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
	  
	    String Expected = interviewQuestion.submitAnswerBeforeLogin();
	    
	    String Actual = "Register for Free!";
	    
	    Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority = 3)
	
	public void submittingAnswerAfterLogIn() throws InterruptedException {
		
		InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
	    
	    LoginPage LogIn = new LoginPage(driver);
	    
		LogIn.logInWithValidCredentialsFromInterviewQuestions();
		
		LogIn.LogInFromRegistration("9553259691", "1910");
		
		//submitting the answer as logged in user
		
		 interviewQuestion.ContiuneAnswer();
		 
		 interviewQuestion.clearAnswer();
		 
		 interviewQuestion.writeAnswer("Estimate Facebook’s ad revenue. Show your "
		    		+ "work in your own notebook. Make any assumptions as necessary. Answer on the next page"
		    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
		    		+ "Make any assumptions as necessary. Answer on the next page"
		    		+ "Estimate Facebook’s ad revenue. Show your work in your own notebook. "
		    		+ "Make any assumptions as necessary. Answer on the next page");
		 
		 String successfulSubmitAlert1= interviewQuestion.submitAnswerAfterLogin();
	    
	     String Actual = "Congratulations";
	     
	    // interviewQuestion.alertClosing();
	     
	     interviewQuestion.closeCongrats();
	    
	    Assert.assertEquals(Actual, successfulSubmitAlert1);
	    
	    System.out.println("Verified submitting the answer");
	   
	    Thread.sleep(5000);
	}
	
   @Test(priority = 4 )
	
	public void userAnswerEditing() throws InterruptedException {
		
	    InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
		
		interviewQuestion.editAnswer();
		
		interviewQuestion.ContiuneAnswer();
		
		interviewQuestion.clearAnswer();
		
		interviewQuestion.writingAnsweringForEdit("This answer is editing for testing automation code and then will be replaced again for same answer for the same user i think this should be more than 200 characters "
				+ "This answer is editing for testing automation code and then will be replaced again for same answer for the same user i think this should be more than 200 characters");
		
		String Expected= interviewQuestion.submitAnswerAfterEditing();
		
		String Actual="Your Answer has been Posted!";
		
		interviewQuestion.alertClosing();
		
		Assert.assertEquals(Actual, Expected);
		
		Thread.sleep(5000);
		
	}
    
    @Test(priority = 5 )
	public void EmptyUserAnswerEditing() throws InterruptedException {
	
	    InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
		
		interviewQuestion.editAnswer();
		
		interviewQuestion.ContiuneAnswer();
		
		interviewQuestion.clearAnswer();
		
		interviewQuestion.writingAnsweringForEdit(" The user is busy");
		
		String Expected= interviewQuestion.submitAnswerAfterEditing();
		
		String Actual="Answer requires a minimum of 200 characters";
		
		interviewQuestion.alertClosing();
		
		Assert.assertEquals(Actual, Expected);
		
		Thread.sleep(5000);
		
	}

    @Test(priority = 6)
    public void verifyingComment() throws InterruptedException {
	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    	
    	CommentForQuestion comment = new CommentForQuestion(driver);
	
    	comment.clickOnComment();

    	comment.writeComment("Users Users pay for enhanced control over their smart home devices through Alexa. Users pay for enhanced control over their smart home.");

    	comment.postComment();
    	
    	String ExpectedAlert=comment.alertValidation("Users Users pay for enhanced control over their smart home devices through Alexa. Users pay for enhanced control over their smart home.");
	
    	String Actualalert="Your Comment has been Posted!";
    	
    	interviewQuestion.alertClosing();
	
    	Assert.assertEquals(Actualalert, ExpectedAlert);
	
    	Thread.sleep(5000);
	
	
    }

    @Test(priority = 7)
    public void verifyingNullComment() throws InterruptedException {
	 	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    	
		CommentForQuestion comment = new CommentForQuestion(driver);
		
		comment.writeComment("");

    	comment.postComment();
		
		String ExpectedAlert =  comment.alertValidation("");
		
		String Actualalert="Comment requires a minimum of 25 characters";
		
		interviewQuestion.alertClosing();
		
		Assert.assertEquals(Actualalert, ExpectedAlert);
		
		Thread.sleep(2000);
			
    }

    @Test(priority = 8)
    public void verifyingCommentLessThan25Chars() throws InterruptedException {
	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    	
		CommentForQuestion comment = new CommentForQuestion(driver);
		
		comment.writeComment("HELLO");

    	comment.postComment();
		
		String ExpectedAlert =  comment.alertValidation("HELLO");
		
		String Actualalert="Comment requires a minimum of 25 characters";
		
		Assert.assertEquals(Actualalert, ExpectedAlert);
		
		interviewQuestion.alertClosing();
		
		Thread.sleep(4000);
			
    }

    @Test(priority = 9)
    public void verifyingCommentMoreThan200Chars() throws InterruptedException {
    	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    	
		CommentForQuestion comment = new CommentForQuestion(driver);
		
		comment.writeComment("Overall, this question provides an excellent opportunity for reflection and discussion, and I look forward to hearing others' perspectives.\""
				+ "Overall, this question provides an excellent opportunity for reflection and discussion, and I look forward to hearing others' perspectives.\"");

    	comment.postComment();
	
	    LoginPage LogIn = new LoginPage(driver);

		String ExpectedAlert =  comment.alertValidation("Overall, this question provides an excellent opportunity for reflection and discussion, and I look forward to hearing others' perspectives.\""
				+ "Overall, this question provides an excellent opportunity for reflection and discussion, and I look forward to hearing others' perspectives.\"");
		
		String Actualalert="Maximum character limit for comment is 200";
		
		interviewQuestion.alertClosing();
		
		Assert.assertEquals(Actualalert, ExpectedAlert);
		
		Thread.sleep(4000);
		
		LogIn.logOut();
			
    }

 /*   @Test(priority = 10)
    public void replacingAnswer() throws InterruptedException {
  
    	Landingpage landing=new Landingpage(driver);
    	
    	landing.clickPracticeDropDown();
	
    	landing.openingInterviewQuestions();
	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    
    	interviewQuestion.paginationForQuestion(246);
    
    	ReplaceAnswer ReAnsw = new ReplaceAnswer(driver);
    
    	ReAnsw.writingAnswerBeforeLogin();
   
    	LoginPage LogIn = new LoginPage(driver);
    
    	LogIn.logInWithValidCredentialsFromInterviewQuestions();
    	
    	LogIn.LogInFromRegistration("9553259691", "1910");
   
    	String Expected = ReAnsw.popUpForReplace();
	
    	String Actual = "Your Answer has been Posted!";
    	
    	interviewQuestion.alertClosing();
	
    	Assert.assertEquals(Actual, Expected);
	
    	System.out.println("Verified Replacing the answer");
    	
    	Thread.sleep(5000);	
    	//interviewQuestion.profileOpening();
	
    	LogIn.logOut();

    }*/

 /*   @Test(priority = 11 )
    public void userAnswerDeleting() throws InterruptedException {
    	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
   
    	interviewQuestion.editAnswer();
	
    	interviewQuestion.deleteUserAnswer();
	
    	String Expected =interviewQuestion.ConfirmDelete();
	
    	String Actual = "Your Answer has been deleted!";
    	
    	interviewQuestion.alertClosing();
	
    	Assert.assertEquals(Actual, Expected);
    	
    	Thread.sleep(5000);	

    }*/

   /* @Test(priority = 12 )
    public void CancellingDelete() throws InterruptedException {
    	
    	Landingpage landing=new Landingpage(driver);
	
    	landing.openingInterviewQuestions();
	
    	InterviewQuestions interviewQuestion= new InterviewQuestions(driver);
    
    	interviewQuestion.selectingInterviewQuestions(48);
    	
    	landing.openingLoginPage();
    
    	LoginPage LogIn = new LoginPage(driver);
    
    	LogIn.LogInFromRegistration("9553259691", "1910");	
    	interviewQuestion.editAnswer();
	
    	interviewQuestion.deleteUserAnswer();
	
    	interviewQuestion.CancelDelete();

    }*/

}

