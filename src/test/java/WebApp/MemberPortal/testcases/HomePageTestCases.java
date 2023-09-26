	package WebApp.MemberPortal.testcases;
	
	import java.io.IOException;
	
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Listeners;
	
	import WebApp.MemberPortal.BaseClass.WebBase;
	import WebApp.MemberPortal.Pages.HomePage;
	import WebApp.MemberPortal.Pages.LoginPage;
	import WebApp.MemberPortal.Pages.SignUpPage;
	
	@Listeners(CustomListener.class)
	public class HomePageTestCases extends WebBase {
	
		LoginPage loginPage;
		HomePage homePage;  // FYI : we initialized object of HomePage through 'ValidLoginTest' Test case. 
		SignUpPage signup;
	
	
	
	public HomePageTestCases() throws IOException {
			super();                                            // STEP 1 : Calling Constructor of BASE class to initialize Properties file. Otherwise it will give null Pointer exception
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
		loginPage = new LoginPage(); 							// STEP 3 : Creating Object of LOGINPAGE class to use its methods.
		homePage= loginPage.verifyValidLogin(config.getProperty("username"), config.getProperty("password"));  // Step 4 : I have to login each time to go to HOMEPAGE screen So , i'm including this in my Before Method.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
