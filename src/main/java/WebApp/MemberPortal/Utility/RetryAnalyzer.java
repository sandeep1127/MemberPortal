package WebApp.MemberPortal.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{          // 1st step : This class we created should 'implement' an ‘interface’ called ‘ IRetryAnalzer’ . (This Interface comes from TestNG)

	// below, is the logic we write to run our failed case the no of times we want.
			
int counter = 0;               
int retryLimit = 2;   // Here we have the logic to re-run the failed Test Cases 2 times(index value given is 2 by us).  ( FYI : we created  FailedTestCases class for implementing of re-running the Failed test cases where we used "IAnnotationTransformer" Interface)>( From Naveen Automation)

public boolean retry(ITestResult result){
	
	if(counter<retryLimit){
		
counter++;
return true;
	}
	return false;
}
	
	
	
	
	
	
}

