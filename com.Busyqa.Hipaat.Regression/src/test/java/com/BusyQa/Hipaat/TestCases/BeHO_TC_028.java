package com.BusyQa.Hipaat.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectiveDetailpage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectivepage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to revoke all system directives ----
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




public class BeHO_TC_028 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SystemConsentDirectivepage scd;
	SystemConsentDirectiveDetailpage scddetail;
	
	public BeHO_TC_028() {
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
	public void TC_028_revokeall_systemConsentDir() {

		try {


		//1. Revoke all existing System Directives

		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickSystemDirective();

		scd = new SystemConsentDirectivepage();
		scd.activeListTab();
		
		
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='sort']/tbody/tr"));
		System.out.println("number of rows:" + rows.size());


		for (int i=0; i<rows.size(); i++) {
			
			driver.findElement(By.xpath("//tbody//tr//td//span/a")).click();
						
			scddetail = new SystemConsentDirectiveDetailpage();
			scddetail.revokebtn();
			scddetail.revokecontinuebtn();
			scddetail.backbtn();
			
			}

		// Verify no SD exists in table	
		
			String SD_pageSource = driver.getPageSource();
			softAssert.assertTrue(SD_pageSource.contains("No data available in table"));

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
		log.info("***** BeHO_TC_028 Test case completed, Browser closed*****");
	}
}




