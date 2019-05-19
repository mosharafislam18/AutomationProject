package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase{
	
	ContactPage contactpage;
	HomePage homepage;
	
	public ContactTest(){
		super();
	}
	
	@BeforeMethod
	public void setupDriver(){
		intialization();
		contactpage = new ContactPage();
		homepage = new HomePage();
	}
	@Test
	public void testConnection(){
		homepage.contactLink();
		contactpage = contactpage.fillContactForm("Customer Service", "Random@test.com", 
				"Testing", "This is a test purpose");
		//verify contacts to get the successful message
		contactpage.submitMessage();
		String successMessage = contactpage.getMessage();
		Assert.assertEquals(successMessage, "will check this message on the site later");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
