package com.BusyQa.Hipaat.TestBase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;



/**@author Farnaaz
 * This TestBaseClass will be the parent class for all other classes..using Inheritance (Is-A) concept 
 * It will read/load properties file (readconfig.properties) and have a method for browser (firefox/chrome) setup 
 *  
 *
 */

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties pro; 	
	public static Logger log; 
	public static SoftAssert softAssert;

	//constructor to define properties file

	public TestBaseClass() {

		pro = new Properties();
		//Reading file
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/BusyQa/Hipaat/Config/ReadConfig.properties");

			//loading file
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {System.out.println("Exception is::" + e.getMessage());}

		softAssert=new SoftAssert();
		log=Logger.getLogger("TestBaseClass");
		PropertyConfigurator.configure("log4j.properties");
	}


	//for browser initialization 
	public static void browserinitialization() {

					
			String browserName = pro.getProperty("browser");

			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

				driver = new ChromeDriver();
				log.info("*****Initializing chrome browser*****");

			}else if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");	
				driver = new FirefoxDriver();
				log.info("*****Initializing firefox browser*****");
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(pro.getProperty("Url"));

	}


	@AfterMethod
	public void getScreenShot(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			String destFile = System.getProperty("user.dir") + "//screenshots//" + result.getName() + ".png";
			File finalDestination = new File (destFile);
			FileUtils.copyFile(srcFile, finalDestination);
			System.out.println("Screenshot Taken");

		}

	}


}