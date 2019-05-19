package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.ProductDetailsPage;
import com.ap.ui.pages.SearchPage;

public class WishListTest extends TestBase{
		
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailPage;
	
	public WishListTest()
	{
		super();
	}
@BeforeMethod
public void setUpdriver()
{
	intialization();
	loginPage = new LoginPage();
	homePage = new HomePage();
}
@Test
public void testAddProductToWishList()
{
	String product = "Printed Chiffon Dress";
	homePage.signInButton();
	homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	//search product
	searchPage = homePage.searchInput(product);
	String header = searchPage.getHeader();
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	
	productDetailPage.AddToWishlist();
	productDetailPage.VerifyWishlistMessage();
	homePage.logoutButton();
}
@AfterMethod
public void tearDown(){
	driver.quit();
}
}
