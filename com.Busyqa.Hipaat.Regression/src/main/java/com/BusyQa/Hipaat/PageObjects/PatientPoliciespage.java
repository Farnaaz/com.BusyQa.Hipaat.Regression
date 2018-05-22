/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class PatientPoliciespage extends TestBaseClass{

	@FindBy(id="detail:j_id_4w")
	@CacheLookup
	WebElement activeList;


	@FindBy(id="detail:j_id_51")
	@CacheLookup
	WebElement inactiveList;

	@FindBy(xpath="//input[contains(@type, 'button')]")
	@CacheLookup
	WebElement newUsing;

	@FindBy(id="inactivePoliciesResult:j_id_8t")
	@CacheLookup
	WebElement advanced;

	@FindBy(id="policiesResult:j_id_7p")
	@CacheLookup
	WebElement activetab_advanced;

		
	
	
	@FindBy(id="inactivePoliciesResult:j_id_8f:0:j_id_8h")
	@CacheLookup
	WebElement policyTitle;

	@FindBy(id="criteria:startDate")
	@CacheLookup
	WebElement sdate;

	@FindBy(id="criteria:search")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(id="policiesResult:j_id_78:0:j_id_7a")
	@CacheLookup
	WebElement policytitle;

	@FindBy(id="detail:j_id_5h")
	@CacheLookup
	WebElement testtab;
	
	@FindBy(name="test:j_id_b1")
	@CacheLookup
	WebElement privacyop;
	
	@FindBy(name="test:j_id_b9")
	@CacheLookup
	WebElement purposeofuse;
	
	@FindBy(xpath="//input[@type='text' and @value='Select Some Options']")
	@CacheLookup
	WebElement requestor_info;
	
		
	
	@FindBy(xpath="//input[@type='button' and @value='Add...']")
	@CacheLookup
	WebElement add_btn;
	
	@FindBy(id="test:j_id_bg:0:j_id_bi")
	@CacheLookup
	WebElement add_dpdw_provider;

	@FindBy(id="test:j_id_bg:2:j_id_bi")
	@CacheLookup
	WebElement add_dpdw_organization;

	@FindBy(xpath="//span[contains(@class, 'ui-button-text')] [contains(text(), 'Revoked')]")
	@CacheLookup
	WebElement validUntil_revoked;
	
	
	@FindBy(id="phi")
	@CacheLookup
	WebElement specifyPhi;
	
	@FindBy(id="override")
	@CacheLookup
	WebElement performOverride;
	
	@FindBy(id="test:overrideCodeObj")
	@CacheLookup
	WebElement Overridecode;
	
	
	
	@FindBy(id="test:checkBtn")
	@CacheLookup
	WebElement performCheckbtn;
	
	

	
	public PatientPoliciespage() {

		PageFactory.initElements(driver, this);
	}


	public void clickonactiveList() {

		activeList.click();
	}

	
	public void clickonTestTab() {

		testtab.click();
	}

	public void clickonOverridecode() {

		Overridecode.click();
		Select dropd = new Select(driver.findElement(By.id("test:overrideCodeObj")));
		dropd.selectByIndex(2);
		
	}

	
	public void clickonperformCheckbtn() {

		performCheckbtn.click();
	}

	
	public void clickonPrivacyOp(String type) {

		privacyop.sendKeys(type);
	}

	
	
	public void clickonPurposeofuse(String type) {

		purposeofuse.sendKeys(type);
	}

	public void clickRequestorInfo() {

		requestor_info.click();
	}

	public void Addbtn() {

		add_btn.click();
	}

	public void AddProvider() {

		add_dpdw_provider.click();
	}

	public void AddOrganization() {

		add_dpdw_organization.click();
	}

	
	public void SpecifyPhi() {

		specifyPhi.click();
	}
	public void performOverride() {

		performOverride.click();
	}
	public void clickonperformsdateCheckbtn() {

		performCheckbtn.click();
	}

	public void validUntil_revoked(){

		validUntil_revoked.click();
	}

	
	public void startdate(){
		
		sdate.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todaysdate = sdf.format(new Date());
		sdate.sendKeys(todaysdate);

	}


	public void clickonSearchbtn() {

		searchbtn.click();
	}

	public void clickonPolicyTitle() {

		policytitle.click();
	}

	public void clickoninactiveList() {

		inactiveList.click();
	}

	public void clickonnewUsing() {
		newUsing.click();

	}
	public void clickonadvanced() {
		advanced.click();
	}

	public void clickonactivetab_advanced() {
		activetab_advanced.click();
	}
	
	public void clickonpolicyTitleforrevoke() {
		policyTitle.click();
	}






}





