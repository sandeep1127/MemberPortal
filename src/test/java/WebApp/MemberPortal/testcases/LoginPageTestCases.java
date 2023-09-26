package WebApp.MemberPortal.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import WebApp.MemberPortal.BaseClass.WebBase;
import WebApp.MemberPortal.Pages.HomePage;
import WebApp.MemberPortal.Pages.LoginPage;
import WebApp.MemberPortal.Pages.SignUpPage;
import WebApp.MemberPortal.testcases.CustomListener;

@Listeners(CustomListener.class)
public class LoginPageTestCases extends WebBase {

	
	LoginPage loginPage;
	HomePage homePage;  // FYI : we initialized object of HomePage through 'ValidLoginTest' Test case. 
	SignUpPage signup;
	
	
	                                        
	
		public LoginPageTestCases() throws IOException {
			super();                                                   // STEP 1 : Calling Constructor of BASE class to initialize Properties file. Otherwise it will give null point exception
			
		}
	
		@BeforeMethod
		 public void setUp() throws IOException{
			init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
			loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
			
			
			
		}
		 
		/*     IMP Keywords :-  
		 
		   a) "dependsOnMethods" : When some test case depends on other test case eg homepage will open only if login happens , so use keyword 'dependsOnMethods="testcaseName"'
			   eg @Test(dependsOnMethods="validLoginTest")    > Here it means, if  'validLogintest()' test case fails, then automatically this test case will be skipped.
			   eg public void homepage(){} 
		   b) "invocationCount=10" : When you want to run some test case multiple times, we use keyword 'invocationCount = [no of time u want test case to run]
		       eg @Test(invocationCount=10) : here it will run automatically 10 times.
		*/
		 
		
		
		 
		// Step 4 : Creating Test Cases
		
	
		@Test(priority=1)
		public void LoginPageTitleTest(){
			Assert.assertEquals(loginPage.verifyLoginPageTitle(), "Member Login | SmartAC.com");
		}
		
		
		@Test
		public void ValidLoginTest() throws IOException{
			homePage = loginPage.verifyValidLogin(config.getProperty("username1"), config.getProperty("password1"));  // Here, 'homePage' object gets initialized
			Assert.assertTrue(homePage.profileIcon.isDisplayed(), "The SmartAC user is not able to log in");
		}
		
		
		@Test
		public void validLoginAbcAustinTest() throws IOException{
			homePage = loginPage.verifyValidLogin(config.getProperty("username2"), config.getProperty("password2"));  // Here, 'homePage' object gets initialized	
			Assert.assertTrue(homePage.abcUserEmailElement.isDisplayed(),"ABC Austi user is not able to log in");
		}
		
		
		
		@Test
		public void invalidPwdLoginTest() throws IOException{
		 
	    Assert.assertTrue(loginPage.invalidPwdLogin(config.getProperty("username"), config.getProperty("wrongPass")),"Invalid Password Error message not displayed");
		}
		
		
		@Test
		public void invalidEmailLoginTest() throws IOException{
			Assert.assertTrue(loginPage.invalidEmailLogin(config.getProperty("wrongUsername"), config.getProperty("password")),"Invalid Email Error message not displayed");
		}
		
		
		@Test
		public void verifyEmptyLoginErrorMsgTest() throws IOException{
			loginPage.verifyEmptyLoginErrorMsgs();
			
			Assert.assertTrue(loginPage.emptyEmailFieldtxt.isDisplayed());
			Assert.assertTrue(loginPage.emptyPwdFieldtxt.isDisplayed());
            SoftAssert softAssert = new SoftAssert();   // will have to create 'SoftAssert' class Object at each Test case level (We did not create Single Object at Global level because in that case , all test cases results of all cases will be shown so better to create a new Object in each class).(Always use method "softAssert.assertAll(); in each Test Case for SoftAssert to work)
			
			softAssert.assertTrue(loginPage.emptyEmailFieldtxt.isDisplayed());
			softAssert.assertTrue(loginPage.emptyPwdFieldtxt.isDisplayed());
			softAssert.assertAll();                      // we always need to add this method if we use SoftAssert, otherwise failed test case also will be shown as Passed.
			
		}
		
//		@Test
//		public void signUpLinkTest() throws IOException, InterruptedException{
//			signUp=loginPage.signUpLink();
//			
//			
//			SoftAssert softAssert = new SoftAssert();
//			softAssert.assertTrue(signUp.signupWelcomeStaticTxt.isDisplayed());
//			softAssert.assertTrue(signUp.createPwdlabel.isDisplayed());
//			softAssert.assertAll();
//		}
//		
		
		
		@Test
		public void signUpLinkTest() throws IOException, InterruptedException{
			
		loginPage.signUpLink();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
