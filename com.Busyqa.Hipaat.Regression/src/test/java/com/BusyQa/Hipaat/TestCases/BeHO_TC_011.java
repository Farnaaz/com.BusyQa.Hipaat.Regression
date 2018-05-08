/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.PatientSelectpage;
import com.BusyQa.Hipaat.PageObjects.PolicyReportspage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * ----- This test case is verifying if reports can be Scheduled in the Policy Management Report. ----
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 * The screenshot method will trigger in event of test case failure.
 * 
 *
 */ 

public class BeHO_TC_011 extends TestBaseClass{
		
		Loginpage login;
		Menupage menu;
		PolicyReportspage pr;
		PatientSelectpage ps;
		
		
		public BeHO_TC_011() {
			super();
			log.info("*****parent class constructor called and properties file initiated*****");
		}

		@BeforeTest
		public void setUp() {

			browserinitialization(); 
			log.info("*****browser is successfully initialised*****");

			login = new Loginpage();
			login.Login(pro.getProperty("UserID"), pro.getProperty("Password"), pro.getProperty("Facility"));
			log.info("*****login is successfully done*****");
		}

		@Test 
		public void TC_011_verifyScheduling() {

			try {
			menu = new Menupage();
			menu.clickonreport();
			menu.clickonPolicyreports();
			log.info("*****entered Policy Reports page*****");
			
			pr = new PolicyReportspage();
			pr.clickpolicymanagement();
			pr.patientSelectbtn();
			
			
			 ps= new PatientSelectpage();
			 ps.InternalID();
			 ps.pID("BQ0001");
			 ps.clickonSearchbtn();
			 ps.clickcheckbox();
			 ps.clickreturnselectedbtn();
			log.info("*****added patient button*****");

	
			pr = new PolicyReportspage();
			pr.clickSchdParameters();
			pr.SchedReportdescription("demo");
			pr.recipientemail("abc@gmail.com");
			pr.clickScheduleReportBtn();
			pr.PM_pdfversion();
			
			//AC01: Message Box Displayed
			String expected_message = "Your report has been scheduled. You will be notified when it is completed.";
			
			String actual_message = driver.findElement(By.xpath("//*[@id='infoMessagesDialog']//td[contains(@class, 'infoMessages')]")).getText();
			System.out.println("******Message is : " + actual_message);
			Assert.assertEquals(expected_message, actual_message);	
			
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
			log.info("***** BeHO_TC_011 Test case completed, Browser closed*****");
		}


	}

