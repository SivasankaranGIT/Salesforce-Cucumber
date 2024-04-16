package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ValidateCaseCategoryDropdownTest 
{
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to Cases item tab$")
	public void i_navigate_to_case_tab()
	{
		try {
			selenium.navigateToCasesTab();
		}
		catch (Exception e) {
			selenium.reportFailure("Error while navigating to cases tab " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^I create New A3K Cases and validate the Category fields$")
	public void i_create_new_a3k_case_and_validate_categories() {
		try {

			selenium.waitingTime(2000);
			selenium.createCaseAndValidateCategory();
		} catch (Exception e) {
			selenium.reportFailure("Error while creating new case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
