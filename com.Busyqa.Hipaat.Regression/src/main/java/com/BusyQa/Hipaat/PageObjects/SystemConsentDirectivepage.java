/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class SystemConsentDirectivepage extends TestBaseClass{

	@FindBy(id="detail:j_id_4p")
	@CacheLookup
	WebElement activeList;
	
	@FindBy(xpath="//input[@type='button' and @value='New Using...']")
	@CacheLookup
	WebElement newusingbtn;
	
	@FindBy(id="activeResult:j_id_77")
	@CacheLookup
	WebElement advanced;
	
	

public SystemConsentDirectivepage() {

	PageFactory.initElements(driver, this);
}



public void activeListTab() {
	activeList.click();
	
	}


public void clickNewusingbtn() {
	newusingbtn.click();
	
	
}


public void clickAdvanced() {
	
	advanced.click();
	
	
}



}