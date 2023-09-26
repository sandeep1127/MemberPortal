package WebApp.MemberPortal.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

import WebApp.MemberPortal.Utility.WebEventListener;
import WebApp.MemberPortal.Utility.Xls_Reader;


public class WebBase {

	public static WebDriver driver;          
	public static Properties config;     // 
	
	
	public static Logger log;                       // variable to be used for log4j API for creating manual logs
	public static EventFiringWebDriver e_driver;    // variable to be used for WebFiringDriver for creating console Logs automatically
	public static WebEventListener eventListener;   // variable to be used for WebEventListener for creating console Logs automatically
	
	
	public WebBase() throws IOException{ // initializing 'Properties' file in the Constructor of the BASE CLASS
		config = new Properties();      // initializing the object ( import Properties class from java.util )
		File file = new File("E:\\SandeepJavaWorkspace\\MemberPortal\\Configuration\\config.properties");               // Storing our 'properties' file created into a File object.
		FileInputStream fis = new FileInputStream(file);                                                        // Converting 'properties' file into File Stream
		config.load(fis);	 	
	}
		
	
	public static void init() throws IOException {               //Creating static method  for launching the desired browser as per value  in properties files.
        log = Logger.getLogger("devpinoyLogger");
        
		
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {                                           // opening of desired browser from config env.properties file .
		//System.setProperty("webdriver.chrome.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();           // Instead of above line where we need to always keep updating the driver manually, by using this class(after adding its dependency) we don't need to update driver now.
			
			driver = new ChromeDriver();
			log.info("Chrome browser opened");
			
		} 
			else if(config.getProperty("browser").equalsIgnoreCase("firefox"))  {
				//System.setProperty("webdriver.gecko.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\geckodriver.exe");
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox browser opened");
			}
		
			else if(config.getProperty("browser").equalsIgnoreCase("ie"))  {   
				//System.setProperty("webdriver.ie.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\IEDriverServer.exe");
				//WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("IE browser opened");
			}
		
			else if(config.getProperty("browser").equalsIgnoreCase("edge"))  {   
				//System.setProperty("webdriver.edge.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\msedgedriver.exe");
				//WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				log.info("Edge browser opened");
			}
	
	
		// Step 2 : Below code is a part for generating logs which will be used by WebEventListner class available in Util Package. (step 1 was to create class "WebEventListener")
		     e_driver = new EventFiringWebDriver(driver);
		
		// step 3 : Now create object of 'WebEventListener' class which u created in step 1 to register it with EventFiringWebDriver.
		    eventListener = new WebEventListener();
		    e_driver.register(eventListener);
		   driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		log.info("browser is maximised");
		driver.manage().deleteAllCookies();
		log.info("cookies cleared");
		//driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS); // This was selenium 3.1 code
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); // This is selenium 4 code
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);   // This was selenium 3.1 code
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));  // This is selenium 4 code
		driver.get(config.getProperty("url"));
		log.info(config.getProperty("url") + " app opened");
	}
	// Below Method which will TakeScreenshot and will be called only when any TestCase Fails(Its Listener is written in customListener class:-
	
	public void screenShotOfFailedCases(String testMethodName) throws IOException{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("E:\\SandeepJavaWorkspace\\MemberPortal\\FailedScreenShots\\"+testMethodName+".jpg"));
	
		
		
	}
	
	@AfterMethod                                    
	
	public void tearDown(){
		
	driver.quit();	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	}
	