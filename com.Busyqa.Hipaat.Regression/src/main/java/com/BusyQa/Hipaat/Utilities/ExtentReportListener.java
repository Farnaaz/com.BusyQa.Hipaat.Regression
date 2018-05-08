package com.BusyQa.Hipaat.Utilities;

/**
 * @author Farnaaz
 * 
 * -----This is a testNG listener class which will generate extent reports ------
This class will be added in testng.xml file under the listener tag.  
 */

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
		
	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/Hipaat-Test-Report.html");//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Farnaaz");
		
		htmlReporter.config().setDocumentTitle("Hipaat Project"); // Tile of report
		htmlReporter.config().setReportName("Regression Test Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		test.fail(result.getThrowable()); //printing entire stacktrace for failed reason
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		try {
			test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
				e.printStackTrace();
		} 
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		test.skip(result.getThrowable()); //printing entire stacktrace for skipped reason
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	}





	
	


