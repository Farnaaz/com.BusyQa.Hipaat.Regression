package com.BusyQa.Hipaat.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.*;


import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.OrganizationSelectpage;
import com.BusyQa.Hipaat.PageObjects.PatientPoliciespage;
import com.BusyQa.Hipaat.PageObjects.PatientPolicyDetailpage;
import com.BusyQa.Hipaat.PageObjects.PatientSearchpage;
import com.BusyQa.Hipaat.PageObjects.ProviderSelectpage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectiveDetailpage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectivepage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to create a deny policy with no system directive and perform check ----
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




public class BeHO_TC_025 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SystemConsentDirectivepage scd;
	SystemConsentDirectiveDetailpage scddetail;
	PatientSearchpage psearch;
	PatientPoliciespage ppolicies;
	PatientPolicyDetailpage ppdetail;
	ProviderSelectpage pselect;
	OrganizationSelectpage oselect;

	public BeHO_TC_025() {
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
	public void TC_025_systemConsentDir() {

		try {

			
			//1. verify that no System Directive exists 

			menu = new Menupage();
			menu.clickConsentmenu();
			menu.clickSystemDirective();

			scd = new SystemConsentDirectivepage();
			scd.activeListTab();
			
			String SD_pageSource = driver.getPageSource();

			softAssert.assertTrue(SD_pageSource.contains("No data available in table"));

			
			//1: Valid patient ID, patient is searched and opened 

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
			ppolicies.clickonnewUsing();
			ppolicies.clickonactivetab_advanced();

			ppdetail = new PatientPolicyDetailpage(); 		
			ppdetail.executefirst_No();
			ppdetail.startdate();
			ppdetail.validUntil_revoked();
			ppdetail.startdate();
			ppdetail.validUntil_revoked();
			ppdetail.policyTitle("This is a deny policy");
			ppdetail.requestedby_Patient();
			ppdetail.purposeofuse_All();
			ppdetail.addDirectiveUsing();
			ppdetail.advanced();
			ppdetail.privacyOperation("Use");
			ppdetail.directiveType("Directive Outcome");
			ppdetail.directiveOutcome("Deny");
			ppdetail.directiveTitlebox("Deny Outcome Policy");
			ppdetail.requestorbtn_specify();
			ppdetail.providerdropdown("Exclude List");
			ppdetail.addProviderbtn();

			pselect = new ProviderSelectpage();	
			pselect.internalID();
			pselect.ID("drbob");
			pselect.searchbtn();
			pselect.checkbox();
			pselect.returnSelected();
			log.info("*****provider has been added*****");

			ppdetail.Specifytophi_All();
			ppdetail.donebtn();

			ppdetail.savebtn();
			log.info("*****saved button clicked*****");

			ppdetail.entersavecomment("demo purpose");
			ppdetail.continuebtn();
			log.info("*****comment saved *****");

			// A Policy Saved Successfully message will be displayed

			String expected_message="Policy was saved successfully.";
			String actual_message = driver.findElement(By.id("infoMessagesDialog")).getText();
			softAssert.assertEquals(expected_message, actual_message);
			ppdetail.activatebtn();
			log.info("***** policy activated *****");
			ppdetail.ClickBackbtn();

			// Verify created Policy is displayed in policy table	


			String pageSource = driver.getPageSource();

			softAssert.assertTrue(pageSource.contains("This is a deny policy"));

			
			ppolicies = new PatientPoliciespage();	
			ppolicies.clickonTestTab();
			ppolicies.clickonPrivacyOp("Use");
			ppolicies.clickonPurposeofuse("Public Health");
			ppolicies.clickRequestorInfo();
			ppolicies.Addbtn();
			ppolicies.AddOrganization();

			oselect = new OrganizationSelectpage();
			oselect.enterName("Hamilton General");
			oselect.enterMunicipality("Hamilton");
			oselect.clickSearchbtn();
			oselect.clickCheckbox();
			oselect.clickReturnselectedbtn();

			ppolicies = new PatientPoliciespage();	
			ppolicies.Addbtn();
			ppolicies.AddProvider();

			pselect = new ProviderSelectpage ();
			pselect.internalID();
			pselect.ID("drbob");
			pselect.searchbtn();
			pselect.checkbox();
			pselect.returnSelected();

			ppolicies = new PatientPoliciespage();	
			ppolicies.clickonperformCheckbtn();


			String expected_message1="Use of PHI is NOT allowed.";		
			String actual_message1 = driver.findElement(By.xpath("//div[@id='responseDialog']//span")).getText();

			softAssert.assertEquals(expected_message1, actual_message1);

			//revoking the policy created.
			ppolicies = new PatientPoliciespage();
			ppolicies.clickonactiveList();

			driver.findElement(By.xpath("//span/a[contains(text(), 'This is a deny policy')]")).click();
			ppdetail = new PatientPolicyDetailpage();
			ppdetail.revokebtn();
			ppdetail.revokecontinuebtn();
			ppdetail.ClickBackbtn();

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
		log.info("***** BeHO_TC_025 Test case completed, Browser closed*****");
	}



}

