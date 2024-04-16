package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidatecontactRegion {
	WebConnector selenium = WebConnector.getInstance();
	String accountHubcountrycode = null;

@When("^I Fetch account Hub country code details$")
public void i_Fetch_account_country_details() {
	try {
	if (selenium.getUI().equalsIgnoreCase("lightning")) {
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "Clicking account country");
		selenium.waitForElementToBeClickable("Accountcountry");
		selenium.click("Accountcountry");
//		selenium.waitingTime(2000);
		//selenium.refresh();
		selenium.waitForElementToBeVisible("AccountHUbcountrycode");
		accountHubcountrycode=selenium.getText("AccountHUbcountrycode");
	}
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
}

	@And("^I validate contact region based on accountry country hub code$")
       public void i_validate_contact_region_based_on_accountcountryhubcode() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to contact");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactLink");
				selenium.click("contactLink");
				selenium.clickDynamic("anchorTitle", "Contact Name", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("Region");
				String contactRegion=selenium.getText("Region");
				if(accountHubcountrycode.equalsIgnoreCase(contactRegion))
				{
					selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}		
}
