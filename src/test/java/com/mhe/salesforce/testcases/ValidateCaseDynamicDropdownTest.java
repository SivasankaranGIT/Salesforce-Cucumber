package com.mhe.salesforce.testcases;

import org.junit.Assert;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ValidateCaseDynamicDropdownTest 
{
	WebConnector selenium = WebConnector.getInstance();
	
	 @When("^I navigate to case tab$")
	    public void i_navigate_to_case_tab() 
	    
	 {		 
		 try 
			 {			 
//				 	selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.type("searchItemsTextField", "Cases");
//					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("casesOptionMenuDots");
					selenium.jsClick("casesOptionMenuDots");
					selenium.waitingTime(3000);
			 }
		 
		 catch (Exception e) 
		 	{				
				selenium.reportFailure("Error while navigating to cases tab " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @When("^I click on new case option$")
	    public void i_click_on_new_case_option() 
	    
	 {		 
		 try 
		 {	 
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.click("NewButtonToAdd");
			selenium.waitingTime(2000);
			String recordType = selenium.getDynamicXpath("spantextContains", "Record Type", "endContains");
			selenium.waitingTime(4000);
			selenium.clickXpath(recordType);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			selenium.test.log(LogStatus.INFO, "Navigated successfully to New Case Page!");
		 }
		 
		 catch (Exception e) 
		 	{				
				selenium.reportFailure("Error while creating new case " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @And("^Validate dynamic dropdown fields$")
	 public void validate_dynamic_dropdown_fields()
	 {
	 try
	 {
	 selenium.dynamicvalues();
	 selenium.test.log(LogStatus.INFO, "Dropdown fields are having correct data!");
	 }

	 catch (Exception e)
	 {

	 Assert.assertTrue(true);
	 selenium.reportFailure("Error while validating dropdown list values" + e.getMessage());
	 }
	 }

}
