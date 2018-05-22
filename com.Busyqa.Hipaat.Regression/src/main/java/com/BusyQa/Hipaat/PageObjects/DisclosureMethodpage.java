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
public class DisclosureMethodpage extends TestBaseClass {

	@FindBy(xpath="//td[@class='normal sorting_1']/input")
	@CacheLookup
	WebElement code;


	@FindBy(xpath = "//td[@class='normal'][1]/input")
	@CacheLookup
	WebElement description;

	@FindBy(xpath = "//input[@class='actionBtnSmall' and @title='Save']")
	@CacheLookup
	WebElement savebtn;



	public DisclosureMethodpage() {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver,this); //driver coming from Testbase class
	}


	public void enterCodevalue(String codevalue) {
		code.sendKeys(codevalue);

	}
	
	public void enterdescription(String desc) {
		description.sendKeys(desc);

	}


	public void clickSave() {
		savebtn.click();

	}


}
