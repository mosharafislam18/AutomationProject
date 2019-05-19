/*we have created this class WebEventListener in order to implement interface,
it is to override all the methods and define certain helpful log actions which would be displayed
or logged as the application under test is being executed. These methods will be invoked 
by itself automatically when certain action are performed. ex: click, submit, screenshot, findBy, etc
*/
package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	public void beforeNavigateTo(String url, WebDriver driver){
		System.out.println("Before navi to: " + url + "'");
	}
	public void afterNavigateTo(String url, WebDriver driver){
		System.out.println("Navigate to: "+ url + "'");
	}
	public void beforeChangeValueOf(WebElement element, WebDriver driver){
		System.out.println("Value of: "+ element.toString()+ "Before making any changes");
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver){
		System.out.println("Element value change to: "+ element.toString());
	}
	public void beforeClickingOn(WebElement element, WebDriver driver){
		System.out.println("Attempting to Click on:"+ element.toString());
	}
	public void afterClickingOn(WebElement element, WebDriver driver){
		System.out.println("Successfully Click on:"+ element.toString());
	}
	public void beforeNavigateBack(WebDriver driver){
		System.out.println("Navigate back to previous");
	}
	public void afterNavigateBack(WebDriver driver){
		System.out.println("Navigating to current page");
	}
	public void beforerNavigatingForward(WebDriver driver){
		System.out.println("Attempting to navigate to next page");
	}
	public void afterNavigatingForward(WebDriver driver){
		System.out.println("Successfully Navigated to next page");
	}
	public void dueToException(Throwable error, WebDriver driver){
		System.out.println("Exception occued: "+ error);
		try{
			TestUtil.takeScreenshotAt();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void beforeFindBy(By by,WebElement elemnent, WebDriver driver){
		System.out.println("Attempting to find the element: "+ by.toString());
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Found the element: " + by.toString());
	}
	//these are non overridden methods of the WebListener class
	public void beforeScript(String script, WebDriver driver){
	}
	public void afterScript(String script, WebDriver driver){
	}
	public void beforeAcceptingAlert(WebDriver driver){
	}
	public void afterAcceptingAlert(WebDriver driver){
	}
	public void beforeDismissingAlert(WebDriver driver){
	}
	public void afterDismissingAlert(WebDriver driver){
	}
	public void beforeNavigateRefresh(WebDriver driver){
	}
	public void afterNavigateRefresh(WebDriver driver){
	}
	public void beforeChageValueof(WebElement element, WebDriver driver, CharSequence [] KeysToSend){
	}
	public void afterChageValueof(WebElement element, WebDriver driver, CharSequence [] KeysToSend){
	}
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0){
	}
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){
	}
	public void beforeGetText(WebElement arg0, WebDriver arg1){
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
	}
	public void beforeSwitchToWindow(String arg0, WebDriver arg1){
	}
	public void afterSwitchToWindow(String arg0, WebDriver arg1){
	}
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
