/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;


import org.openqa.selenium.By;
import org.testng.annotations.*;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertDetailpage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to testing Search is returning values in the Security Alert Page & security alert is acknowledged----
 * This testcase is to testing Search is returning values in the Security Alert Page ----
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


public class BeHO_TC_009 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SecurityAlertSearchpage sas;
	SecurityAlertDetailpage sad;


	public BeHO_TC_009() {
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
	public void TC_009_verifyacknowldg() {
		try {
			menu = new Menupage();
			menu.clickonAuditRepository();
			menu.clickonSecurityAlerts();
			log.info("*****entered security alerts search page*****");
			sas = new SecurityAlertSearchpage();

			sas.clickSearchbtn();
			log.info("*****clicked search button*****");

			//first security message is checked
			sas.messageID_Num();
			log.info("*****message id checked*****");


			sad = new SecurityAlertDetailpage();				
			String expected_title = "Security Alert Detail";
			String actual_page_title = driver.findElement(By.id("page-title-text")).getText();

			softAssert.assertEquals(expected_title, actual_page_title);

			//security alert is acknowledged
			sad.Acknowledgebtn();		
			log.info("*****clicked acknowledged button*****");

			//check security alert is removed from table
			sad.Backbtn();
			log.info("*****clicked back button*****");

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
		log.info("***** BeHO_TC_009 Test case completed, Browser closed*****");
	}



}

