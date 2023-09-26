package WebApp.MemberPortal.Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.MemberPortal.BaseClass.WebBase;
import WebApp.MemberPortal.Common.CommonMethods;



public class LoginPage extends WebBase{
	
	// Object Repository :-
	
	@FindBy(id="email")
	public WebElement usernameBox;
	
	@FindBy(id="password")
	public WebElement passwordBox;
	
	@FindBy(xpath="//button[@class='l-button']")
	public WebElement signInBtn;
	
	@FindBy(xpath="//a[text()=' Sign-up Now ']")
	public WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(), ' Forgot password ')]")
	public WebElement forgotPasswordLink;
	
	
	@FindBy(xpath="//div[contains(text(),'Incorrect email or password.')]")
	public WebElement invalidLoginErrorMsg;
	
	
	@FindBy(xpath="//div[contains(text(),'Email is required.') and @class='error-message']")
	public WebElement emptyEmailFieldtxt;
	
	@FindBy(xpath="//div[contains(text(),'Password is required.') and @class='error-message']")
	public WebElement emptyPwdFieldtxt;
	

	

	
	// Objects declarations:-
	public Actions action;
	public WebDriverWait wait;
	
	

	public LoginPage() throws IOException {
		//this.driver=driver;
				PageFactory.initElements(driver, this);        // 'this' means initializing current class objects with driver of base class i.e @FindBy ones.Instead of 'this' you can also write  'LoginPage.class'
				//wait =new WebDriverWait (driver, 90);        // creating explicit wait object [This is SELENIUM 3 code]			
				wait =new WebDriverWait (driver, Duration.ofSeconds(90));  // THIS IS SELENIUM 4 code for EXPLICIT WAIT. ABove this in line 62 was SELENIUM 3 code for same 
		
	}
	 
		//    Methods/Actions for LoginPage  :-
	
	
	 public String verifyLoginPageTitle(){
		  return  driver.getTitle();  
	  }
	  
	
	public HomePage verifyValidLogin(String un, String pwd) throws IOException{
		usernameBox.clear();
		usernameBox.sendKeys(un);
		passwordBox.clear();
        passwordBox.sendKeys(pwd);
        signInBtn.click();
        return new HomePage();
	}
	
	public HomePage validLoginAbcAustin(String un, String pwd) throws InterruptedException, IOException{
		usernameBox.clear();
		usernameBox.sendKeys(un);
		passwordBox.clear();
        passwordBox.sendKeys(pwd);
        signInBtn.click();
        return new HomePage();
	}
	
	public boolean invalidPwdLogin(String un, String pwd) throws IOException{
		usernameBox.clear();
		usernameBox.sendKeys(un);
		passwordBox.clear();
        passwordBox.sendKeys(pwd);
        signInBtn.click();
        boolean isInvalidPasswordTxtVisible=invalidLoginErrorMsg.isDisplayed();
        return isInvalidPasswordTxtVisible;
	}
	
	
	
	public boolean invalidEmailLogin(String un, String pwd) throws IOException{
		usernameBox.clear();
		usernameBox.sendKeys(un);
		passwordBox.clear();
        passwordBox.sendKeys(pwd);
        signInBtn.click();
        boolean isInvalidEmailTxtVisible=invalidLoginErrorMsg.isDisplayed();
        return isInvalidEmailTxtVisible;
	}
	
	public void  verifyEmptyLoginErrorMsgs(){
		usernameBox.clear();
		passwordBox.clear();
        signInBtn.click();
       //boolean emptyEmailTextFlag= emptyEmailFieldtxt.isDisplayed(); 
       //boolean emptyPwdTextFlag =emptyEmailFieldtxt.isDisplayed();
	}
	
	public void  signUpLink() throws IOException, InterruptedException{
	//signUpLink.click();
		
		//driver.findElement(By.cssSelector("a[href='/signup']")).click();
		
		//CommonMethods.scrollToElementClick(signUpLink);
		
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.cssSelector("a[href='/signup']")).click();
        action.moveToElement(signUpLink).click().perform();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
