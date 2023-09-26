package WebApp.MemberPortal.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebApp.MemberPortal.BaseClass.WebBase;

public class HomePage extends WebBase{
	
	// Object Repository :-
	
	@FindBy(xpath="//div[text()=' Profile ' and @class='p-header']")
	public WebElement profileIcon;
	
	@FindBy(xpath="//b[text()='abc.agarza@gmail.com']")
	public WebElement abcUserEmailElement;
	
	@FindBy(xpath="//div[text()=' To make any changes to your SmartAC.com plan, please contact your HVAC provider directly. ']")
	public WebElement abcUserPlanDescripElement;
	
	@FindBy(xpath="//a[text()='https://www.abchomeandcommercial.com']")
	public WebElement abcUserPlanEmail;
	

	public HomePage() throws IOException {
	PageFactory.initElements(driver, this);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
