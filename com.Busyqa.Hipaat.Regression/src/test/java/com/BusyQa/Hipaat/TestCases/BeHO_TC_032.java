package com.BusyQa.Hipaat.TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.BusyQa.Hipaat.PageObjects.Categorycodepage;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;


/**
 * @author Farnaaz
 * ---This testcase ensures that values can be added and deleted in Category Code page -----
 *
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 * Logger class is used to generate custom logs
 *The screenshot method will trigger in event of test case failure.
 */ 




public class BeHO_TC_032 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	Categorycodepage category;


	public BeHO_TC_032() {
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
	public void TC_032_categorycode() {

		try {
			menu = new Menupage();
			menu.clickAdministration();
			menu.clickListmaintenance();
			menu.clickConsentlist();
			menu.clickCategorycode();
			log.info("*****entered Category code page*****");

			//AC01: Values will be added to Category code table as TEST123
			category = new Categorycodepage();
			
			List <WebElement> initial_row_count = driver.findElements(By.xpath("//table[@id='listResult']//tbody//tr"));
			System.out.println("Number of rows before adding the value is:::" + initial_row_count.size());

			category.enterCodevalue("TEST123");
			category.enterCodesystem("2.16.840.1.113883.5.4");
			category.enterdisplayname("this is for testing purpose");
			category.clickSave();
			driver.navigate().refresh();
			log.info("*****value added in purpose of use table *****");

			//verifies table row has been added 
			
			List <WebElement> new_row_count = driver.findElements(By.xpath("//*[@id='listResult']//tbody//tr"));
			System.out.println("Number of rows after adding the value is:::" + new_row_count.size());

			
			String pageSource = driver.getPageSource();
			softAssert.assertTrue(pageSource.contains("TEST123"));
			
					
	
			Thread.sleep(2000);
		
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
		log.info("***** BeHO_TC_032 Test case completed, Browser closed*****");
	}
 

}

