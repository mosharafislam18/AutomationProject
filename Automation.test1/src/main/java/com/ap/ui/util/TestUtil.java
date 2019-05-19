package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;


public class TestUtil extends TestBase {
	
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;

	
	// allows you to interact with or read excel sheet
	public static String XL_SHEET_PATH = "";
	//getting the 
	static Workbook book;
	//getting the sheet from excel
	static Sheet sheet;
	//
	static JavascriptExecutor js;
	//we are getting only two row of info "username and password"
	public static Object[][] getTestData(String sheetName){
		//handling scenarios, if it doesnt have value than it will not perform it, not performing without any data
		FileInputStream file = null;
		//try catch to handle the error or you can do it with ioexception (file level and than workbook level)
		try{
			file = new FileInputStream(XL_SHEET_PATH);
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}//if the file is found, try to find the workbook
		try{
			book = WorkbookFactory.create(file);
			//if the workbook exist but its in the wrong format
		}catch(InvalidFormatException e){
			e.printStackTrace();
			//if the file exist but the workbook doesnt 
		}catch(IOException e){
			e.printStackTrace();
		}
		//retrieve the data from the specified
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//loop through the sheet's row
		for(int i = 0; i< sheet.getLastRowNum(); i++){
			//loop through the sheet's cell
			for(int j = 0; j< sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
}	
	
	//allows you to take screenshot and save it to a folder within the class and the name is dynamic
	public static void takeScreenshotAt() throws IOException{
		//takes the screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//saves the screenshot user.dir is the machine and project
		String currentDirect = System.getProperty("user.dir");
		/*saves it to the file/folder named "screenshot" than you put 
		the file in the folder with the current time as the name of the file and save it as .png*/
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + System.currentTimeMillis() + ".png"));

}	//method for error checking javascript
	//capture any response that is happening in the script
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
	// create a javascript executor object
		js = (JavascriptExecutor) driver;
	//get the element from the page using javascript 	
	//tells the script to go to this site and use the script there to get information
		js.executeScript("if(!window.JQuery){"
			+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
			+ "jquery.src= 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
			+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");		
		Thread.sleep(6000);
		//use the script that is found at the specific link in order to translate the information
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		//growl = fetching method
		//$ = define/access jQuery
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(6000);
		
		js.executeScript("$ growl({ title: 'GET', message: '/'});");
		
		if(messageType.equals("error")){
			js.executeScript("$growl.error({ title: 'ERROR' message: '"+ message+"'});");
		}else if (messageType.equals("info")){
			js.executeScript("$growl.error({title: 'Notice', message: 'your notice message will appear here'});");
		}else if (messageType.equals("warning")){
			js.executeScript("$growl.error({title: 'Warning!', message: 'your warning message will appear here'});");
		}else 
			System.out.println("Show no Error Message");
		Thread.sleep(6000);
}
}


