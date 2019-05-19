package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(css="[title='Log in to your customer account']")
	static WebElement signInButton;
	
	@FindBy(css="[title='Contact Us']")
	static WebElement contactLink;
	
	@FindBy(id="search_query_top")
	static WebElement searchInput;
	
	@FindBy(id="submit_search")
	static WebElement searchButton;
	
	@FindBy(css="[title='Log me out']")
	static WebElement logoutButton;
	
	@FindBy(css="[class='logo img-responsive']")
	static WebElement pageLogo;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public SearchPage searchInput(String productName){
		searchInput.sendKeys(productName);
		searchButton.click();
		return new SearchPage();
	}
	public void signInButton(){
		signInButton.click();
	}
	
	public void pageLogo(){
		pageLogo.click();
	}
	public void contactLink(){
		contactLink.click();
	}
	public void logoutButton(){
		logoutButton.click();
	}
	
	public ProductDetailsPage selectProduct(String productName)
	{
		String locator = "[class='product-name'][title='"+ productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailsPage();
	}
}
