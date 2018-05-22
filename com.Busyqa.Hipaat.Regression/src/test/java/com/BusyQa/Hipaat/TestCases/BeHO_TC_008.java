package com.BusyQa.Hipaat.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to testing Search is returning values in the Security Alert Page ----
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 *Logger class is used to generate custom logs
 *The screenshot method will trigger in event of test case failure.
 * 
 *
 */ 




public class BeHO_TC_008 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SecurityAlertSearchpage sas;


	public BeHO_TC_008() {
		super();
		log.info("*****parent class constructor called and properties file initiated*****");
	}

	@BeforeMethod
	public void setUp() {

		browserinitialization(); 
		log.info("*****browser is successfully initialised*****");

		login = new Loginpage();
		login.Login(pro.getProperty("UserID"), pro.getProperty("Password"), pro.getProperty("Facility"));
		log.info("*****login is successfully done*****");
	}

	@Test
	public void TC_008_verifySearch() {

		try {
		menu = new Menupage();
		menu.clickonAuditRepository();
		menu.clickonSecurityAlerts();
		log.info("*****entered security alerts search page*****");
		sas = new SecurityAlertSearchpage();

		sas.clickSearchbtn();
		log.info("*****clicked search button*****");


		//AC02: Web Table is Populated 

		Boolean b = driver.findElement(By.xpath("//*[@id='resultData']/tbody")).isDisplayed();
		softAssert.assertTrue(b);	
					
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='resultData']/tbody/tr"));
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='resultData']/tbody/tr/td"));

		System.out.println("Rows are:" + rows.size());
		System.out.println("Cols are:" + cols.size());
		
		log.info("*****Rows & Cols Count *****");

		}	

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		softAssert.assertAll();
	}


	@AfterMethod
	public void tearDown() {

		driver.quit();
		log.info("***** BeHO_TC_008 Test case completed, Browser closed*****");
	}



}

