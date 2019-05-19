package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginPageTest extends TestBase{
		
	LoginPage loginpage;
	HomePage homepage;
	//super helps connect to the parent class testbase constructor
	public LoginPageTest(){
		super();
	}
	//initialize the driver
	@BeforeMethod
	public void setUpDriver(){
		intialization();
		loginpage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.verifyPageTitle();
		//available in testng which allows you to capture value and validate if its true or not
		Assert.assertEquals(title, "Login - My Store");
	}
	@Test(priority=2)
	public void apLogoTest(){
		boolean value = loginpage.validateAPImage();
		Assert.assertTrue(value);
	}
	@Test(priority=3)
	public void loginTest(){
		homepage = loginpage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
