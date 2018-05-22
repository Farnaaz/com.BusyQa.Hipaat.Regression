/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * This test case is testing the help in various pages - SECURITY
 *The test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 * The screenshot method will trigger in event of test case failure. 
 */ 

public class BeHO_TC_020 extends TestBaseClass {

	Loginpage login;
	Menupage menu;


	public BeHO_TC_020() {
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
	public void TC_020_verifyHelp_Security() {

		try {
		menu = new Menupage();
		menu.clickAdministration();
		menu.clickSecurity();
		menu.clickSystemUser();

		String page_title= driver.findElement(By.id("page-title-text")).getText();


		menu.clickHelp();

		log.info("*****entered Help page*****");


		Set<String> handles = driver.getWindowHandles();
		Iterator <String> it = handles.iterator();
		String parentWindowId = it.next();{System.out.println(parentWindowId);}
		String childWindowId = it.next();{System.out.println(parentWindowId);}

		driver.switchTo().window(childWindowId);

		String help_page_title = driver.findElement(By.id("_Toc484762156")).getText();

		softAssert.assertEquals(page_title, help_page_title); 

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
		log.info("***** BeHO_TC_020 Test case completed, Browser closed*****");
	}

	

}

