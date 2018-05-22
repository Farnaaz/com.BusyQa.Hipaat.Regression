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
public class ClinicalMetadatapage extends TestBaseClass {

	@FindBy(xpath="//td[@class='normal sorting_1']/input")
	@CacheLookup
	WebElement code;


	@FindBy(xpath = "//td[@class='normal'][1]/input")
	@CacheLookup
	WebElement label;

	@FindBy(xpath = "//td[@class='normal'][2]//div//select")
	@CacheLookup
	WebElement inputtype;

	@FindBy(xpath = "//td[@class='normal'][4]//div//select")
	@CacheLookup
	WebElement predecessor;

		
	@FindBy(xpath = "//input[@class='actionBtnSmall' and @title='Save']")
	@CacheLookup
	WebElement savebtn;

	

	public ClinicalMetadatapage() {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver,this); //driver coming from Testbase class
	}


	public void enterCodevalue(String codevalue) {
		code.sendKeys(codevalue);

	}
	
	public void enterLabel(String lbl) {
		label.sendKeys(lbl);

	}

	public void enterinputtype(String input) {
		inputtype.sendKeys(input);

	}

	public void enterPredecessor(String pred) {
		predecessor.sendKeys(pred);

	}

	
	public void clickSave() {
		savebtn.click();

	}

	
}
