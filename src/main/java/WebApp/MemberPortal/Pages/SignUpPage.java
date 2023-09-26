package WebApp.MemberPortal.Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.MemberPortal.BaseClass.WebBase;

public class SignUpPage extends WebBase{

	
	// Object Repository :-
	@FindBy(xpath="//div[text()=' Welcome! ']")
	public WebElement signupWelcomeStaticTxt;
	
	@FindBy(xpath="//label[text()='Create Password']")
	public WebElement createPwdlabel;
	
	
	
	
	
	
	
	
	
	
	public WebDriverWait wait;
	
	public SignUpPage() throws IOException {
		PageFactory.initElements(driver,this); 
		//wait =new WebDriverWait (driver, 60);    // using explicit wait & instantiating it in Constructor itself.
		wait =new WebDriverWait (driver, Duration.ofSeconds(90));  // THIS IS SELENIUM 4 code for EXPLICIT WAIT
	}

}
