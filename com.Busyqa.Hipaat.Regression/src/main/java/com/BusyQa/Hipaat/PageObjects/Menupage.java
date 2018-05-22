package com.BusyQa.Hipaat.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * This page object class will store all webelements and actions 
 * related to homepage. 
 *
 */

public class Menupage extends TestBaseClass {


	@FindBy(id="appMenu:j_id_j")
	@CacheLookup
	WebElement consentmenu;

	@FindBy(id = "appMenu:j_id_s")
	@CacheLookup
	WebElement systemDirective;


	@FindBy(id = "appMenu:j_id_m")
	@CacheLookup
	WebElement management;

	@FindBy(id = "appMenu:j_id_1n")
	@CacheLookup
	WebElement administration;

	@FindBy(id = "appMenu:j_id_1s")
	@CacheLookup
	WebElement security;

	@FindBy(id = "appMenu:j_id_1u")
	@CacheLookup
	WebElement systemuser;



	@FindBy(id = "appMenu:j_id_20")
	@CacheLookup
	WebElement listmaintainence;

	@FindBy(id = "appMenu:j_id_24")
	@CacheLookup
	WebElement consentLists;

	@FindBy(id = "appMenu:j_id_26")
	@CacheLookup
	WebElement purposeofuse;

	@FindBy(id = "appMenu:j_id_28")
	@CacheLookup
	WebElement entitytype;

	@FindBy(id = "appMenu:j_id_2a")
	@CacheLookup
	WebElement overridereason;

	@FindBy(id = "appMenu:j_id_2c")
	@CacheLookup
	WebElement disclosuremethod;

	@FindBy(id = "appMenu:j_id_2e")
	@CacheLookup
	WebElement categorycode;

	@FindBy(id = "appMenu:j_id_2g")
	@CacheLookup
	WebElement confidentialitycode;

	@FindBy(id = "appMenu:j_id_2i")
	@CacheLookup
	WebElement assigningauthoritytype;

	@FindBy(id = "appMenu:j_id_2k")
	@CacheLookup
	WebElement assigningauthority;

	@FindBy(id = "appMenu:j_id_2m")
	@CacheLookup
	WebElement clinicalmetadata;


	@FindBy(id= "appMenu:j_id_1e")
	@CacheLookup
	WebElement auditRepository;

	@FindBy(id= "appMenu:j_id_13")
	@CacheLookup
	WebElement report;

	@FindBy(id= "appMenu:j_id_18")
	@CacheLookup
	WebElement auditreports;

	@FindBy(id= "appMenu:j_id_46")
	@CacheLookup
	WebElement sessionmanagement;




	@FindBy(id= "appMenu:j_id_16")
	@CacheLookup
	WebElement policyreports;


	@FindBy(id= "appMenu:j_id_1h")
	@CacheLookup
	WebElement securityalerts;

	@FindBy(xpath= "//div[@class='menuText' and contains(text(), 'Help')]")
	@CacheLookup
	WebElement help;



	public Menupage() {

		PageFactory.initElements(driver, this);
	}



	public void clickConsentmenu() {

		Actions act= new Actions(driver);
		act.moveToElement(consentmenu).build().perform();
	}

	public void clickSystemDirective() {


		systemDirective.click();

	}
	public void clickManagement() {


		management.click();

	}


	public void clickAdministration() {

		Actions act= new Actions(driver);
		act.moveToElement(administration).build().perform();

	}

	public void clickSessionManagement() {

		sessionmanagement.click();	
	}

	public void clickListmaintenance() {

		Actions act= new Actions(driver);
		act.moveToElement(listmaintainence).build().perform();

	}

	public void clickConsentlist() {

		Actions act= new Actions(driver);
		act.moveToElement(consentLists).build().perform();

	}

	public void clickPurposeofuse() {

		Actions act= new Actions(driver);
		act.moveToElement(purposeofuse).build().perform();
		purposeofuse.click();
	}

	public void clickEntitytype() {

		Actions act= new Actions(driver);
		act.moveToElement(entitytype).build().perform();
		entitytype.click();
	}

	public void clickOverridereason() {

		Actions act= new Actions(driver);
		act.moveToElement(overridereason).build().perform();
		overridereason.click();
	}

	public void clickDisclosuremethod() {

		Actions act= new Actions(driver);
		act.moveToElement(disclosuremethod).build().perform();
		disclosuremethod.click();
	}

	public void clickCategorycode() {

		Actions act= new Actions(driver);
		act.moveToElement(categorycode).build().perform();
		categorycode.click();
	}

	public void clickConfidentialitycode() {

		Actions act= new Actions(driver);
		act.moveToElement(confidentialitycode).build().perform();
		confidentialitycode.click();
	}

	public void clickAssigningauthoritytype() {

		Actions act= new Actions(driver);
		act.moveToElement(assigningauthoritytype).build().perform();
		assigningauthoritytype.click();
	}

	public void clickAssigningauthority() {

		Actions act= new Actions(driver);
		act.moveToElement(assigningauthority).build().perform();
		assigningauthority.click();
	}

	public void clickClinicalmetadata() {

		Actions act= new Actions(driver);
		act.moveToElement(clinicalmetadata).build().perform();
		clinicalmetadata.click();
	}




	public void clickonAuditRepository() {

		Actions act= new Actions(driver);
		act.moveToElement(auditRepository).build().perform();

	}


	public void clickonreport() {

		Actions act= new Actions(driver);
		act.moveToElement(report).build().perform();

	}


	public void clickonPolicyreports() {

		policyreports.click();
	}


	public void clickonAuditreports() {

		auditreports.click();
	}


	public void clickonSecurityAlerts() {


		securityalerts.click();
	}


	public void clickSecurity() {


		Actions act= new Actions(driver);
		act.moveToElement(security).build().perform();

	}

	public void clickSystemUser() {


		systemuser.click();
	}

	public void clickHelp() {

		help.click();
	}

}

