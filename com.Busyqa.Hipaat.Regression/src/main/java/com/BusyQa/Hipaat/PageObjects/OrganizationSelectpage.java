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
public class OrganizationSelectpage extends TestBaseClass{



		@FindBy(id="criteria:name2")
		@CacheLookup
		WebElement name;

		@FindBy(id="criteria:addrCity2")
		@CacheLookup
		WebElement municipality;

		@FindBy(id="criteria:search")
		@CacheLookup
		WebElement searchbtn;

		@FindBy(xpath="//table[@id='resultData']/tbody/tr//label")
		@CacheLookup
		WebElement checkbox;

		@FindBy(id = "result:returnBtn")
		@CacheLookup
		WebElement returnselected;
		
		
	

		public OrganizationSelectpage() {

			PageFactory.initElements(driver, this);
		}


		
		public void enterName(String oname) {

			name.sendKeys(oname);

		}	
		public void enterMunicipality(String munc) {

			municipality.sendKeys(munc);
			
		}
			
		public void clickSearchbtn() {
			searchbtn.click();
		}
		
		public void clickCheckbox() {
			checkbox.click();
		}
			
		public void clickReturnselectedbtn() {
			returnselected.click();
		}



			
			

		}



