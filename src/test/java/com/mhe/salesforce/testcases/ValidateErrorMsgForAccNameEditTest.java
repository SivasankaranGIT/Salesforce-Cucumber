package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateErrorMsgForAccNameEditTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account Name details$")
	public void i_edit_account_Name_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
//				selenium.scrolldown(200);
//				selenium.waitingTime(2000);
//				selenium.clickLoop("Select_Case");
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
//				selenium.waitingTime(2000);
				//selenium.hoverAndClick("editAccount");
				//selenium.scrollToElement("serach_Account");
//				selenium.waitingTime(4000);
				//selenium.click("deleteIcon");
				selenium.waitForElementToBeVisible("AccountnameEditUS");
				selenium.clearText("AccountnameEditUS");
				selenium.waitingTime(1000);
				selenium.type("AccountnameEditUS", "New Account Name");
			
			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("AccountNameC");
				selenium.clearText("AccountNameC");
				selenium.enterData("AccountNameC", "New Account Name");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for account Name edit successfully$")
    public void validate_error_message_for_account_Name_edit_successfully() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("accntNameEditError");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
		if(error.contains(expected_error)) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			
		}
		else {
			selenium.click("CancelEdit");
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
		}
			else if (selenium.getUI().equalsIgnoreCase("classic")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
			error = selenium.getText("errorText");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
		if(error.contains(expected_error)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		}
		else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
			}
	}	
	@When("^I search for Account Name$")
    public void searchAccount() {
	selenium.search("Account Name");
	}
}
