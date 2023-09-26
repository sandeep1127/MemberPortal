package WebApp.MemberPortal.testcases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import WebApp.MemberPortal.BaseClass.WebBase;

public class CustomListener extends WebBase implements ITestListener{   // This class is Implementing ITestListner class which contains the pre made method which we implemented to take screenshot of failed test cases only
	// Here , we just implemented just 1 method of this interface which is to take screenshot of failed test cases

	public CustomListener() throws IOException {
		super();
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case is failed and screenshot is taken");
		try {
		screenShotOfFailedCases(result.getMethod().getMethodName());
		} catch (IOException e) {
		
		e.printStackTrace();
		}
		
		}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
