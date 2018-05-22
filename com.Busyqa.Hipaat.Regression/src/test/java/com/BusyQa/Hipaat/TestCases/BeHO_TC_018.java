/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;


import org.testng.annotations.*;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SessionManagementpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is tesing the session management does not have any Base53 errors ------
 * The test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 * The screenshot method will trigger in event of test case failure. 
 */ 


public class BeHO_TC_018 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	SessionManagementpage sm;


	public BeHO_TC_018() {
		super();
	}

	@BeforeMethod
	public void setUp() {


		browserinitialization(); 
		log.info("*****browser is successfully initialised*****");

		login=new Loginpage();	
		login.Login(pro.getProperty("UserID"), pro.getProperty("Password"), pro.getProperty("Facility"));
		log.info("*****login is successfully done*****");
	}
	@Test
	public void TC_018_verifybase53Error() {
		try {
			menu = new Menupage();
			menu.clickAdministration();
			menu.clickSessionManagement();
			log.info("*****entered session management page *****");

			sm = new SessionManagementpage();


			sm.clearerrormssg();
			log.info("*****clear error messages button clicked *****");

			//AC01: No Error Message generated
			boolean error =  driver.getPageSource().contains("error");
			//System.out.println(error);
			softAssert.assertFalse(error);
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
		log.info("***** BeHO_TC_018 Test case completed, Browser closed*****");
	}



}

