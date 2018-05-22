package com.BusyQa.Hipaat.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.OrganizationSelectpage;
import com.BusyQa.Hipaat.PageObjects.PatientPoliciespage;
import com.BusyQa.Hipaat.PageObjects.PatientSearchpage;
import com.BusyQa.Hipaat.PageObjects.ProviderSelectpage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectiveDetailpage;
import com.BusyQa.Hipaat.PageObjects.SystemConsentDirectivepage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is check if active SD execute first is returned for patient ID with no active policy ----
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 *Logger class is used to generate custom logs
 *The screenshot method will trigger in event of test case failure.
 * 
 *
 */ 




public class BeHO_TC_019 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SystemConsentDirectivepage scd;
	SystemConsentDirectiveDetailpage scddetail;
	PatientSearchpage psearch;
	PatientPoliciespage ppolicies;
	ProviderSelectpage pselect;
	OrganizationSelectpage oselect;

	public BeHO_TC_019() {
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
	public void TC_019_systemConsentDir() {

		try {

		//AC01: Execute first system directive created
		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickSystemDirective();

		scd = new SystemConsentDirectivepage();
		scd.activeListTab();
		scd.clickNewusingbtn();
		scd.clickAdvanced();

		scddetail = new SystemConsentDirectiveDetailpage(); 
		scddetail.clickExecutefirst_Yes();
		scddetail.startdate();
		scddetail.validUntil_revoked();
		scddetail.privacyOperation("Use");
		scddetail.directiveType("Directive Outcome");
		scddetail.directiveOutcome("Allow");
		scddetail.directiveTitlebox("this is allow policy");
		scddetail.purposeofuse_All();
		scddetail.requestorbtn_specify();
		scddetail.providerdropdown("Exclude list");
		scddetail.addProviderbtn();

		pselect = new ProviderSelectpage();
		pselect.internalID();
		pselect.ID("drbob");
		pselect.searchbtn();
		pselect.checkbox();
		pselect.returnSelected();

		scddetail = new SystemConsentDirectiveDetailpage(); 
		scddetail.Specifytophi_All();
		scddetail.savebtn();
		scddetail.entersavecomment("test");
		scddetail.continuebtn();
		scddetail.activatebtn();

		String expected_savemessage= "Message has been sent successfully to Consent Validation to reload the system directive cache.";
		String actual_savemessage = driver.findElement(By.xpath("//*[@id='infoMessagesDialog']//td[contains(@class, 'infoMessages')]")).getText();
		System.out.println("******Message is : " + actual_savemessage);
		softAssert.assertEquals(expected_savemessage, actual_savemessage);	

		scddetail.backbtn();

		// Valid patient ID with no active policy, check if active SD execute first returned

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
		ppolicies.clickonTestTab();
		ppolicies.clickonPrivacyOp("Disclosure");
		ppolicies.clickonPurposeofuse("Hospital Research");
		ppolicies.Addbtn();
		ppolicies.AddProvider();
		log.info("*****provider has been added*****");

		pselect = new ProviderSelectpage();	
		pselect.internalID();
		pselect.ID("drbob");
		pselect.searchbtn();
		pselect.checkbox();
		pselect.returnSelected();
		log.info("*****provider has been added*****");

		ppolicies = new PatientPoliciespage();	
		ppolicies.clickRequestorInfo();
		ppolicies.Addbtn();
		ppolicies.AddOrganization();
		oselect = new OrganizationSelectpage();	
		oselect.enterName("Hamilton General");
		oselect.enterMunicipality("Hamilton");
		oselect.clickSearchbtn();
		oselect.clickCheckbox();
		oselect.clickReturnselectedbtn();
		log.info("*****organization has been added*****");

		ppolicies = new PatientPoliciespage();	
		ppolicies.clickonperformsdateCheckbtn();

		String actual_message = driver.findElement(By.xpath("//tbody[@id='test:j_id_d5:tbody_element']/tr/td[2]/span")).getText();

		System.out.println(actual_message);

		String expected_message="No patient or system consent was applied to this decision.";

		softAssert.assertEquals(expected_message, actual_message);


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
		log.info("***** BeHO_TC_019 Test case completed, Browser closed*****");
	}




}
