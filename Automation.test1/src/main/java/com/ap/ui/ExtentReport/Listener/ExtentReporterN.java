package com.ap.ui.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//built in interface, creating a private constructor
public class ExtentReporterN implements IReporter {
	//its an private because we don't want to share the results with any other classes
	private ExtentReports extent; 
	

/*created a method and using a array mechanism called list and the list get the arrange code,
	look for the suites which are the classes(pages) created- can't be anything else but String*/
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, String outputDirectory)
{	/*call my object from previously, creating an object for extent report to save all my outputs as String
	file separator is helpful when it comes to running on different platforms and Extent.html is how 
	the file should be save, boolean value is so if you don't have any info than don't generate
	the report(make sure that there is no fail with empty reports)*/
	extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
	/*map obtain the key value that can't be duplicated, then it map it to one location
	that one location is your extentreport
	map in an interface in java which allows you to create an
	sharing the value receive from the results with extentrerport
	":" is an condition operator saying that if suite is equal to suites than you execute
	if not than you go to the next line of code*/
	for(ISuite suite: suites){
		Map<String, ISuiteResult>result = suite.getResults();
	//context is whenever i run something i will always get a result for it whether its pass,fail or skip
	for(ISuiteResult r: result.values()){
		ITestContext context =r.getTestContext();
		//if the for loop pass,fail,skip than it will just capture it depending on the results
		buildTestNodes(context.getPassedTests(), LogStatus.PASS);
		buildTestNodes(context.getPassedTests(), LogStatus.FAIL);
		buildTestNodes(context.getPassedTests(), LogStatus.SKIP);
	}	
}
//after the execution is complete, it will take the result you get and add the result to html file
extent.flush();
//it closes the file 
extent.close();

	
}
//creating a private constructor and calling ExtentTest and naming the object as test
private void buildTestNodes(IResultMap tests, LogStatus status){
	ExtentTest test;
//
	if((tests).size()>0){
		for (ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());
//how long it took to run the report and know the time of it.
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
//we are going through all of the results and organize the results seperately such as pass,fail or skip
			for(String group: result.getMethod().getGroups())
				test.assignCategory(group);
// see if there is an error, and if there is than just log in
// if there is not an error, 
//null is an empty String
			if(result.getThrowable() !=null){
				test.log(status, result.getThrowable());
			}else{
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
			}
			
			extent.endTest(test);
			
		}
}
}
//stamp the time and date with the local 
private Date getTime(long millis){
	Calendar calender = Calendar.getInstance();
	calender.setTimeInMillis(millis);
	return calender.getTime();

}	
}



