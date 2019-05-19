package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;



//setting up the property value for the class i will be working with
public class TestBase {
	
	public static WebDriver driver;
	public static Properties propt;
	//lets the driver sends the event after receiving from WebEventListener
	public static EventFiringWebDriver en_driver;
	//capture the events 
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		try //1.capture any error that might occur and 2.avoid the error that you might get with the file
		{
			propt = new Properties();
			//user.dir tells file input that the file lives within the project directly
			//creating a new object and calling the file
			//fileinputstream is used to invoke the file needed
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/ap/ui/config/config.properties");
			//new object ipa 
			propt.load(ipa);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	//created a string value equal to property value
	//this tells you which ever browser you are using 
	public static void intialization(){
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\PSQA\\Documents\\Eclipse Data\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\PSQA\\Documents\\Eclipse Data\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	}	// initialize the driver, creating an object
		//calling the object multiple times instead of calling the driver
		//driver is an object for all the drivers such as chrome, firefox,ie, etc.
		//create object for action that's occuring and sharing with driver 
		en_driver = new EventFiringWebDriver(driver);
		//create object of WebeventListener to register it with eventFiringWebdriver
		eventListener = new WebEventListener();
		//event can be capture based on the method we create webEventListener class
		en_driver.register(eventListener);
		//since we know driver object if for browser en_browser is for the event that is taking place.
		//we declaring that they are equal to each other when they are exchanging the info
		driver = en_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
		
		driver.get(propt.getProperty("url"));
	
}
}
