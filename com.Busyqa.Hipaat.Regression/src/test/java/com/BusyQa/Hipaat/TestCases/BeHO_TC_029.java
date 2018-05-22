package com.BusyQa.Hipaat.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;

import com.BusyQa.Hipaat.PageObjects.PatientPoliciespage;
import com.BusyQa.Hipaat.PageObjects.PatientPolicyDetailpage;
import com.BusyQa.Hipaat.PageObjects.PatientSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to revoke all active policies ----
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




public class BeHO_TC_029 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	PatientSearchpage psearch;
	PatientPoliciespage ppolicies;
	PatientPolicyDetailpage ppdetail;
	
	public BeHO_TC_029() {
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
	public void TC_029_revokeall_activepolicies() {

		try {


		
		// revoke all active policies 

		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickManagement();
		log.info("*****Consent menu clicked*****");

		psearch= new PatientSearchpage() ;
		psearch.InternalID();
		psearch.pID("BQ0001");
		psearch.clickonSearchbtn();
		psearch.clickonSearchresult();
		log.info("*****patient search is done*****");

		ppolicies = new PatientPoliciespage();	
		ppolicies.clickonactiveList();
		
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='sort']/tbody/tr"));
		System.out.println("number of rows:" + rows.size());


		for (int i=0; i<rows.size(); i++) {
			
			driver.findElement(By.xpath("//tbody//tr//td//span/a")).click();
			
			ppdetail = new PatientPolicyDetailpage();
			ppdetail.revokebtn();
			ppdetail.revokecontinuebtn();
			ppdetail.ClickBackbtn();
		}

		// Verify no active policy exists in table	
		
			String AP_pageSource = driver.getPageSource();
			softAssert.assertTrue(AP_pageSource.contains("No data available in table"));

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
		log.info("***** BeHO_TC_029 Test case completed, Browser closed*****");
	}
}




