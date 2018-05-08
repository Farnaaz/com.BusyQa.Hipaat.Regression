/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.AuditReportpage;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is testing the Basic Audit Report can be generated  ------
 * The test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 * The screenshot method will trigger in event of test case failure. 
 */ 


public class BeHO_TC_017 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	AuditReportpage ar;



	public BeHO_TC_017() {
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
	public void TC_017_auditReport() {
		try {
			menu = new Menupage();
			menu.clickonreport();
			menu.clickonAuditreports();
			log.info("*****entered Audit Reports page*****");

			ar = new AuditReportpage();
			ar.clickFrequentCriteria();
			ar.clickPatientdropdown();
			ar.SelectRandomPatient();
			ar.clickUserdropdown();
			ar.SelectRandomuser();
			ar.clickEventDate();
			ar.selectPreviousMonth();

			//AC01: No Error Message generated
			boolean error =  driver.getPageSource().contains("error");
			//System.out.println(error);
			Assert.assertFalse(error);


			ar.generateReportbtn();
			ar.AR_pdfReport();

			String path = System.getProperty("C://Users//Farnaaz//Downloads") + "/AuditPatientAccess.rptdesign-20180429190033.pdf";

			File f = new File("C://Users//Farnaaz//Downloads//AuditPatientAccess.rptdesign-20180429190033.pdf");


			if (f.exists()) {
				System.out.println("File Location:" +path.toString());
				System.out.println("file exists");
			} else {System.out.println("file does not exist");}
			

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
		log.info("***** BeHO_TC_017 Test case completed, Browser closed*****");
	}

		 

	}

