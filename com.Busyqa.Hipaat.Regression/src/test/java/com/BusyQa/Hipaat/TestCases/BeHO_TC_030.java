package com.BusyQa.Hipaat.TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.OverrideReasonpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;


/**
 * @author Farnaaz
 * ---This testcase ensures that values can be added and deleted in Override Reason page -----
 *
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 *The screenshot method will trigger in event of test case failure.
 */ 




public class BeHO_TC_030 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	OverrideReasonpage override;


	public BeHO_TC_030() {
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
	public void TC_030_overridereason() {

		try {
			menu = new Menupage();
			menu.clickAdministration();
			menu.clickListmaintenance();
			menu.clickConsentlist();
			menu.clickOverridereason();
			log.info("*****entered override reason page*****");

			//AC01: Values will be added to override reason table as TEST123
			override = new OverrideReasonpage();
			
			List <WebElement> initial_row_count = driver.findElements(By.xpath("//table[@id='listResult']//tbody//tr"));
			System.out.println("Number of rows before adding the value is:::" + initial_row_count.size());

			override.enterCodevalue("TEST123");
			override.enterdescription("test1");
			override.enterdisplayname("this is for testing purpose");
			override.clickSave();
			driver.navigate().refresh();
			log.info("*****value added in purpose of use table *****");

			//verifies table row has been added 
			
			List <WebElement> new_row_count = driver.findElements(By.xpath("//*[@id='listResult']//tbody//tr"));
			System.out.println("Number of rows after adding the value is:::" + new_row_count.size());

			
			String pageSource = driver.getPageSource();
			softAssert.assertTrue(pageSource.contains("TEST123"));
			
					
	
			Thread.sleep(1000);
		
			//deletes the added row
			driver.findElement(By.xpath("//span[text()='TEST123']//parent::td/following-sibling::td[4]//div//input[@title='Delete']")).click();
			driver.findElement(By.xpath("//button[1]")).click();
			System.out.println("Row deleted");
	
			
		}	

		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		log.info("***** BeHO_TC_030 Test case completed, Browser closed*****");
	}
	 

}

