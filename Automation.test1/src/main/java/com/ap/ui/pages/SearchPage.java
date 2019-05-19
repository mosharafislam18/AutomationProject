package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class SearchPage extends TestBase{

	@FindBy(css="[title='add to cart']")
	WebElement addCartButton;
	
	@FindBy(css= "[title='Proceed to checkout']")
	WebElement CheckOut;
	
	@FindBy(css= "[class='page-heading product-listing']")
	WebElement searchHeading;
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}
	public ProductDetailsPage selectProduct(String productName){
		
		String locator = "[class='productname'][title='" + productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailsPage();
			
}
	public String getHeader(){
		return searchHeading.getText();
	}

}