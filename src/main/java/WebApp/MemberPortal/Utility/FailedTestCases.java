package WebApp.MemberPortal.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import WebApp.MemberPortal.Utility.RetryAnalyzer;

public class FailedTestCases implements IAnnotationTransformer {        // Its 2nd step . This interface (comes from TestNG)we use when we want to re-run failed cases by 2nd approach i.e AT RUN TIME.Before this we created another class "RetryAnalyzer' .Here we use method transform() where we provide location of RetryAnalyzer class and it will re-run the failed test cases ( From Naveen Automation)

	
	
	public void transform(ITestAnnotation annotation, Class testClass , Constructor testConstructor , Method testMethod ){    // We are overriding the method transform() which we get from the interface IAnnotationTransformer.
		
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);    //Here, we are giving the location of the class 'RetryAnalyzer by using the method 'setRetryAnalyzer'where we implemented the counter
		
		
	}


	
	
	
	// (we call the class FailedTestCases.java a Listener as well.)
	
	
	
	
	
}
  // After this step we go to TestNG.xml file which is final step and there we mention one tag <Listener> which tells testNG about the location of this class where we implemented the Interface "IAnnotationTransformer”.