package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase {

	//page factory
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath= ".//[@id='SubmitLogin']")
	WebElement submitbutton;
	
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	WebElement apLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//verify the title of the page - get title
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	//when we go the page, we want to check if the image of the logo is shown
	public boolean validateAPImage(){
		return apLogo.isDisplayed();
	}
	//pass the information through String value and afterwards press the submit button
	public HomePage login(String uname, String passw){
		username.sendKeys(uname);
		password.sendKeys(passw);
		submitbutton.click();
		
		return new HomePage();
	}
}






