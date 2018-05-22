/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class SystemConsentDirectiveDetailpage extends TestBaseClass {



	@FindBy(xpath="//span[contains (@class, 'ui-button-text')] [contains(text(), 'Yes')]")
	@CacheLookup
	WebElement execute_first_Yesbtn;

	@FindBy(id="detail:startDate1")
	@CacheLookup
	WebElement sdate;

	@FindBy(xpath="//span[contains(@class, 'ui-button-text')] [contains(text(), 'Revoked')]")
	@CacheLookup
	WebElement validUntil_revoked;

	@FindBy(id="detail:privacyOperation")
	@CacheLookup
	WebElement privacyOperation;

	@FindBy(id="detail:directiveType")
	@CacheLookup
	WebElement directiveType;

	@FindBy(id="detail:outcome")
	@CacheLookup
	WebElement directiveOutcome;

	@FindBy(id="detail:cdTitle")
	@CacheLookup
	WebElement directiveTitlebox;

	@FindBy(xpath="//div[@id='pouRadio']//span[contains(text(), 'All')]")
	@CacheLookup
	WebElement pofuse_All_btn;

	@FindBy(xpath="//div[@id='pouRadio']/label[2]/span")
	@CacheLookup
	WebElement pofuse_specify_btn;
	
	@FindBy(xpath="//div[@id = 'appliesToRadio']//span[contains(@class, 'ui-button-text')] [contains(text(), 'All')]")
	@CacheLookup
	WebElement appli_requestorbtn_All;

	@FindBy(xpath="//div[@id = 'appliesToRadio']//span[contains(@class, 'ui-button-text')] [contains(text(), 'Specify')]")
	@CacheLookup
	WebElement appli_requestorbtn_specify;

	@FindBy(name="detail:j_id_6x:0:j_id_71")
	@CacheLookup
	WebElement providerdropdown;

	@FindBy(id="detail:j_id_6x:0:j_id_77")
	@CacheLookup
	WebElement addProviderbtn;


	@FindBy(xpath="//div[@id='phiGranularityRadio']/div[1]/label/span[text()='All']")
	@CacheLookup
	WebElement Specifyphi_All;

	@FindBy(id="directiveDetail:doneBtn")
	@CacheLookup
	WebElement donebtn;

	@FindBy(id="detail:saveBtn")
	@CacheLookup
	WebElement savebtn;

	@FindBy(id="save-comment")
	@CacheLookup
	WebElement savecomment;

	@FindBy(id="save-comment-btn-continue")
	@CacheLookup
	WebElement continuebtn;

	@FindBy(id="detail:activateBtn")
	@CacheLookup
	WebElement activatebtn;

	@FindBy(id="detail:j_id_9f")
	@CacheLookup
	WebElement revokebtn;
	
	@FindBy(id="revoke-comment-btn-continue")
	@CacheLookup
	WebElement revokebtn_continue;
	
	@FindBy(xpath="//button[@id='revoke-comment-btn-cancel']/span")
	@CacheLookup
	WebElement cancel;
	
	@FindBy(id="detail:cancelSystemBtn2")
	@CacheLookup
	WebElement backbtn;
	
	
	
	
		

	

	public SystemConsentDirectiveDetailpage() {

		PageFactory.initElements(driver, this);
	}


	public void clickExecutefirst_Yes(){
		execute_first_Yesbtn.click();
	}

	public void startdate(){
	
		sdate.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todaysdate = sdf.format(new Date());
		sdate.sendKeys(todaysdate);

	}


	public void validUntil_revoked(){

		validUntil_revoked.click();
	}

	
	public void purposeofuse_All(){


		pofuse_All_btn.click();
	}


	public void purposeofuse_Specify(){

		pofuse_specify_btn.click();
	}

	public void appli_requestorbtn_All() {
		appli_requestorbtn_All.click();
	}


	public void privacyOperation(String privacy) {
		privacyOperation.sendKeys(privacy);

	}

	public void directiveType(String type) {
		directiveType.sendKeys(type);
	}


	public void directiveOutcome(String outcome) {
		directiveOutcome.sendKeys(outcome);
	}

	public void directiveTitlebox(String dtitle) {
		directiveTitlebox.sendKeys(dtitle);
	}

	public void requestorbtn_specify() {
		appli_requestorbtn_specify.click();
	}
	public void providerdropdown(String exclude) {
		providerdropdown.sendKeys(exclude);
	}
	public void addProviderbtn() {

		addProviderbtn.click();
	}

	public void Specifytophi_All() {

		Specifyphi_All.click();

	}

	public void donebtn() {
		donebtn.click();
	}

	public void savebtn() {
		savebtn.click();
	}

	public void entersavecomment(String comment) {

		savecomment.sendKeys(comment);	
	}

	public void continuebtn() {


		continuebtn.click();
	}

	public void activatebtn() {


		activatebtn.click();
	}


	public void revokebtn() {


		revokebtn.click();
	}

	public void revokecontinuebtn() {


		revokebtn_continue.click();
	}

	
	public void cancelbtn() {


		cancel.click();
	}

	public void backbtn() {


		backbtn.click();
	}


}




