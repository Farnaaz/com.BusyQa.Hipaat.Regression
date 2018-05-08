/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;



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
 * -----This test case is testing Active Policies Report can be generated  ------
 * The test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 * The screenshot method will trigger in event of test case failure. 
 */ 


public class BeHO_TC_016 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	PolicyReportspage pr;
	PatientSelectpage ps;

	

	public BeHO_TC_016() {
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
	public void TC_016_ActivePoliciesReport() {

		try {
		menu = new Menupage();
		menu.clickonreport();
		menu.clickonPolicyreports();
		log.info("*****entered Policy Reports page*****");

		pr = new PolicyReportspage();
		pr.clickActivepolicies();
		pr.activepoliciesSelectbtn();


		ps= new PatientSelectpage();
		ps.InternalID();
		ps.pID("BQ0001");
		ps.clickonSearchbtn();
		ps.clickcheckbox();
		ps.clickreturnselectedbtn();
		log.info("*****added patient button*****");


		pr = new PolicyReportspage();

		//AC01: No Error Message generated
		boolean error =  driver.getPageSource().contains("error");
		//System.out.println(error);
		Assert.assertFalse(error);
				
		//AC02: Report generated
		pr.clickGenerateReportbtn();
		pr.AP_pdfversion();
		
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
		log.info("***** BeHO_TC_016 Test case completed, Browser closed*****");
	}

	

}

