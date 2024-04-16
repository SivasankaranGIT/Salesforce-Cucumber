package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FrontlistUncheck {
	WebConnector selenium = WebConnector.getInstance();


	@Then("^the frontlist checkbox should be unchecked$")
	public void the_frontlist_checkbox_should_be_unchecked() {
		try {
			selenium.waitingTime(2000);
			boolean isSuccess = false;
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);	
			selenium.waitForElementToBeVisible("Frontlistcheck");
			String frontlist=selenium.getAttributeclass("Frontlistcheck");

			if (frontlist.contains("unchecked")) {
						isSuccess = true;	
			}
				} 
			if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "end");
			selenium.waitingTime(2000);	
			if (selenium.isElementPresentXpathFast(xpath))
						isSuccess = true;	
					} 
			selenium.printLastTestResult(isSuccess);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
				
	}
	
}
